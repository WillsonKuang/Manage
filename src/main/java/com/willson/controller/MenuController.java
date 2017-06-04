package com.willson.controller;

import com.willson.pojo.Privilege;
import com.willson.pojo.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
@Controller
@RequestMapping("/menu/")
public class MenuController {

    @RequestMapping(value = "getMenuByTypeId", method = RequestMethod.GET)
    @ResponseBody
    public List<Privilege> getMenuByTypeId(HttpSession session, String typeId) {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");

        List<Privilege> menuList = user.getPrivileges();

        return menuList;
    }
}
