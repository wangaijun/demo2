package com.example.demo;

import com.example.demo.entity.mongodb.User;
import com.example.demo.repository.mongodb.UserRepositoryMongoDb;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDbTest {
    @Autowired
    UserRepositoryMongoDb userRepositoryMongoDb;

    private Logger logger=LoggerFactory.getLogger(getClass());

    @Test
    public void test001() {
        logger.info("开始查询用户");
        List<User> users = userRepositoryMongoDb.findAll();
        Assert.notNull(users, "用户列表为空");
        Assert.isTrue(users.size() > 2, "用户的Size不大于2");
        logger.info("操作完成！！！");
    }


    @Before
    public void setup() {
        logger.info("开始准备数据！");
        Set<String> roles = new HashSet<>();
        roles.add("manage");
        User user1 = new User("1", "user1", "12345678", "name", "email@com.cn", new Date(), roles);
        User user2 = new User("2", "user2", "12345678", "name", "email@com.cn", new Date(), roles);
        User user3 = new User("3", "user3", "12345678", "name", "email@com.cn", new Date(), roles);
        userRepositoryMongoDb.deleteAll();
        userRepositoryMongoDb.save(user1);
        userRepositoryMongoDb.save(user2);
        userRepositoryMongoDb.save(user3);
        logger.info("数据准备完成！");
    }

    @After
    public void tearDown(){
        logger.info("开始清理数据！");
        userRepositoryMongoDb.deleteAll();
        logger.info("数据清理完成！");

    }


}
