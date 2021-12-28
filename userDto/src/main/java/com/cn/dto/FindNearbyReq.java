package com.cn.dto;

import com.cn.entity.UserDetail;
import lombok.Data;

@Data
public class FindNearbyReq {
    UserDetail userDetail;
    int distance;
    int count;
}
