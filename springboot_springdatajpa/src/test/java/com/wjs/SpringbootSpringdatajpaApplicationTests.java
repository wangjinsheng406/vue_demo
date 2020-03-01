package com.wjs;

import com.wjs.dao.IUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootSpringdatajpaApplication.class)
public class SpringbootSpringdatajpaApplicationTests {
    @Autowired
    private IUserDao iUserDao;
    @Test
    public void test() {
        System.out.println(iUserDao.findAll());
    }
}
