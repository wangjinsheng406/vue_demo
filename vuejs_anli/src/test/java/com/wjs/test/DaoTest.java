package com.wjs.test;

import com.wjs.domain.User;
import com.wjs.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 用户业务层的测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DaoTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void testFindAll(){
        List<User> list = iUserService.findAll();
        System.out.println(list);
    }
    @Test
    public void testFindById(){
        User user = iUserService.findById(2);
        System.out.println(user);
    }
    @Test
    public void testUpdate(){
        User user = iUserService.findById(2);
        user.setAge(56);
        iUserService.update(user);
        User user1 = iUserService.findById(2);
        System.out.println(user1);
    }
}
