package com.cn.service;

import com.cn.dto.ShowFansReq;
import com.cn.entity.UserDetail;
import com.cn.entity.UserFollow;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;

public interface UserFollowService {
    PageInfo<UserFollow> showFans(ShowFansReq req);
}
