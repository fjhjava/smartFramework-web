package com.java1234.helper;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;

import com.java1234.annotation.Inject;
import com.java1234.util.ArrayUtil;
import com.java1234.util.ReflectionUtil;

/**
 * 依赖注入助手类
 * 
 * @author phantomfjh
 *
 */
public final class IocHelper {

	static {
		// 获取所有bean映射
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if (CollectionUtils.isNotEmpty((Collection<?>) beanMap)) {
			// 遍历bean map
			for (Map.Entry<Class<?>, Object> beanFactory : beanMap.entrySet()) {
				// 从bean map 中取出bean 与bean实例
				Class<?> beanClass = beanFactory.getKey();
				Object beanInstance = beanFactory.getValue();
				// 获取bean所有成员变量
				Field[] beanFields = beanClass.getDeclaredFields();
				if (ArrayUtil.isNotEmpty(beanFields)) {
					for (Field beanField : beanFields) {
						// 判断当前bean field是否带有inject注释
						if (beanField.isAnnotationPresent(Inject.class)) {
							// 在bean map获取bean field对应的实例
							Class<?> beanFieldClass = beanField.getType();
							Object beanFieldInstance = beanMap.get(beanFieldClass);
							if (beanFieldInstance != null) {
								// 通过反射初始化beanField
								ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
							}
						}
					}
				}
			}
		}
	}
}
