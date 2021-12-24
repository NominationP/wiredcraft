package com.cn.impl;

import com.cn.dto.UpdateReq;
import com.cn.entity.User;
import com.cn.exception.CustomException;
import com.cn.mapper.mysql.UserMapper;
import com.cn.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;


    @Override
    public User get(int id) {
        User user = userMapper.selectById(id);
        if (user == null) throw new CustomException("user dose not exist");
        return user;
    }

    @Override
    public boolean create(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean update(int userId, UpdateReq req) {
        User build = User.builder()
                .id(userId)
                .name(req.getName())
                .address(req.getAddress())
                .dob(req.getDob())
                .description(req.getDescription())
                .build();
        return userMapper.updateById(build) > 0;
    }

    @Override
    public boolean delete(int userId) {
        return userMapper.deleteById(userId) > 0;
    }
}
