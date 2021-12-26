package com.cn.controller;

import com.cn.dto.UpdateReq;
import com.cn.service.UserService;
import com.cn.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @PutMapping("/{id}")
    /*
    todo UpdateReq not work
     */
    String update(@PathVariable int id, @RequestBody User user) {
        if (userService.update(id, user)) {
            return "success to update user";
        }
        return "fail to update user";
    }


    @PostMapping(value = "/", produces = {"application/json;charset=UTF-8"})
    String update(@Valid @RequestBody User user) {
        if (userService.create(user)) {
            return "success to create user";
        }
        return "fail to create user";
    }


    @GetMapping(value = "/{userId}", produces = {"application/json;charset=UTF-8"})
    User getDetail(@PathVariable int userId) {
        return userService.get(userId);
    }

    @DeleteMapping(value = "/{userId}", produces = {"application/json;charset=UTF-8"})
    String deleteUser(@PathVariable int userId) {
        if (userService.delete(userId)) {
            return "success to delete user";
        }
        return "fail to delete user";
    }
}
