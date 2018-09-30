package com.springboot.wsh.controller;

import com.springboot.wsh.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: UserController
 * @ProjectName springboot_swagger
 * @Description: 用户Controller
 * @Author WeiShiHuai
 * @Date 2018/9/29 17:49
 * <p>
 * 说明: Swagger的好处
 * 1. 简单方便、自动生成文档、调试方便、方便前后端对接
 * 2. 减少前后台的研发沟通成本，相对文档化的资源，支持简单的手工测试
 */
@RestController
@RequestMapping("/user")
//@Api: 标识该Controller的功能
@Api("用户-相关服务Api")
public class UserController {

    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1L, "zhangsan", "123456"));
        userList.add(new User(2L, "lisi", "654321"));
    }

    @GetMapping("/getUserList")
    //@ApiOperation: 标识该接口的作用
    @ApiOperation(value = "获取用户列表信息", notes = "获取用户列表信息", httpMethod = "GET")
    public List<User> getUserList() {
        return userList;
    }

    @GetMapping("/getUserInfo/{id}")
    @ApiOperation(value = "根据id获取用户信息", notes = "根据id获取用户信息", httpMethod = "GET")
    //@ApiImplicitParam: 标识接口中参数的类型、是否必填、描述等
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "Long", paramType = "path", required = true)
    public User getUserInfo(@PathVariable("id") Long id) {
        return userList.get(id.intValue());
    }

    @GetMapping("/getUserById")
    @ApiOperation(value = "根据id获取用户信息2", notes = "根据id获取用户信息2", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "Long", paramType = "query", required = true)
    public User getUserById(@RequestParam("id") Long id) {
        return userList.get(id.intValue());
    }

    @PostMapping("/saveUser")
    @ApiOperation(value = "保存用户信息", notes = "保存用户信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体信息", required = true, paramType = "body", dataType = "User")
    })
    public String saveUser(@RequestBody User user) {
        userList.add(user);
        return "save user success!!";
    }

    @PostMapping("/updateUser/{id}")
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户实体信息", required = true, paramType = "body", dataType = "User")
    })
    public String updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userList.set(id.intValue(), user);
        return "update user success!!";
    }


    @PostMapping("/deleteUser/{id}")
    @ApiOperation(value = "根据用户id删除用户信息", notes = "根据用户id删除用户信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path", dataType = "Long")
    })
    public String deleteUser(@PathVariable("id") Long id) {
        userList.remove(id.intValue());
        return "delete user success";
    }

    @ApiOperation(value = "批量删除用户信息", notes = "批量删除用户信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "pkids", dataType = "List", required = true, value = "主键")
    })
    @PostMapping(value = "/deleteByMulti")
    public String deleteByMulti(@RequestBody List<String> pkids) {
        //批量删除逻辑
        return "deleteByMulti success";
    }

    //@ApiIgnore: 忽略该接口，不生成该接口对应的文档
    @ApiIgnore
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

}
