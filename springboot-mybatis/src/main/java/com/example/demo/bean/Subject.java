package com.example.demo.bean;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Subject {
    private BigInteger userId;

    private String subjectName;
}
