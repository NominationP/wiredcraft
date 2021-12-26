package com.cn.service;

import com.cn.entity.UserDetail;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.cn"})
@MapperScan("com.cn.mapper.mysql")
@SpringBootTest(classes = UserServiceTest.class)
class UserServiceTest {

    @Autowired
    private UserDetailService userService;

    @Test
    @Transactional
    void update() {
        Random random = new Random();
        UserDetail user = userService.get(1);
        System.out.println(user);
//        String newName = "change" + random.nextInt(50);
//        user.setName(newName);
//        User userUpdate = userService.get(1);
//        if(userService.update(user.getId(), user)){
//            Assert.assertEquals(userUpdate.getName(),newName);
//        }
//        Assert.assertNotEquals(userUpdate.getName(),user.getName());

    }
}