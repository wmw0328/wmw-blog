package com.wmw.blog.controller.admin;

import com.wmw.blog.common.domain.PageList;
import com.wmw.blog.entity.User;
import com.wmw.blog.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author miaowen.wmw
 * @Date 2021/6/11 3:01 下午
 * @Version 1.0
 */


@RestController
@RequestMapping("/")
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




}
