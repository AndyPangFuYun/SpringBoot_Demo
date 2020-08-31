package com.example.jfrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * spring boot 工程都有一个启动引导类，这是工程的入口
 * 并在引导类上添加 @SpringBootApplication
 */
@SpringBootApplication//禁用系统自动启用自动配置的数据源 - 因为我们要自己定义数据源 所以要禁用
//扫描mybatis所有的业务mapper接口
//@MapperScan("com.example.demo.modular.user.mapper")
@MapperScan("com.example.jfrd.modular.*.dao")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
