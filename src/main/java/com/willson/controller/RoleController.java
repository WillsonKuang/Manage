package com.willson.controller;

import com.willson.pojo.PageBean;
import com.willson.service.itf.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
@Controller
@RequestMapping("/role/")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("query")
    @RequiresPermissions("role:query")
    public String query(HttpServletRequest request) throws Exception {

        Map<String, Object> params = this.getRequestParams(request);

        PageBean pageBean = roleService.getForPage(params);

        request.setAttribute("pageBean", pageBean);
        request.setAttribute("params", params);

        return "role/role_index";
    }
}
