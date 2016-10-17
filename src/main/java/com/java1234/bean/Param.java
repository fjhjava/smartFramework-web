package com.java1234.bean;

import java.util.Map;

import com.java1234.util.CastUtil;

/**
 * 封装参数对象
 * @author phantomfjh
 *
 */
public class Param {
	
	private Map<String,Object> paramMap;

	public Param(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}
	
	public long getLong(String name){
		return CastUtil.castLong(paramMap.get(name));
	}
	
	public Map<String, Object> getParamMap() {
		return paramMap;
	}

}
