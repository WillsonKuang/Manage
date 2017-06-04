package com.willson.service.itf;

import com.willson.pojo.User;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public interface UserService extends BaseService<User> {

    User getUserByUsername(String username) throws Exception;
}
