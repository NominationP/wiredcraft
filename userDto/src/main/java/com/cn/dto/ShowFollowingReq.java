package com.cn.dto;

import lombok.Data;

@Data
public class ShowFollowingReq extends PageRequest{
    private int userId;
}
