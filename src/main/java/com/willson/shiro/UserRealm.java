package com.willson.shiro;


import com.willson.pojo.Privilege;
import com.willson.pojo.SessionUser;
import com.willson.pojo.User;
import com.willson.service.itf.PrivilegeService;
import com.willson.service.itf.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/3/18 0018.
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private PrivilegeService privilegeService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SessionUser sessionUser = (SessionUser) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        List<Privilege> privilegeList = null;
        try {
            privilegeList = privilegeService.listPrivilegeByUserId(sessionUser.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Privilege privilege : privilegeList) {
            simpleAuthorizationInfo.addStringPermission(privilege.getHref());
        }
        return simpleAuthorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();

        User user = null;
        try {
            user = userService.getUserByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationException("用户名或密码错误");
        }

        if(null == user) {
            throw new AuthenticationException("用户名或密码错误");
        }

        List<Privilege> menuList = null;
        try {
            menuList = privilegeService.listMenuByUserId(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String password = user.getPassword();

        SessionUser sessionUser = new SessionUser();
        sessionUser.setId(user.getId());
        sessionUser.setUsername(user.getUsername());
        sessionUser.setNickname(user.getNickname());
        sessionUser.setPrivileges(menuList);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sessionUser, password, this.getName());

        return simpleAuthenticationInfo;
    }
}
