package com.zero.base.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zero.base.util.ReqModel;
import com.zero.base.util.SpringUtils;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author ljz
 *
 * @param <T>
 */
public class BaseService<T> {
	public static final String SQL_ID = "sqlId";
	public static final String PAGE_NUM = "num";
	public static final String PAGE_SIZE = "size";
	public Mapper<T> mapper;

	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 
	 * 分页查询
	 * @param map
	 * @return
	 */
	public Page<?> selectList(Map<String, Object> map) {
		ReqModel reqModel = JSON.toJavaObject(new JSONObject(map), ReqModel.class);
		Page<?> p = PageHelper.startPage(reqModel.getNum(), reqModel.getSize());
		sqlSessionTemplate.selectList(reqModel.getSqlId(), map);
		return p;
	}
	
	/**
	 * 不分页
	 * @param map
	 * @return
	 */
	public List<T> selectListsNoPage(Map<String, Object> map) {
		List<T> selectList = sqlSessionTemplate.selectList((String) map.get(SQL_ID), map);
		return selectList;
	}
	
	public T selectByPrimaryKey(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		return (T) mapper.selectByPrimaryKey(record);

	}
	
	public String saveOrUpdate(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		// (T) mapper.selectOne(record)
		// selectOne(record);
		T selectByPrimaryKey = mapper.selectByPrimaryKey(record);
		if (selectByPrimaryKey == null) {
			mapper.insert(record);
			return "insert";
		} else {
			mapper.updateByPrimaryKey(record);
			return "update";
		}
	}
	
	public int delete(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		return mapper.delete(record);

	}
	
	

	public int deleteByPrimaryKey(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		return mapper.deleteByPrimaryKey(record);
	}
	
	public Mapper<T> getMapperBean(Class<T> c) {
		return SpringUtils.getMapperBean(c);
}

	public static void main(String[] args) {
		System.out.println(String.class.getName());

	}
}
