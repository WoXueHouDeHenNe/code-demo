package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.MybatisDemoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MybatisDemoController {
    @Resource
    private MybatisDemoService mybatisDemoService;

    @GetMapping("/list")
    public List<User> listUser() {
        return mybatisDemoService.listUser();
    }
}
