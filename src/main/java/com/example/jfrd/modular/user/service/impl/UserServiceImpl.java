package com.example.jfrd.modular.user.service.impl;

import com.example.jfrd.config.BizExceptionEnum;
import com.example.jfrd.config.GuiMedicalException;
import com.example.jfrd.modular.user.dao.UserMapper;
import com.example.jfrd.modular.user.pojo.User;
import com.example.jfrd.modular.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.jfrd.util.MD5Util.encrypt;
import static com.example.jfrd.util.MD5Util.getRandomString;

/**
 * 
 */
@Service
public class UserServiceImpl implements IUserService { //测试该类快捷键Ctrl+Shift+T

    @Autowired
    private UserMapper userMapper;

    //登录
    public User login(String username, String password) {
        User user = userMapper.login(username, password);
        //用户不存在
        if (user == null) {
            throw new GuiMedicalException(BizExceptionEnum.USER_NOT_EXISTED.getCode(),BizExceptionEnum.USER_NOT_EXISTED.getMessage());
        }
        String strPassword = password.concat(user.getSalt());
        String passwordMD5 = encrypt(strPassword);
        //密码错误
        if (!user.getPassword().equals(passwordMD5)) {
            throw new GuiMedicalException(BizExceptionEnum.USER_NOT_EXISTED.getCode(),BizExceptionEnum.USER_NOT_EXISTED.getMessage());
        }
        return user;
    }

    //根据id查询用户
    public User userById(int id) {
        return userMapper.userById(id);
    }

    //新增用户
    public void addUser(User user) {
        String salt = getRandomString(32);
        Date date= new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        try {
            Long longDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(dateString).getTime();
            String password = user.getPassword().concat(salt + longDate);
            String MD5Password = encrypt(password);
            user.setSalt(password);
            user.setPassword(MD5Password);
            userMapper.addUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}