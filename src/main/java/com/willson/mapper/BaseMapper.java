package com.willson.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by huangwsa on 2017/2/15.
 */
public interface BaseMapper<T> {

	Long insert(T t) throws Exception;

	void update(T t) throws Exception;

	void delete(Long[] ids) throws Exception;

	T getByKey(Long key) throws Exception;

	List<T> listForPage(Map<String, Object> params) throws Exception;
	
	Long listPageCount(Map<String, Object> params) throws Exception;
}
