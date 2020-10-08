package com.example.jfrd.config;

import com.example.jfrd.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //所要拦截的请求路径
    String[] addPathPatterns = {
            "/*/**"
    };

    //不需要拦截的请求路径
    String[] excludePathPatterns = {
            "/user/login",
            "/login.html",
            "/location/add",
            "/css/**",
            "/fonts/**",
            "/images/**",
            "/js/**",
            "/lib/**",
            "/ueditor/**"
    };

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
}
