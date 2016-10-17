package com.java1234.helper;

import java.util.HashSet;
import java.util.Set;

import com.java1234.annotation.Controller;
import com.java1234.annotation.Service;
import com.java1234.util.ClassUtil;

/**
 * 类操作助手类
 * @author phantomfjh
 *
 */
public final class ClassHelper {
	// 用于存放所有加载的类
	private static final Set<Class<?>> CLASS_SET;

	static {
		String basePackage = ConfigHelper.getAppBasePackage();
		CLASS_SET = ClassUtil.getClassSet(basePackage);
	}

	// 获取应用包下的类
	public static Set<Class<?>> getClassSet() {
		return CLASS_SET;
	}

	// 获取所有service类
	public static Set<Class<?>> getServiceClassSet() {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : CLASS_SET) {
			if (cls.isAnnotationPresent(Service.class)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}

	// 获取所有controller类
	public static Set<Class<?>> getControllerClassSet() {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : CLASS_SET) {
			if (cls.isAnnotationPresent(Controller.class)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}

	// 获取所有beanr类(service,controller..)
	public static Set<Class<?>> getBeanClassSet() {
		Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
		beanClassSet.addAll(getServiceClassSet());
		beanClassSet.addAll(getControllerClassSet());
		return beanClassSet;
	}

}
