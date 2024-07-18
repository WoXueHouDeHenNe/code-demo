package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 启用 aop 自动代理
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringBootAopApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class, args);
    }
}
