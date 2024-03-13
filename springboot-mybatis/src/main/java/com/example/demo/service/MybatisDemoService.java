package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.mapper.MybatisDemoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MybatisDemoService {
    @Resource
    private MybatisDemoMapper mybatisDemoMapper;

    public List<User> listUser() {
        return mybatisDemoMapper.listUser();
    }
}
