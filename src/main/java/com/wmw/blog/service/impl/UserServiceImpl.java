package com.wmw.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wmw.blog.common.domain.PageList;
import com.wmw.blog.entity.User;
import com.wmw.blog.mapper.UserMapper;
import com.wmw.blog.service.UserService;
import com.wmw.blog.utils.IdUtil;
import com.wmw.blog.utils.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
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

    @Override
    public boolean saveUser(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_name",user.getUserName());
        if(userMapper.selectCount(wrapper) > 0){
            return false;
        }
        user.setUserId(IdUtil.createUid());
        user.setStatus(1);
        user.setRoleId(1);
        user.setCreateTime(new Date());

        String password = user.getPassword();
        user.setPassword(MD5Util.passwordToMD5(password));
        int count = userMapper.insert(user);
        return count > 0;
    }

    @Override
    public boolean loginUser(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_name",user.getUserName());
        if(userMapper.selectCount(wrapper) == 0){
            return false;
        }
        wrapper.eq("password",MD5Util.passwordToMD5(user.getPassword()));
        if(userMapper.selectCount(wrapper) == 0){
            return false;
        }
        return true;



    }
}
