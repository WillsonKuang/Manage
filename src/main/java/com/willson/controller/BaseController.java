package com.willson.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 基础controller
 * Created by Administrator on 2017/3/19 0019.
 */
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 获取request域的所有参数
     * @param request
     * @return
     */
    public Map<String, Object> getRequestParams(HttpServletRequest request) {

        Map parameterMap = request.getParameterMap();
        Map<String, Object> params = new HashMap<>();

        String name = "";
        Object value = "";

        for (Iterator iter = parameterMap.entrySet().iterator(); iter.hasNext();) {
            Map.Entry entry = (Map.Entry) iter.next();
            name = (String) entry.getKey();
            Object entryValue = entry.getValue();

            if (null == entryValue) {
                value = "";
            } else if (entryValue instanceof String[]) {
                String[] values = (String[]) entryValue;
                String value_tmp = "";
                for (String v : values) {
                    value_tmp += v + ",";
                }
                value = value_tmp.substring(0, value_tmp.length() -1);
            } else {
                value = entryValue.toString();
            }
            params.put(name, value);
        }
        return params;
    }
}























