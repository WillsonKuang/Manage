package com.willson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huangwsa on 2017/2/8.
 */
@Controller
@RequestMapping("/index/")
public class IndexController {

    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "Login";
    }

    @RequestMapping(value = "Index")
    public String toIndex() {
        return "Index";
    }

    @RequestMapping(value = "main")
    public String toMain() {
        return "Main";
    }

}
