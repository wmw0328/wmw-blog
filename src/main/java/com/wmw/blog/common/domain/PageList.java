package com.wmw.blog.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author miaowen.wmw
 * @Date 2021/6/11 3:29 下午
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class PageList<E> implements Serializable {

    /**
     * 总条数
     */
    private long total;

    /**
     * 当前页码
     */
    private int pageNum;

    /**
     * 每页条数
     */
    private int pageSize;

    /**
     * 💻内容
     */
    private List<E> rows;

}