package com.willson.mapper;

import com.willson.mapper.BaseMapper;
import com.willson.pojo.Role;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public interface RoleMapper extends BaseMapper<Role> {
    Long insertRolePrivilege(Map<String, Long> params);

    void deleteRolePrivilegeByRoleId(Long roleId);

    void deleteUserRoleByRoleId(Long roleId);
}
