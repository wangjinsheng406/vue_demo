package com.wjs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wjs.dao.IUserDao;
import com.wjs.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootSpringdatajpaApplication.class)
public class RedisTest {
    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    public void testRedis() throws JsonProcessingException {
        //1.从redis中获取数据,数据的格式为json字符串
        String userListJson = redisTemplate.boundValueOps("user.findall").get();
        //2.判断redis中是否存在数据
        if (userListJson == null) {
            //3.若不存在数据,则从数据库中查询
            List<User> all = iUserDao.findAll();
            //4.将查询到的数据存储到redis缓存中
            //将List集合中的数据转换为json格式的字符串,使用jackson进行转换
            ObjectMapper objectMapper = new ObjectMapper();
            userListJson = objectMapper.writeValueAsString(all);
            redisTemplate.boundValueOps("user.findall").set(userListJson);
            System.out.println("===============从数据库中获取user数据================");
        }else{
            System.out.println("===============从redis缓存中获取user数据================");
        }
        //5.将数据打印到控制台
        System.out.println(userListJson);
    }
}
