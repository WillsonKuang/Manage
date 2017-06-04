package com.willson.mapper;

import com.willson.pojo.User;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public interface UserMapper extends BaseMapper<User> {
    Long insertUserRole(Map<String, Long> params);

    void deleteUserRoleByUserId(Long userId);

    User getUserByUsername(String username);
}
