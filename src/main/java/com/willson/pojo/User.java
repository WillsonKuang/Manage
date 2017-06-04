package com.willson.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class User extends BaseBean implements Serializable {
    private Long id;

    private String nickname;

    private String username;

    private String password;

    private List<Role> roles = new ArrayList<>();

    private String[] ids;

    private String[] roleIds;

    public User() {
    }

    public User(String nickname, String username, String password, String[] roleIds) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.roleIds = roleIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public String[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }
}
