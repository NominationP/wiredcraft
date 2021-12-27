package com.cn.service;

import com.cn.entity.UserDetail;
import com.cn.redisEntity.UserGeo;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;

import java.util.List;

public interface UserGeoService {

    Long addUserGeo(UserDetail userDetail, double lng, double lat);

    List<Point> getUserGeoByUserId(UserDetail userDetail);

    GeoResults<RedisGeoCommands.GeoLocation<String>> findNearby(UserDetail userDetail, Distance distance);
}
