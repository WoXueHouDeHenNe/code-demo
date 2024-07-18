package com.example.demo.controller;

import com.example.demo.bean.User;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @GetMapping("/info")
    public User getUser(@Nonnull BigInteger id, @Nullable @CookieValue String sex) {
        log.info("#UserController.getUser, id: {}, sex: {}", id, sex);
        User user = new User(id, null, null);
        user.setId(id);
        log.info("#UserController.getUser, user: {}, sex: {}", user, sex);
        return user;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        log.info("#UserController.createUser, user: {}", user);
        return user;
    }
}
