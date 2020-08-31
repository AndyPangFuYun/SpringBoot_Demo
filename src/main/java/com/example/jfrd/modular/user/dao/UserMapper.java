package com.example.jfrd.modular.user.dao;

import com.example.jfrd.modular.user.pojo.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 查询到的用户
     */
    User userById(int id);

    /**
     * 新增用户
     * @param user 用户信息
     */
    void addUser(User user);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    User login(@Param("username") String username,@Param("password") String password);
}
