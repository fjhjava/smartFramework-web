package com.java1234.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON工具类
 * 
 * @author phantomfjh
 *
 */
public final class JsonUtil {

	private static final ObjectMapper OJECT_MAPPER = new ObjectMapper();

	// pojo--->json
	public static <T> String toJson(T obj) {
		String json = null;
		try {
			json = OJECT_MAPPER.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	// json-->pojo

	public static <T> T fromJson(String json, Class<T> type) {
		T pojo = null;
		try {
			pojo = OJECT_MAPPER.readValue(json, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pojo;
	}
}
