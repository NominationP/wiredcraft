package com.cn.impl;

import com.UserServerApplication;
import com.cn.entity.UserDetail;
import com.cn.redisEntity.UserGeo;
import com.cn.service.RedisGeoService;
import com.cn.service.UserGeoService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UserGeoServiceImpl.class})
@SpringBootTest(classes = UserServerApplication.class)
class UserGeoServiceImplTest {

    @Autowired
    UserGeoService userGeoService;

    @Test
    void addUserGeo() {
        UserDetail bo = UserDetail.builder().id(1).name("bo").build();
        userGeoService.addUserGeo(bo, 116.40426903963089, 39.909178316988886);
        List<Point> geo = userGeoService.getUserGeoByUserId(bo);
        Assertions.assertEquals(116.40426903963089, geo.get(0).getX());
        Assertions.assertEquals(39.909178316988886, geo.get(0).getY());

        UserDetail lu = UserDetail.builder().id(2).name("lu").build();
        userGeoService.addUserGeo(lu, 116.36244267225266, 39.97755242026205);
        List<Point> geo1 = userGeoService.getUserGeoByUserId(lu);
        Assertions.assertEquals(116.36244267225266, geo1.get(0).getX());
        Assertions.assertEquals(39.97755242026205, geo1.get(0).getY());

        UserDetail boo = UserDetail.builder().id(3).name("boo").build();
        userGeoService.addUserGeo(boo, 116.40441387891769, 39.915046196472751);
        List<Point> geo2 = userGeoService.getUserGeoByUserId(boo);
        Assertions.assertEquals(116.40441387891769, geo2.get(0).getX());
        Assertions.assertEquals(39.915046196472751, geo2.get(0).getY());
    }

    /*
    functional test (once time)
     */
    @Test
    void findNearby() {
        UserDetail bo = UserDetail.builder().id(3).name("boo").build();
        Distance distance = new Distance(800, Metrics.KILOMETERS);
        GeoResults<RedisGeoCommands.GeoLocation<String>> nearby = userGeoService.findNearby(bo, distance);
        System.out.println(nearby);
    }
}