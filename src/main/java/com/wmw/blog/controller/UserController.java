package com.wmw.blog.controller;

import com.wmw.blog.common.domain.Result;
import com.wmw.blog.entity.User;
import com.wmw.blog.service.UserService;
import com.wmw.blog.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author miaowen.wmw
 * @Date 2021/6/16 9:31 上午
 * @Version 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(" 新增注册用户")
    @PostMapping("saveUser")
    public Result<String> saveUser(@RequestBody User user){
        boolean result = userService.saveUser(user);
        if(!result){
            return ResultUtil.fail("用户已存在");
        }
        return ResultUtil.success();
    }

    @ApiOperation("用户登录")
    @GetMapping("/login")
    public Result<String> login(User user){
        boolean result = userService.loginUser(user);
        if(!result){
            return ResultUtil.fail("用户名或密码错误");
        }
        return ResultUtil.success();
    }
}
