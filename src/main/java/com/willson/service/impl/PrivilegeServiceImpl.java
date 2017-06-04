package com.willson.service.impl;

import com.willson.common.ConstantValues;
import com.willson.mapper.PrivilegeMapper;
import com.willson.pojo.PageBean;
import com.willson.pojo.Privilege;
import com.willson.service.itf.PrivilegeService;
import com.willson.utils.MyStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Override
    public Long save(Privilege privilege) throws Exception {

        privilegeMapper.insert(privilege);

        return privilege.getId();
    }

    @Override
    public void update(Privilege privilege) throws Exception {
        privilegeMapper.update(privilege);
    }

    @Override
    public void delete(String[] ids) throws Exception {
        Long[] longIds = MyStringUtil.toLongArray(ids);

        privilegeMapper.delete(longIds);

        for (Long privilegeId : longIds) {
            privilegeMapper.deleteRolePrivilegeByPrivilegeId(privilegeId);
        }
    }

    @Override
    public PageBean getForPage(Map<String, Object> params) throws Exception {
        Long pageNum = Long.parseLong(MyStringUtil.getStringValue(params.get("pageNum"), "1"));
        Long pageSize = ConstantValues.PAGE_SIZE;
        Long offset = (pageNum - 1) * pageSize;
        params.put("offset", offset);
        params.put("pageSize", pageSize);

        List<Privilege> privilegeList = privilegeMapper.listForPage(params);

        Long pageCount = privilegeMapper.listPageCount(params);

        return new PageBean(pageNum, pageSize, privilegeList, pageCount);
    }

    @Override
    public Privilege getByKey(Long id) throws Exception {
       Privilege privilege = privilegeMapper.getByKey(id);
       return privilege;
    }

    @Override
    public List<Privilege> listPrivilegeByUserId(Long userId) throws Exception {
        List<Privilege> privilegeList = privilegeMapper.listPrivilegeByUserId(userId);
        return privilegeList;
    }

    @Override
    public List<Privilege> listMenuByUserId(Long userId) throws Exception {
        List<Privilege> privilegeList = privilegeMapper.listTopMenuByUserId(userId);
        return privilegeList;
    }
}
