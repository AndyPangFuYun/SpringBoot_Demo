package com.example.jfrd.modular.user.service;

import com.example.jfrd.modular.user.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    /**
     * 根据Id查询用户
     *
     * @param id 用户id
     * @return 查询到的用户
     */
    User userById(int id);

    /**
     * 添加用户
     *
     * @param user 新增的用户信息
     */
    void addUser(User user);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    Object login(String username, String password);
}
