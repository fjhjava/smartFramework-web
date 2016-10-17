package com.java1234.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.java1234.util.ReflectionUtil;

/**
 * bean助手类
 * @author phantomfjh
 *
 */
public final class BeanHelper {

	private static final Map<Class<?>,Object> BEAN_MAP=new HashMap<Class<?>, Object>();
	
	static{
		Set<Class<?>> beanClassSet=ClassHelper.getBeanClassSet();
		for(Class<?> beanClass:beanClassSet){
			Object obj=ReflectionUtil.newInstance(beanClass);
			BEAN_MAP.put(beanClass, obj);
		}
	}
	
	/**
	 * 获取bean映射
	 * @return
	 */
	public static Map<Class<?>,Object> getBeanMap(){
		return BEAN_MAP;
		
	}
	
	/**
	 * 获取bean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> cls){
		if(!BEAN_MAP.containsKey(cls)){
			throw new RuntimeException("can not get bean by class "+cls);
		}
		return (T) BEAN_MAP.get(cls);
	}
}
