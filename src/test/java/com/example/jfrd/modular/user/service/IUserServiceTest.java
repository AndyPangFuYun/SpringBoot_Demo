package com.example.jfrd.modular.user.service;

import com.example.jfrd.modular.user.pojo.User;
import com.example.jfrd.modular.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IUserServiceTest {

    @Autowired
    private UserServiceImpl service;

    @Test
    void userById(){
        System.out.println(service.userById("1"));
    }
}