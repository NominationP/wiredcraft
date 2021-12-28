package com.cn.controller;

import com.cn.dto.*;
import com.cn.entity.UserDetail;
import com.cn.entity.UserFollow;
import com.cn.redisEntity.UserGeo;
import com.cn.service.UserFollowService;
import com.cn.service.UserGeoService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/userGeo")
public class UserGeoController {
    @Autowired
    UserGeoService userGeoService;


    @RequestMapping(value = "/")
    String addGeo(@RequestBody UserGeo req) {
        UserDetail build = UserDetail.builder().id(req.getUserId()).name(req.getUsername()).build();
        return userGeoService.addUserGeo(build,req.getLongitude(),req.getLatitude()) > 0 ? "success add geo" : "failed";
    }

    @RequestMapping(value = "/findNearby")
    GeoResults<RedisGeoCommands.GeoLocation<String>> findNearby(@RequestBody FindNearbyReq req) {
        return userGeoService.findNearby(req);
    }
}
