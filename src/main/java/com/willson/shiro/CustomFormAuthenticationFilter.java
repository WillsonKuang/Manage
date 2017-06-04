package com.willson.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Administrator on 2017/3/18 0018.
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    //改写原来的方法，进行验证码校验
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        //如果验证码错误，通过shiroLoginFailure传到request中
       /* HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute("ramdomCode");
        String pageRamdomCode = req.getParameter("code");

        if(!code.equals(pageRamdomCode)) {//如果验证失败
            req.setAttribute("shiroLoginFailure", "ramdomCodeError");
            return true;
        }*/

        return super.onAccessDenied(request, response);
    }
}
