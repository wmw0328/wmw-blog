package com.wmw.blog.utils;

import org.springframework.util.DigestUtils;

/**
 * @Author miaowen.wmw
 * @Date 2021/6/16 9:14 上午
 * @Version 1.0
 */
public class MD5Util {

    public static String passwordToMD5(String password){
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
