package com.cn.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HttpResponse {
    private Integer code;
    private String msg;
}