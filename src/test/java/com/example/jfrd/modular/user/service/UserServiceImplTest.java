package com.example.jfrd.modular.user.service;

import com.example.jfrd.modular.user.pojo.User;
import com.example.jfrd.modular.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void login(){
        userServiceImpl.login("Andy~","123456");
    }

    @Test
    void queryById() {
        System.out.println(userServiceImpl.userById(1));
    }

    @Test
    void addUser() {
        User user = new User();
        user.setUsername("Andy~");
        user.setPassword("66668888");
        user.setSex(0);
        user.setName("安迪");
        user.setBirthday(new Date());
        user.setEmail("1160292399@qq.com");
        user.setPhone("18178785236");
        user.setRoleId("2020082720");
        user.setDeptId("2020082720");
        user.setStatus(1);
        user.setCreateTime(new Date());
        userServiceImpl.addUser(user);
    }

}