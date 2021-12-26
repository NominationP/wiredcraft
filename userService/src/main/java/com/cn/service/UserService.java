package com.cn.service;


import com.cn.dto.ReqUser;
import com.cn.entity.User;

/**
 * 描述：UserService接口
 */
public interface UserService {
    Object getAllUsers();

    User getUserByUserName(String username);

    Object save(ReqUser reqUser);
}

