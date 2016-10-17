package com.java1234.util;

import java.io.File;
import java.io.FileFilter;
import java.util.Set;

/**
 * 类操作工具类
 * @author phantomfjh
 *
 */
public final class ClassUtil {
	//private static final Logger LOGGER=Logf;
	/**
	 * 获取类加载器
	 */
	public static ClassLoader getClassLoader(){
		return Thread.currentThread().getContextClassLoader();
	}
	
	/**
	 * 加载类
	 * @param className
	 * @param isInitalized
	 * @return cls
	 */
	public static Class<?> loadClass(String className, boolean isInitalized) {
		Class<?> cls;
		try {
			cls = Class.forName(className, isInitalized, getClassLoader());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return cls;
	}
	
	/**
	 * 获取指定包名下所有的类
	 * @param packageName
	 * @return
	 */
	public static Set<Class<?>> getClassSet(String packageName){
		
		return null;
		
	}
	
	@SuppressWarnings("unused")
	private static void addClass(Set<Class<?>> classSet,String packagePath,String packName){
		File[] files=new File(packagePath).listFiles(new FileFilter() {
			public boolean accept(File file) {
				return (file.isFile()&&file.getName().endsWith(".class"))|| file.isDirectory();
			}
		});
		for(File file:files){
			String fileName=file.getName();
			if(file.isFile()){
				String className=fileName.substring(0,fileName.lastIndexOf("."));
				if(StringUtil.isNotEmpty(packName)){
					className=packName+"."+className;
				}
				doAddClass(classSet,className);
			}else{
				String subPackagePath=fileName;
				if(StringUtil.isNotEmpty(subPackagePath)){
					subPackagePath=packagePath+"/"+subPackagePath;
				}
				String subPackageName=fileName;
				if(StringUtil.isNotEmpty(packName)){
					subPackageName=packName+"."+subPackageName;
				}
				addClass(classSet, subPackagePath, subPackageName);
			}
		}
		
	}

	private static void doAddClass(Set<Class<?>> classSet, String className) {
		Class<?> cls=loadClass(className, false);
		classSet.add(cls);
	}

}
