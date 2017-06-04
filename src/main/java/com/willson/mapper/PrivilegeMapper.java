package com.willson.mapper;

import com.willson.pojo.Privilege;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public interface PrivilegeMapper extends BaseMapper<Privilege> {
    List<Privilege> listPrivilegeByUserId(Long userId) throws Exception;

    List<Privilege> listTopMenuByUserId(Long userId) throws Exception;

    void deleteRolePrivilegeByPrivilegeId(Long privilegeId);
}
