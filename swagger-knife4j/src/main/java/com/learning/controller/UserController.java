package com.learning.controller;

import com.learning.bean.ReturnMessage;
import com.learning.bean.Role;
import com.learning.bean.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "用户类接口")
public class UserController {
    /**
     * 测试参数、返回值是基本类型的 swagger文档
     * @param userId
     * @return
     */
    @GetMapping("/getUserInfo")
    @Operation(summary = "获取用户信息")
    public String getUserInfo(@Parameter(name = "userId",description = "用户id") String userId) {
        return userId;
    }


    /**
     * 测试参数、返回值是对象的 swagger文档
     * @param user
     * @return
     */
    @PostMapping(value = "/addUser")
    @Operation(summary = "添加用户信息")
    public User addUser(@RequestBody User user) {
        return user;
    }


    /**
     * 设置请求头、cookie等信息
     * @param roleName 角色名称
     * @param userId 用户id
     * @return 角色信息
     */
    @PostMapping("/addRole")
    @Operation(summary = "添加角色信息")
    @Parameters({
            @Parameter(name = "reqId",description = "请求id",required = true,in = ParameterIn.HEADER),
            @Parameter(name = "token",description = "请求token",required = true,in = ParameterIn.COOKIE),
            @Parameter(name = "roleName",description = "角色名称",required = true,in=ParameterIn.QUERY),
            @Parameter(name = "userId",description = "用户id",required = true,in=ParameterIn.QUERY)
    })
    public Role addRole(String roleName, Long userId) {
        Role role = new Role();
        role.setRoleName(roleName);
        role.setUserId(userId);
        return role;
    }

    /**
     * 测试路径参数
     * @param roleId 角色id
     * @return
     */
    @DeleteMapping("/{roleId}")
    @Operation(summary = "删除角色信息")
    @Parameters({
            @Parameter(name = "roleId",description = "角色id",in = ParameterIn.PATH)
    })
    public void deleteRole(@PathVariable Long roleId) {
    }



    /**
     * 测试范型
     * @param roleId 角色id
     * @return
     */
    @DeleteMapping("/getRole")
    @Operation(summary = "查询角色信息")
    public ReturnMessage<Role> getRole(@Parameter(name = "roleId", description = "角色id") Long roleId) {
        return ReturnMessage.success(new Role());
    }
}
