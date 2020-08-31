package com.example.jfrd.modular.user.controller;

import com.example.jfrd.modular.user.pojo.User;
import com.example.jfrd.modular.user.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public User login(@Param(value = "username") String username, @Param(value = "password") String password){
        return userService.login(username,password);
    }

    @RequestMapping(value = "/userInfo/{id}",method = RequestMethod.GET)
    public User queryById(@PathVariable int id){
        return userService.userById(id);
    }

    @RequestMapping(value = "/user/add",method = RequestMethod.GET)
    public void addUser(){
        User user = new User();
        user.setUsername("小红");
        user.setPassword("123456");
        userService.addUser(user);
    }
}
