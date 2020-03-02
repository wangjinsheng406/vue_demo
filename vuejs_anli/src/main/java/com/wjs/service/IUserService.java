package com.wjs.service;

import com.wjs.domain.User;
import java.util.List;

public interface IUserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);

}
