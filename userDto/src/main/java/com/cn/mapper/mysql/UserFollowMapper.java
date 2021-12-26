package com.cn.mapper.mysql;//package com.cn.entity.mapper.mysql;
import com.cn.entity.UserFollow;
import org.apache.ibatis.annotations.Mapper;
import java.util.ArrayList;

@Mapper
public interface UserFollowMapper {
    int insert(UserFollow report);

    int insertBatch(ArrayList<UserFollow> reports);

    UserFollow selectById(int id);

    ArrayList<UserFollow> selectByCondition(UserFollow detail);

    int updateById(UserFollow record);

    int deleteById(int id);

    /*
    Notice : in case delete all
     */
    int deleteWithUserIdAndFollowingUserId(int userId, int followingUserId);
}
