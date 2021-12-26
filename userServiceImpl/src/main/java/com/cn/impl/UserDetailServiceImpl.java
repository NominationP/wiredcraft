package com.cn.impl;

import com.cn.entity.UserDetail;
import com.cn.exception.CustomException;
import com.cn.mapper.mysql.UserDetailMapper;
import com.cn.service.UserDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Resource
    UserDetailMapper userDetailMapper;


    @Override
    public UserDetail get(int id) {
        UserDetail user = userDetailMapper.selectById(id);
        if (user == null) throw new CustomException("user dose not exist");
        return user;
    }

    @Override
    public boolean create(UserDetail user) {
        return userDetailMapper.insert(user) > 0;
    }

    @Override
    public boolean update(int userId, UserDetail req) {
        UserDetail build = UserDetail.builder()
                .id(userId)
                .name(req.getName())
                .address(req.getAddress())
                .dob(req.getDob())
                .description(req.getDescription())
                .build();
        return userDetailMapper.updateById(build) > 0;
    }

    @Override
    public boolean delete(int userId) {
        return userDetailMapper.deleteById(userId) > 0;
    }
}
