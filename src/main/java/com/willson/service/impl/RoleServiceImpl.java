package com.willson.service.impl;

import com.willson.common.ConstantValues;
import com.willson.mapper.RoleMapper;
import com.willson.pojo.PageBean;
import com.willson.pojo.Role;
import com.willson.service.itf.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Long save(Role role) throws Exception {
        roleMapper.insert(role);

        Long roleId = role.getId();

        String[] privilegeIds = role.getPrivilegeIds();

        if(null != privilegeIds && privilegeIds.length > 0) {
            Map<String, Long> params = null;
            for (String privilegeId : privilegeIds) {
                params = new HashMap<>(2);
                params.put("roleId", roleId);
                params.put("privilegeId", Long.parseLong(privilegeId));
                roleMapper.insertRolePrivilege(params);
            }
        }
        return roleId;
    }

    @Override
    public void update(Role role) throws Exception {
        roleMapper.update(role);

        Long roleId = role.getId();

        roleMapper.deleteRolePrivilegeByRoleId(roleId);

        String[] privilegeIds = role.getPrivilegeIds();

        if(null != privilegeIds && privilegeIds.length > 0) {
            Map<String, Long> params = null;
            for (String privilegeId : privilegeIds) {
                params = new HashMap<>(2);
                params.put("roleId", roleId);
                params.put("privilegeId", Long.parseLong(privilegeId));
                roleMapper.insertRolePrivilege(params);
            }
        }
    }

    @Override
    public void delete(String[] ids) throws Exception {
        Long[] longIds = MyStringUtil.toLongArray(ids);
        roleMapper.delete(longIds);
        for(Long roleId : longIds) {
            roleMapper.deleteRolePrivilegeByRoleId(roleId);
            roleMapper.deleteUserRoleByRoleId(roleId);
        }
    }

    @Override
    public PageBean getForPage(Map<String, Object> params) throws Exception {
        Long pageNum = Long.parseLong(MyStringUtil.getStringValue(params.get("pageNum"), "1"));
        Long pageSize = ConstantValues.PAGE_SIZE;
        Long offset = (pageNum - 1) * pageSize;
        params.put("offset", offset);
        params.put("pageSize", pageSize);

        List<Role> roleList = roleMapper.listForPage(params);

        Long pageCount = roleMapper.listPageCount(params);

        return new PageBean(pageNum, pageSize, roleList, pageCount);
    }

    @Override
    public Role getByKey(Long id) throws Exception {

        Role role = roleMapper.getByKey(id);

        return role;
    }
}
