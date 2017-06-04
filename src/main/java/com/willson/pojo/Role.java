package com.willson.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class Role extends BaseBean implements Serializable {
    private Long id;

    private String name;

    private List<User> users = new ArrayList<>();

    private List<Privilege> privileges = new ArrayList<>();

    private String[] ids;

    private String[] privilegeIds;

    public Role() {
    }

    public Role(String name, String[] privilegeIds) {
        this.name = name;
        this.privilegeIds = privilegeIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public String[] getPrivilegeIds() {
        return privilegeIds;
    }

    public void setPrivilegeIds(String[] privilegeIds) {
        this.privilegeIds = privilegeIds;
    }
}
