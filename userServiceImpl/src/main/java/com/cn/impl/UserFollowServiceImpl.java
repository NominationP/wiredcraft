package com.cn.impl;

import com.cn.dto.ShowFansReq;
import com.cn.entity.UserDetail;
import com.cn.entity.UserFollow;
import com.cn.service.UserFollowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.ArrayList;

public class UserFollowServiceImpl implements UserFollowService {

    @Resource
    UserFollowMapper followMapper;

    @Override
    public PageInfo<UserFollow> showFans(ShowFansReq req) {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());

        ArrayList<UserFollow> follows = followMapper.selectByUserId(userId);

        return new PageInfo<UserFollow>(follows);
    }
}
