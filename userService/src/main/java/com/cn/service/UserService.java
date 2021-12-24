package com.cn.service;

import com.cn.dto.UpdateReq;
import com.cn.entity.User;

public interface UserService {
    User get(int id);
    boolean create(User user);

    boolean update(int userId, UpdateReq req);

    boolean delete(int userId);
}
