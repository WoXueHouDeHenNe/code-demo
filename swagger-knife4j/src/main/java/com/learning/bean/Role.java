package com.learning.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "角色实体类")
public class Role {
    @Schema(required = true, description = "角色id")
    private Long id;
    @Schema(required = true, description = "用户id")
    private Long userId;
    @Schema(required = true, description = "角色名称")
    private String roleName;
    @Schema(description = "权限列表")
    private List<String> authorized;
}
