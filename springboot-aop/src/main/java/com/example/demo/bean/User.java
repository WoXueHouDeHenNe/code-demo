package com.example.demo.bean;

import com.example.demo.aop.I18n;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Nonnull
    private BigInteger id;

    @I18n
    private String userName;

    private List<String> hobby;
}
