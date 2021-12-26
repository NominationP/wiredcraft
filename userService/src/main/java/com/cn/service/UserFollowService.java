package com.cn.service;

import com.cn.dto.FollowingReq;
import com.cn.dto.ShowFansReq;
import com.cn.dto.ShowFollowingReq;
import com.cn.dto.UnfollowingReq;
import com.cn.entity.UserDetail;
import com.cn.entity.UserFollow;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;

public interface UserFollowService {
    PageInfo<UserFollow> showFans(ShowFansReq req);

    PageInfo<UserFollow> showFollowing(ShowFollowingReq req);

    boolean following(ArrayList<FollowingReq> reqs);

    boolean unFollowing(UnfollowingReq req);
}
