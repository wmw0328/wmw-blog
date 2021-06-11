package com.wmw.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wmw.blog.common.domain.PageList;
import com.wmw.blog.entity.User;
import com.wmw.blog.mapper.UserMapper;
import com.wmw.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author miaowen.wmw
 * @Date 2021/6/11 3:16 下午
 * @Version 1.0
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.selectList(null);
    }

    @Override
    public PageList<User> getUserPageList(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<User> userList = userMapper.selectList(null);
        PageInfo<User> page = new PageInfo<>(userList);
        return new PageList<>(page.getTotal(),page.getPageNum(),page.getPageSize(),userList);

    }
}
