package com.wjs.service.impl;

import com.wjs.dao.IUserDao;
import com.wjs.domain.User;
import com.wjs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public List<User> findAll() {
        return iUserDao.findAll();
    }

    @Override
    public User findById(Integer id) {
        return iUserDao.findById(id);
    }

    @Override
    public void update(User user) {
        iUserDao.update(user);
    }
}
