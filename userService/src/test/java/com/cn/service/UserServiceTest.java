package com.cn.service;

import com.cn.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.cn"})
@SpringBootTest(classes = UserServiceTest.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    void update() {
        Random random = new Random();
        User user = userService.get(1);
        String newName = "change" + random.nextInt(50);
        user.setName(newName);
        User userUpdate = userService.get(1);
        if(userService.update(user.getId(), user)){
            Assert.assertEquals(userUpdate.getName(),newName);
        }
        Assert.assertNotEquals(userUpdate.getName(),user.getName());

    }
}