package com.java1234.bean;

import java.lang.reflect.Method;

/**
 * 封装Action
 * 
 * @author phantomfjh
 *
 */
public class Handler {

	// Cobtroller类
	private Class<?> controllerClass;
	// action方法
	private Method actionMethod;

	public Class<?> getControllerClass() {
		return controllerClass;
	}

	public 	Method getActionMethod() {
		return actionMethod;
	}

	public Handler(Class<?> controllerClass, Method actionMethod) {
		this.controllerClass = controllerClass;
		this.actionMethod = actionMethod;
	}

}
