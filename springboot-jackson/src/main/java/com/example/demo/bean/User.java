package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class User {

    private BigInteger id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userName;

    private GenderEnum gender;

    // 仅对空集合生效, 对于空字符串不生效
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> hobby;
}
