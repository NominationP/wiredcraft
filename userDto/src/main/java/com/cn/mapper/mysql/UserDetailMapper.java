package com.cn.mapper.mysql;
import com.cn.entity.UserDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface UserDetailMapper {
    int insert(UserDetail report);

    int insertBatch(ArrayList<UserDetail> reports);

    UserDetail selectById(int id);

    ArrayList<UserDetail> selectByCondition(UserDetail detail);

    int updateById(UserDetail record);

    int deleteById(int id);
}
