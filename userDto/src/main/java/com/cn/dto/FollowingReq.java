package com.cn.dto;

import lombok.Data;

@Data
public class FollowingReq {
    private int userId;
    private int followingUserId;
    private String userName;
    private String followingUserName;
}
