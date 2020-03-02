package com.wjs.controller;

import com.wjs.domain.User;
import com.wjs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/find_all")
    public List<User> findAll() {
        System.out.println("test");
        return iUserService.findAll();
    }

    @RequestMapping("/find_by_id")
    public User findById(Integer id) {
        return iUserService.findById(id);
    }

    @RequestMapping("/update")
    public void update(@RequestBody User user) {
        System.out.println(user);
        iUserService.update(user);
    }
}
