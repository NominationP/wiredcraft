package com.cn.controller;

import com.cn.service.UserService;
import com.cn.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/", produces = {"application/json;charset=UTF-8"})
    String create(@Valid @RequestBody User user){
        if(userService.create(user)){
            return "success to create user";
        }
        return "fail to create user";
    }
}
