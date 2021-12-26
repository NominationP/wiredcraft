package com.cn.dto;

import lombok.Data;


@Data
public class UnfollowingReq {
    private int userId;
    private int unfollowingUserId;
}
