package com.example.jfrd.modular.user.service;

import com.example.jfrd.modular.user.mapper.UserMapper;
import com.example.jfrd.modular.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //根据id查询用户
    public User queryById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    //新增用户
    public void addUser(User user) {
        userMapper.insertSelective(user);
    }
}
