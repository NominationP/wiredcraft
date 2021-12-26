package com.cn.dto;

import lombok.Data;

import java.util.ArrayList;

/**
 * 分页请求
 */
@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 每页数量
     */
    private int pageSize = 6;

    /**
     * 总页数
     */

    private int pages;

    /**
     * 总的数量
     */
    private long totalNum;


}
