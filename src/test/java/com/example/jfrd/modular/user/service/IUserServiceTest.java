package com.example.jfrd.modular.user.service;

import com.example.jfrd.modular.user.pojo.User;
import com.example.jfrd.modular.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.jfrd.util.MD5Util.encrypt;
import static com.example.jfrd.util.MD5Util.getRandomString;

@SpringBootTest
class IUserServiceTest {

    @Autowired
    private UserServiceImpl service;

    @Test
    void userById(){
        System.out.println(service.userById("1"));
    }

    @Test
    void addUser(){
        String salt = getRandomString(32);
        String password = "123456".concat(salt);
        String MD5Password = encrypt(password);
        System.out.println("password======:" + password);
        System.out.println("MD5Password===:" + MD5Password);
    }
}