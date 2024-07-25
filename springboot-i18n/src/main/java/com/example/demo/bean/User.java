package com.example.demo.bean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class User {
    @NotEmpty(message = "{TEST_VALIDATION}")
    private String name;
}
