package com.learning.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户实体类")
public class User {
    @Schema(required = true, description = "用户id")
    private Long id;
    // required：提示这个参数是否必须
    // description：提示变量的意义、作用
    // example：给出参数的示例值，ui 进行示例展示时会引用这个值
    // name:参数变量名称
    @Schema(name = "name",required = true, description = "用户名称",example = "小明")
    private String name;
    // allowableValues：提示该参数允许设置的值，ui 进行示例展示时会随机选取一个展示
    @Schema(allowableValues = {"1","2"})
    private Integer age;
    // hidden：隐藏参数不在 api 中显示
    @Schema(hidden = true)
    private String address;
}
