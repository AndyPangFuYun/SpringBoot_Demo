package com.example.jfrd.modular.user.service.impl;

import com.example.jfrd.modular.user.dao.UserMapper;
import com.example.jfrd.modular.user.pojo.User;
import com.example.jfrd.modular.user.service.IUserService;
import com.example.jfrd.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public JsonResult login(String username, String password,HttpServletRequest request,HttpServletResponse response) {
        JsonResult jsonResult = new JsonResult();

        if (username == null || username.trim().length() == 0){
            jsonResult.setCode("500");
            jsonResult.setMessage("请输入用户名！");
            return jsonResult;
        }

        if (password == null || password.trim().length() == 0){
            jsonResult.setCode("500");
            jsonResult.setMessage("请输入密码！");
            return jsonResult;
        }
        User user = userMapper.login(username, password);

        //用户是否存在
        if (user != null) {
            String strPassword = password.concat(user.getSalt());
            String passwordMD5 = encrypt(strPassword);

            if (user.getPassword().equals(passwordMD5)) {
                request.getSession().setAttribute("user",user);
                jsonResult.setCode("200");
                jsonResult.setMessage("登录成功");
            }else {
                //密码错误
                jsonResult.setCode("500");
                jsonResult.setMessage("密码错误，请重试");
            }
        }else {
            //用户不存在
            jsonResult.setCode("400");
            jsonResult.setMessage("没有此用户，请重试");
        }
        return jsonResult;
    }

    @Override
    public JsonResult updateUser(User user) {
        JsonResult jsonResult = new JsonResult();
        if (user != null){
            if (user.getUsername().isEmpty()){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入用户名");
                return jsonResult;
            }
            if (user.getPassword().isEmpty()){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入密码");
                return jsonResult;
            }
            if (user.getEmail().isEmpty()){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入邮箱");
                return jsonResult;
            }
            if (user.getPhone().isEmpty()){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入联系方式");
                return jsonResult;
            }

        }else {
            jsonResult.setCode("500");
            jsonResult.setMessage("服务器：修改失败，请刷新后重试");
            return jsonResult;
        }
        try {
            User userobj = userMapper.userById(user.getId());
            userobj.setUsername(user.getUsername());
            String salt = getRandomString(32);
            Date date= new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(date);

            Long longDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(dateString).getTime();
            String password = user.getPassword().concat(salt + longDate);
            String MD5Password = encrypt(password);

            userobj.setSalt(salt + longDate);
            userobj.setPassword(MD5Password);
            userobj.setName(user.getName());
            userobj.setPhone(user.getPhone());
            userobj.setEmail(user.getEmail());
            userobj.setCreateTime(formatter.format(date));

            int success = userMapper.updateUser(userobj);
            if (success == 1){
                jsonResult.setCode("200");
                jsonResult.setMessage("服务器：修改成功");
            } else {
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：修改失败，请刷新后重试");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }

    //根据id查询用户
    public JsonResult userById(String id) {
        JsonResult jsonResult = new JsonResult();
        Map<Object,Object> map = new HashMap<>();
        User user = userMapper.userById(id);
        if (user != null){
            jsonResult.setCode("200");
            jsonResult.setMessage("服务器：查询成功");
            map.put("user",user);
            jsonResult.setMap(map);
        } else {
            jsonResult.setCode("500");
            jsonResult.setMessage("服务器：没有此用户");
        }
        return jsonResult;
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