package com.cn.impl;

import com.cn.entity.UserDetail;
import com.cn.service.RedisGeoService;
import com.cn.service.UserGeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;

import java.util.List;

public class UserGeoServiceImpl implements UserGeoService {

    private String getGeoKey() {
        return "Geo_wiredcraft";
    }

    @Autowired
    RedisGeoService redisGeoService;

    @Override
    public Long addUserGeo(UserDetail userDetail, double lng, double lat) {
        String redisKey = getGeoKey();
        return redisGeoService.geoAdd(redisKey, new Point(lng, lat), userDetail.getName());
    }

    @Override
    public List<Point> getUserGeoByUserId(UserDetail userDetail) {
        String geoKey = getGeoKey();
        return redisGeoService.geoGet(geoKey, userDetail.getName());
    }


    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> findNearby(UserDetail userDetail, Distance distance) {
        String redisKey = getGeoKey();
        /*
        todo adapt custom struct
         */
        return redisGeoService.nearByPlace(redisKey, userDetail.getName(), distance, 5);
    }


}
