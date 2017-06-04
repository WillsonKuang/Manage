package com.willson.service.impl;

import com.willson.common.util.TestSupport;
import com.willson.pojo.Role;
import com.willson.service.itf.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
public class RoleServiceImplTest extends TestSupport {

    @Autowired
    private RoleService roleService;

    @Test
    public void save() throws Exception {

        Role role = new Role();
        role.setName("普通员工");

        Long id = roleService.save(role);

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

}