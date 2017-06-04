package com.willson.controller;

import com.alibaba.fastjson.JSONObject;
import com.willson.pojo.PageBean;
import com.willson.pojo.SessionUser;
import com.willson.pojo.User;
import com.willson.service.itf.UserService;
import com.willson.utils.EncryptUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
@Controller
@RequestMapping("/user/")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login")
    public String login(HttpSession session, Model model, User user) {

        Subject currentUser = SecurityUtils.getSubject();

        if (null != user.getPassword() && !currentUser.isAuthenticated()) {
            UsernamePasswordToken upToken = new UsernamePasswordToken(user.getUsername(), EncryptUtil.md5AndSha(user.getPassword()));

            upToken.setRememberMe(false);

            try {
                currentUser.login(upToken);

                SessionUser sessionUser = (SessionUser) currentUser.getPrincipal();

                session.setAttribute("sessionUser", sessionUser);

                session.setAttribute("loginErrMes", null);

                return "redirect:/index/Index";
            } catch (IncorrectCredentialsException ice) {
                session.setAttribute("loginErrMes", "用户名或密码错误");
            } catch (LockedAccountException lae) {
                session.setAttribute("loginErrMes", "用户被冻结");
            } catch (AuthenticationException ae) {
                session.setAttribute("loginErrMes", ae.getMessage());
            }
        } else if (currentUser.isAuthenticated()) {
            return "redirect:/index/Index";
        }

        return "redirect:/index/toLogin";
    }

    @RequestMapping("logout")
    @ResponseBody
    public JSONObject logout(HttpSession session) {

        session.invalidate();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", 47);
        jsonObject.put("message", "退出成功！");
        return jsonObject;
    }

    @RequestMapping("query")
    @RequiresPermissions("user:query")
    public String query(HttpServletRequest request) throws Exception {

        Map<String, Object> params = this.getRequestParams(request);

        PageBean pageBean = userService.getForPage(params);

        request.setAttribute("pageBean", pageBean);
        request.setAttribute("params", params);

        return "user/user_index";
    }


    @RequestMapping("delete")
    @RequiresPermissions("user:delete")
    public String delete(String[] ids) throws Exception {
        userService.delete(ids);
        return "redirect:query";
    }

    @RequestMapping("toUpdate/{id}")
    @RequiresPermissions("user:update")
    public String toUpdate(@PathVariable Long id, HttpServletRequest request) throws Exception {
        User user = userService.getByKey(id);
        request.setAttribute("user", user);
        return "user/user_edit";
    }

    @RequestMapping("update")
    @RequiresPermissions("user:update")
    public String update(User user) throws Exception {

        userService.update(user);

        return "redirect:query";
    }

    @RequestMapping("toAdd")
    @RequiresPermissions("user:add")
    public String toAdd() {
        return "user/user_add";
    }

    @RequestMapping("add")
    @RequiresPermissions("user:add")
    public String add(User user) throws Exception {

        Long id = userService.save(user);

        return "redirect:query";
    }
}
