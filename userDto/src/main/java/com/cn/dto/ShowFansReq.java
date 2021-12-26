package com.cn.dto;

import lombok.Data;

@Data
public class ShowFansReq extends PageRequest{
    private int userId;
}
