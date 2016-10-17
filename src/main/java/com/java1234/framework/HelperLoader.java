package com.java1234.framework;

import com.java1234.helper.BeanHelper;
import com.java1234.helper.ClassHelper;
import com.java1234.helper.ControllerHelper;
import com.java1234.helper.IocHelper;
import com.java1234.util.ClassUtil;

/**
 * 加载相应的Helper
 * @author phantomfjh
 *
 */
public final class HelperLoader {
	
	public static void init(){
		Class<?>[] classList={
			ClassHelper.class,
			BeanHelper.class,
			IocHelper.class,
			ControllerHelper.class
		};
		
		for(Class<?> cls:classList){
			ClassUtil.loadClass(cls.getName(),false);
		}
	}

}
