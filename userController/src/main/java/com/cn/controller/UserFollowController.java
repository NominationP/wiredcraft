package com.cn.controller;

import com.cn.dto.FollowingReq;
import com.cn.dto.ShowFansReq;
import com.cn.dto.ShowFollowingReq;
import com.cn.dto.UnfollowingReq;
import com.cn.entity.UserDetail;
import com.cn.entity.UserFollow;
import com.cn.service.UserDetailService;
import com.cn.service.UserFollowService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/userFollow")
public class UserFollowController {
    @Autowired
    UserFollowService followService;


    @RequestMapping(value = "/showFans")
    PageInfo<UserFollow> showFans(@RequestBody ShowFansReq req) {
        return followService.showFans(req);
    }

    @RequestMapping(value = "/showFollowing")
    PageInfo<UserFollow> showFans(@RequestBody ShowFollowingReq req) {
        return followService.showFollowing(req);
    }

    @RequestMapping(value = "/following")
    String showFans(@RequestBody ArrayList<FollowingReq> reqs) {
        return followService.following(reqs) ? "关注成功" : "关注失败";
    }

    @RequestMapping(value = "/unfollowing")
    String unFollowing(@RequestBody UnfollowingReq req) {
        return followService.unFollowing(req) ? "取关成功" : "取关失败";
    }





}
