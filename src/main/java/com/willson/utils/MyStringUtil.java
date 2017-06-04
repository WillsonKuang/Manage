package com.willson.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/3/26 0026.
 */
public class MyStringUtil {
    private static final Logger logger = LoggerFactory.getLogger(MyStringUtil.class);

    public static String getStringValue(Object sourse, String defaultValue) {
        if(null == sourse) {
            return defaultValue;
        }
        return sourse.toString();
    }

    public static Long[] toLongArray(String[] source) {

      if (null == source || source.length == 0) {
          return new Long[0];
      }

      Long[] res = new Long[source.length];

      try {
          for (int i = 0; i < source.length; i++) {
              res[i] = Long.parseLong(source[i]);
          }
      } catch (Exception e) {
          logger.error("不能转换为Long数组");
          return new Long[0];
      }
      return res;
    }

}
