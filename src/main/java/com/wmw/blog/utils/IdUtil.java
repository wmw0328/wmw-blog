package com.wmw.blog.utils;

import java.util.UUID;

/**
 * @Author miaowen.wmw
 * @Date 2021/6/16 9:11 上午
 * @Version 1.0
 */
public class IdUtil {

    public static String createUid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
