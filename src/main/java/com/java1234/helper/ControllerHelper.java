package com.java1234.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

import com.java1234.annotation.Action;
import com.java1234.bean.Handler;
import com.java1234.bean.Request;
import com.java1234.util.ArrayUtil;

/**
 * 控制器助手类
 * @author phantomfjh
 *
 */
public final class ControllerHelper {
	//存放请求与处理器的映射关系
	private static final Map<Request,Handler> ACTION_MAP=new HashMap<Request, Handler>();
	
	static{
		//获取所有Controller类
		Set<Class<?>> controllerClassSet=ClassHelper.getControllerClassSet();
		if(CollectionUtils.isNotEmpty(controllerClassSet)){
			//遍历controller类
			for(Class<?> controllerClass:controllerClassSet){
				//获取方法
				Method[] methods=controllerClass.getDeclaredMethods();
				if(ArrayUtil.isNotEmpty(methods)){
					//遍历方法
					for(Method method:methods){
						if(method.isAnnotationPresent(Action.class)){
							//从action获取url
							Action action=method.getAnnotation(Action.class);
							String mapping=action.value();
							//验证url
							if(mapping.matches("\\w+:/\\w*")){
								String[] array=mapping.split(":");
								if(ArrayUtil.isNotEmpty(array)&&array.length==2){
									//获取请求方法
									String requestMethod=array[0];
									//获取请求路径
									String requestPath=array[1];
									Request request=new Request(requestMethod, requestPath);
									Handler handler=new Handler(controllerClass,method);
									//初始化action map
									ACTION_MAP.put(request, handler);
								}
							}
						}
					}
				}
			}
		}
	}
	
	//获取Handler
	public static Handler getHandler(String requestMethod, String requestPath){
		Request request=new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}

}
