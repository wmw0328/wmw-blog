package com.wmw.blog.utils;

import com.wmw.blog.common.domain.Result;

/**
 * @Author miaowen.wmw
 * @Date 2021/6/11 4:07 下午
 * @Version 1.0
 */
public class ResultUtil {
    public ResultUtil() {
    }

    public static Result success() {
        return success((Object)null);
    }

    public static Result success(Object data) {
        Result ret = new Result();
        ret.setCode(200);
        ret.setMessage("success");
        ret.setData(data);
        return ret;
    }

    public static Result success(int code, String msg) {
        Result ret = new Result();
        ret.setCode(code);
        ret.setMessage(msg);
        return ret;
    }

    public static Result success(String msg, Object data) {
        Result ret = new Result();
        ret.setCode(200);
        ret.setMessage(msg);
        ret.setData(data);
        return ret;
    }

    public static Result success(int code, Object data) {
        Result ret = new Result();
        ret.setCode(code);
        ret.setMessage("success");
        ret.setData(data);
        return ret;
    }

    public static Result success(int code, String msg, Object data) {
        Result ret = new Result();
        ret.setCode(code);
        ret.setMessage(msg);
        ret.setData(data);
        return ret;
    }

    public static Result fail(String message) {
        Result ret = new Result();
        ret.setCode(500);
        ret.setMessage(message);
        return ret;
    }

    public static Result fail(int code, String message) {
        Result ret = new Result();
        ret.setCode(code);
        ret.setMessage(message);
        return ret;
    }

    public static Result fail(String message, Object data) {
        Result ret = new Result();
        ret.setCode(500);
        ret.setMessage(message);
        ret.setData(data);
        return ret;
    }

    public static Result fail(int code, String msg, Object data) {
        Result ret = new Result();
        ret.setCode(code);
        ret.setMessage(msg);
        ret.setData(data);
        return ret;
    }
}