package com.willson.service.itf;


import com.willson.pojo.PageBean;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/19 0019.
 */
public interface BaseService<T> {

    Long save(T t) throws Exception;

    void update(T t) throws Exception;

    void delete(String[] ids) throws Exception;

    PageBean getForPage(Map<String, Object> params) throws Exception;

    T getByKey(Long id) throws Exception;

}
