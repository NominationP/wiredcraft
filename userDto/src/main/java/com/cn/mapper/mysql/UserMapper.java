package com.cn.mapper.mysql;
import com.cn.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface UserMapper {
    int insert(User report);

    int insertBatch(ArrayList<User> reports);

    User selectById(int id);

    ArrayList<User> selectByCondition(User detail);

    int updateById(User record);

    int deleteById(int id);
}
