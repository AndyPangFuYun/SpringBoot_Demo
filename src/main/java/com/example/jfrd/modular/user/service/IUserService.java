package com.example.jfrd.modular.user.service;

import com.example.jfrd.modular.user.pojo.User;
import com.example.jfrd.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public interface IUserService {

    /**
     * 根据Id查询用户
     *
     * @param id 用户id
     * @return 查询到的用户
     */
    JsonResult userById(String id);

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
    JsonResult login(String username, String password, HttpServletRequest request, HttpServletResponse response);

    /**
     * 修改
     * @param user 用户信息
     * @return JsonResult全局信息
     */
    JsonResult updateUser(User user);
}
