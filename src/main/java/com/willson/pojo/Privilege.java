package com.willson.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class Privilege extends BaseBean implements Serializable {
    private Long id;

    private String title;

    private String href;

    private String icon;

    private Long parentId;

    private Privilege parent;

    private List<Privilege> children = new ArrayList<>();

    private List<Role> roles = new ArrayList<>();

    public Privilege() {
    }

    public Privilege(String title, String href, String icon, Long parentId) {
        this.title = title;
        this.href = href;
        this.icon = icon;
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Privilege getParent() {
        return parent;
    }

    public void setParent(Privilege parent) {
        this.parent = parent;
    }

    public List<Privilege> getChildren() {
        return children;
    }

    public void setChildren(List<Privilege> children) {
        this.children = children;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
