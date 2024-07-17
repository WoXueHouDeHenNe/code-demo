package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * springboot 默认是按枚举的名称来映射枚举类的，且区分大小写
 */
public enum GenderEnum {
    man("man"),
    Man("man"),
    woman("woman");

    @Getter
    private String sex;

    private GenderEnum(String sex) {
        this.sex = sex.toLowerCase();
    }

    @JsonCreator
    public static GenderEnum value(String sex) {
        System.out.println("正在反序列化成对象" + sex);
        for (GenderEnum value : values()) {
            System.out.println(value);
            if (value.getSex().equals(sex.toLowerCase()) && value.name().matches("^.*[A-Z]{1,}.*$")) {
                return value;
            }
        }
        return null;
    }

    @JsonValue
    public String value() {
        return name();
    }


}
