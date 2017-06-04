package com.willson.service.impl;

import com.willson.common.util.TestSupport;
import com.willson.pojo.Privilege;
import com.willson.pojo.Role;
import com.willson.pojo.User;
import com.willson.service.itf.PrivilegeService;
import com.willson.service.itf.RoleService;
import com.willson.service.itf.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
public class PrivilegeServiceImplTest extends TestSupport {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PrivilegeService privilegeService;


    @Test
    public void saveSeries() throws Exception {

        Privilege privilege = null;

        privilege = new Privilege("系统管理", "sys:admin", "fa fa-file-text", 0L);
        Long sysId = privilegeService.save(privilege);

        privilege = new Privilege("用户管理", "/user/query", "fa fa-file-text", sysId);
        Long userManageId = privilegeService.save(privilege);

        privilege = new Privilege("添加", "user:add", "fa fa-file-text", userManageId);
        Long userAddId = privilegeService.save(privilege);

        privilege = new Privilege("查询", "user:query", "fa fa-file-text", userManageId);
        Long userQueryId = privilegeService.save(privilege);

        privilege = new Privilege("修改", "user:update", "fa fa-file-text", userManageId);
        Long userUpdateId = privilegeService.save(privilege);

        privilege = new Privilege("删除", "user:delete", "fa fa-file-text", userManageId);
        Long userDeleteId = privilegeService.save(privilege);

        privilege = new Privilege("重置密码", "user:resetPassword", "fa fa-file-text", userManageId);
        Long userResetPasswordId = privilegeService.save(privilege);

        privilege = new Privilege("角色管理", "/role/query", "fa fa-file-text", sysId);
        Long roleManageId = privilegeService.save(privilege);

        privilege = new Privilege("添加", "role:add", "fa fa-file-text", userManageId);
        Long roleAddId = privilegeService.save(privilege);

        privilege = new Privilege("查询", "role:query", "fa fa-file-text", userManageId);
        Long roleQueryId = privilegeService.save(privilege);

        privilege = new Privilege("修改", "role:update", "fa fa-file-text", userManageId);
        Long roleUpdateId = privilegeService.save(privilege);

        privilege = new Privilege("删除", "role:delete", "fa fa-file-text", userManageId);
        Long roleDeleteId = privilegeService.save(privilege);


        Role role = new Role("管理员", new String[]{
                String.valueOf(sysId),
                String.valueOf(userManageId),
                String.valueOf(userAddId),
                String.valueOf(userQueryId),
                String.valueOf(userDeleteId),
                String.valueOf(userUpdateId),
                String.valueOf(roleManageId),
                String.valueOf(roleQueryId),
                String.valueOf(roleAddId),
        });

        Long roleId = roleService.save(role);

        User user = new User("张三", "zhangsan", "111111", new String[]{String.valueOf(roleId)});
        userService.save(user);

        System.out.println("初始化成功............");
    }

    @Test
    public void save() throws Exception {
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
    public void listPrivilegeByUserId() throws Exception {
    }

    @Test
    public void listMenuByUserId() throws Exception {
    }

}