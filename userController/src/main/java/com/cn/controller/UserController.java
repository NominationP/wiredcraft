package com.cn.controller;


import com.cn.dto.ReqUser;
import com.cn.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：User资源服务器 UserController
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 得到所有用户列表，所有权限可以访问
     * @return
     */
    @PostMapping("/users")
    public Object getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * 增加用户，只有权限为admin的用户才可以访问
     */
    @PostMapping("/save")
    public Object save(@RequestBody ReqUser reqUser)
    {
        return userService.save(reqUser);
    }
}

