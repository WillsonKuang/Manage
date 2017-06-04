package com.willson.service.impl;

import com.willson.common.ConstantValues;
import com.willson.mapper.UserMapper;
import com.willson.pojo.PageBean;
import com.willson.pojo.User;
import com.willson.service.itf.UserService;
import com.willson.utils.EncryptUtil;
import com.willson.utils.MyStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Long save(User user) throws Exception {

        user.setPassword(EncryptUtil.md5AndSha(user.getPassword()));
        userMapper.insert(user);

        Long userId = user.getId();

        String[] roleIds = user.getRoleIds();

        if (null != roleIds && roleIds.length > 0) {
            Map<String, Long> params = null;
            for (String roleId : roleIds) {
                params = new HashMap<>(2);
                params.put("userId", userId);
                params.put("roleId", Long.parseLong(roleId));
                userMapper.insertUserRole(params);
            }
        }
        return userId;
    }

    @Override
    public void update(User user) throws Exception {
        userMapper.update(user);

        Long userId = user.getId();

        userMapper.deleteUserRoleByUserId(userId);

        String[] roleIds = user.getRoleIds();

        if (null != roleIds && roleIds.length > 0) {
            Map<String, Long> params = null;
            for (String roleId : roleIds) {
                params = new HashMap<>(2);
                params.put("userId", userId);
                params.put("roleId", Long.parseLong(roleId));
                userMapper.insertUserRole(params);
            }
        }
    }

    @Override
    public void delete(String[] ids) throws Exception {
        Long[] longIds = MyStringUtil.toLongArray(ids);
        userMapper.delete(longIds);
        for(Long userId : longIds) {
            userMapper.deleteUserRoleByUserId(userId);
        }
    }

    @Override
    public PageBean getForPage(Map<String, Object> params) throws Exception {
        Long pageNum = Long.parseLong(MyStringUtil.getStringValue(params.get("pageNum"), "1"));
        Long pageSize = ConstantValues.PAGE_SIZE;
        Long offset = (pageNum - 1) * pageSize;
        params.put("offset", offset);
        params.put("pageSize", pageSize);

        List<User> userList = userMapper.listForPage(params);

        Long pageCount = userMapper.listPageCount(params);

        return new PageBean(pageNum, pageSize, userList, pageCount);
    }

    @Override
    public User getByKey(Long id) throws Exception {
        User user = userMapper.getByKey(id);

        return user;
    }

    @Override
    public User getUserByUsername(String username) throws Exception {

        User user = userMapper.getUserByUsername(username);

        return user;
    }
}
