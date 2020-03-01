package com.wjs.dao;

import com.wjs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserDao extends JpaRepository<User,Integer> {
    List<User> findAll();
}
