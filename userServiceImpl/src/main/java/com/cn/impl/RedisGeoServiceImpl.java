package com.cn.impl;

import com.cn.service.RedisGeoService;
import org.springframework.data.geo.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisGeoServiceImpl implements RedisGeoService {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * Returns an element whose radius does not exceed the specified distance,
     * based on the given latitude and longitude
     * <p>
     * redis：georadius key 116.405285 39.904989 100 km WITHDIST WITHCOORD ASC
     * COUNT 5
     */
    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> nearByXY(String key, Circle circle, long count) {
        // includeDistance
        // includeCoordinates
        // sortAscending
        // limit: return special count
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs()
                .includeDistance().includeCoordinates().sortAscending().limit(count);
        return redisTemplate.opsForGeo().radius(key, circle, args);
    }

    /**
     * Queries the location within the specified radius based on the specified location
     * <p>
     * redis：georadiusbymember key 北京 100 km WITHDIST WITHCOORD ASC COUNT 5
     */
    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> nearByPlace(String key, String member, Distance distance,
                                                                        long count) {
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs()
                .includeDistance().includeCoordinates().sortAscending().limit(count);
        return redisTemplate.opsForGeo().radius(key, member, distance, args);
    }

    /**
     * add lng and lat
     * <p>
     * redis 命令：geoadd key 116.405285 39.904989 "Shanghai"
     */
    @Override
    public Long geoAdd(String key, Point point, String username) {
//        if (redisTemplate.hasKey(key)) {
//            redisTemplate.opsForGeo().remove(key, username);
//        }
        return redisTemplate.opsForGeo().add(key, point, username);
    }

    @Override
    public List<Point> geoGet(String geoKey, String... name) {
        return redisTemplate.opsForGeo().position(geoKey, name);
    }
}
