package com.example.jfrd.modular.user.controller;

import com.example.jfrd.modular.user.pojo.User;
import com.example.jfrd.modular.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User queryById(@PathVariable int id){
        return userService.queryById(id);
    }

    @RequestMapping(value = "/user/add",method = RequestMethod.GET)
    public void addUser(){
        User user = new User();
        user.setUsername("小红");
        user.setPassword("123456");
        userService.addUser(user);
    }
}
