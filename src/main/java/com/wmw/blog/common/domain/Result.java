package com.wmw.blog.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author miaowen.wmw
 * @Date 2021/6/11 3:31 下午
 * @Version 1.0
 */


@Data
public class Result<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public Result() {
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "Result [code=" + this.code + ", message=" + this.message + ", data=" + this.data + "]";
    }
}