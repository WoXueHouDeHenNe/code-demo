package com.example.demo.controller;

import com.example.demo.bean.User;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Collections;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/info")
    public User getUser() {
        User user = new User();
        user.setId(BigInteger.ONE);
        user.setHobby(Collections.emptyList());
        return user;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        System.out.println(user);
        return user;
    }
}
