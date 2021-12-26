package com.cn.controller;

import com.cn.dto.ShowFansReq;
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


    @GetMapping("/{userId}")
    PageInfo<UserFollow> showFans(@PathVariable ShowFansReq req) {
        return followService.showFans(req);
    }


    @PutMapping("/{id}")
    /*
    todo UpdateReq not work
     */
    String update(@PathVariable int id, @RequestBody UserDetail user) {
        if (userService.update(id, user)) {
            return "success to update user";
        }
        return "fail to update user";
    }


    @PostMapping(value = "/", produces = {"application/json;charset=UTF-8"})
    String create(@Valid @RequestBody UserDetail user) {
        if (userService.create(user)) {
            return "success to create user";
        }
        return "fail to create user";
    }



    @DeleteMapping(value = "/{userId}", produces = {"application/json;charset=UTF-8"})
    String deleteUser(@PathVariable int userId) {
        if (userService.delete(userId)) {
            return "success to delete user";
        }
        return "fail to delete user";
    }
}
