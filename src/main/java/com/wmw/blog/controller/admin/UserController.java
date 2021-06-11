package com.wmw.blog.controller.admin;

import com.wmw.blog.common.domain.PageList;
import com.wmw.blog.common.domain.Result;
import com.wmw.blog.entity.User;
import com.wmw.blog.service.UserService;
import com.wmw.blog.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author miaowen.wmw
 * @Date 2021/6/11 3:01 下午
 * @Version 1.0
 */

@Api(tags = "用户管理")
@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("获取所有用户列表")
    @GetMapping("/getUserList")
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @ApiOperation("分页获取所有用户列表")
    @GetMapping("/getUserPageList")
    public PageList<User> getUserPageList(Integer pageNo, Integer pageSize){
        return userService.getUserPageList(pageNo, pageSize);
    }

    @ApiOperation(" 新增注册用户")
    @PostMapping("saveUser")
    public Result saveUser(@RequestBody User user){
      boolean result = userService.saveUser(user);
      if(!result){
          return ResultUtil.fail("用户已存在");
      }
      return ResultUtil.success();
    }

}
