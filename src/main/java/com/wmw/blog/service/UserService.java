package com.wmw.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wmw.blog.common.domain.PageList;
import com.wmw.blog.entity.User;

import java.util.List;

/**
 * @Author miaowen.wmw
 * @Date 2021/6/11 3:10 下午
 * @Version 1.0
 */

public interface UserService extends IService<User> {

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> getUserList();

    /**
     * 分页获取所有用户信息
     * @return
     */
    PageList<User> getUserPageList(Integer pageNo, Integer pageSize);

}
