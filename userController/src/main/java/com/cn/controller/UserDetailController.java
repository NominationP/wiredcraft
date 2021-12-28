package com.cn.controller;

import com.cn.service.UserDetailService;
import com.cn.entity.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/userDetail")
public class UserDetailController {
    @Autowired
    UserDetailService userService;


    @GetMapping("/{id}")
    UserDetail getDetail(@PathVariable int id) {
        return userService.get(id);
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



    @DeleteMapping(value = "/{userId}")
    String deleteUser(@PathVariable int userId) {
        if (userService.delete(userId)) {
            return "success to delete user";
        }
        return "fail to delete user";
    }
}
