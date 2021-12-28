package com.cn.impl;

import com.cn.dto.FollowingReq;
import com.cn.dto.ShowFansReq;
import com.cn.dto.ShowFollowingReq;
import com.cn.dto.UnfollowingReq;
import com.cn.entity.UserFollow;
import com.cn.exception.CustomException;
import com.cn.mapper.mysql.UserFollowMapper;
import com.cn.service.UserFollowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class UserFollowServiceImpl implements UserFollowService {
    @Autowired
    DataSourceTransactionManager transaction;
    @Autowired
    TransactionDefinition transactionDefinition;

    @Resource
    UserFollowMapper followMapper;

    @Override
    public PageInfo<UserFollow> showFans(ShowFansReq req) {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        UserFollow build = UserFollow.builder().followingUserId(req.getUserId()).build();
        ArrayList<UserFollow> follows = followMapper.selectByCondition(build);
        return new PageInfo<>(follows);
    }

    @Override
    public PageInfo<UserFollow> showFollowing(ShowFollowingReq req) {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        UserFollow build = UserFollow.builder().userId(req.getUserId()).build();
        ArrayList<UserFollow> follows = followMapper.selectByCondition(build);
        return new PageInfo<>(follows);
    }

    /*
    todo move to common utils
     */
    static <T> Collection<List<T>> partitionBasedOnSize(List<T> inputList, int size) {
        final AtomicInteger counter = new AtomicInteger(0);
        return inputList.stream()
                .collect(Collectors.groupingBy(s -> counter.getAndIncrement() / size))
                .values();
    }


    @Override
    public boolean following(ArrayList<FollowingReq> reqs) {
        TransactionStatus transactionStatus = transaction.getTransaction(transactionDefinition);
        partitionBasedOnSize(reqs, 4).forEach(req -> {
            ArrayList<UserFollow> follows = new ArrayList<>();
            req.forEach(r -> {
                UserFollow build = UserFollow.builder().userId(r.getUserId())
                        .followingUserId(r.getFollowingUserId())
                        .userName(r.getUserName())
                        .followedName(r.getFollowingUserName())
                        .build();
                follows.add(build);
            });
            /*
            todo hide try by ExceptionHandle
             */
            try{
                if (followMapper.insertBatch(follows) <= 0) {
                    transaction.rollback(transactionStatus);
                    throw new CustomException("follow fail to insert");
                }
            }catch (Exception e){
                transaction.rollback(transactionStatus);
                throw new CustomException("duplication...");
            }

        });
        transaction.commit(transactionStatus);
        return true;
    }

    @Override
    public boolean unFollowing(UnfollowingReq req) {
        UserFollow build = UserFollow.builder().userId(req.getUserId())
                .followingUserId(req.getUnfollowingUserId())
                .build();
        return followMapper.deleteWithUserIdAndFollowingUserId(build.getUserId(), build.getFollowingUserId()) > 0;
    }
}
