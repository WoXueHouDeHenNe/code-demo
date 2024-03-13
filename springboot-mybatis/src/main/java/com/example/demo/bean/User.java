package com.example.demo.bean;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class User {
    private BigInteger id;

    private String userName;

    private List<String> subjects;
}
