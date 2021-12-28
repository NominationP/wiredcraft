package com.cn.service;

import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;

import java.util.List;

public interface RedisGeoService {
    GeoResults<RedisGeoCommands.GeoLocation<String>> nearByPlace(String key, String member, Distance distance,
                                                                 long count);

    Long geoAdd(String key, Point point, String member);

    List<Point> geoGet(String geoKey, String... name);
}
