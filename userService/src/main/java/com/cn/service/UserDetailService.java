package com.cn.service;

import com.cn.entity.UserDetail;

public interface UserDetailService {
    UserDetail get(int id);
    boolean create(UserDetail user);

    boolean update(int userId, UserDetail req);

    boolean delete(int userId);
}
