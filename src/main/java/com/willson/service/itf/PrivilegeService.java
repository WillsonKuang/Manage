package com.willson.service.itf;

import com.willson.pojo.Privilege;

import java.util.List;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public interface PrivilegeService extends BaseService<Privilege> {

    List<Privilege> listPrivilegeByUserId(Long userId) throws Exception;

    List<Privilege> listMenuByUserId(Long userId) throws Exception;
}
