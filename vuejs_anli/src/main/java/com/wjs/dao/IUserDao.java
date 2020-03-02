package com.wjs.dao;

import com.wjs.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
     List<User> findAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
     User findById(Integer id);

    /**
     * 更新用户信息
     * @param user
     */
    @Update("update user set username=#{username},password=#{password},sex=#{sex},age=#{age},email=#{email} where id = #{id}")
    void update(User user);
}
