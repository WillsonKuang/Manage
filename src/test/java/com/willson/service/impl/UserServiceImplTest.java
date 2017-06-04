package com.willson.service.impl;

import com.willson.common.util.TestSupport;
import com.willson.pojo.User;
import com.willson.service.itf.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * Created by Administrator on 2017/6/4 0004.
 */
public class UserServiceImplTest extends TestSupport {

    @Autowired
    private UserService userService;

    @Test
    public void save() throws Exception {

        User user = new User("张三", "zhangsan", "111111", new String[]{});
        Long id = userService.save(user);

        System.out.println(id);


    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void getForPage() throws Exception {
    }

    @Test
    public void getByKey() throws Exception {
    }

    @Test
    public void getUserByUsername() throws Exception {

        User user = userService.getUserByUsername("zhangsan");

        System.out.println(user.getNickname());

    }

}