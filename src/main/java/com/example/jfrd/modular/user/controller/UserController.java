package com.example.jfrd.modular.user.controller;

import com.example.jfrd.modular.user.pojo.User;
import com.example.jfrd.modular.user.service.IUserService;
import com.example.jfrd.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @CrossOrigin
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult login(@Param(value = "username") String username, @Param(value = "password") String password,HttpServletRequest request,HttpServletResponse response){
        JsonResult jsonResult =  userService.login(username,password);
        HttpSession session = request.getSession();
        session.setAttribute("user",jsonResult.getMap());
        return jsonResult;
    }

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public User queryById(@PathVariable String id){
        return userService.userById(id);
    }

    @RequestMapping(value = "/user/add",method = RequestMethod.GET)
    public void addUser(){
        User user = new User();
        user.setUsername("小红");
        user.setPassword("123456");
        userService.addUser(user);
    }

    /**
     * 修改
     * @param user 用户信息
     * @return  成功 200 ，失败 500
     */
    @RequestMapping(value = "/update" , method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public JsonResult updateUser(@RequestBody  User user){
        JsonResult jsonResult = userService.updateUser(user);
        return jsonResult;
    }

    /**
     * 注销登录
     * @return jsonResult
     */
    @RequestMapping(value = "/exit" , method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public JsonResult exit(HttpServletRequest request,HttpServletResponse response){
        JsonResult jsonResult = new JsonResult();
        request.getSession().removeAttribute("user");
        jsonResult.setCode("200");
        jsonResult.setMessage("注销成功");
        return jsonResult;
    }

}
