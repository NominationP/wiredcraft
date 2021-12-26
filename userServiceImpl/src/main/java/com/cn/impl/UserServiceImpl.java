package com.cn.impl;


import com.cn.dto.ReqUser;
import com.cn.entity.User;
import com.cn.mapper.mysql.UserMapper;
import com.cn.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Object getAllUsers() {
        List<User> users = userMapper.selectAllUsers();
        return users;
    }

    @Override
    public User getUserByUserName(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public Object save(ReqUser reqUser) {
        int count = userMapper.save(reqUser);
        return count;
    }


}


