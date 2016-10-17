package com.java1234.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.java1234.framework.ConfigConstant;

/**
 * properties文件工具类
 * @author phantomfjh
 *
 */
public class PropertiesUtil {
/**
 * get value by key from smart.properties
 * @param key
 * @return
 */
	public static  String configPath=ConfigConstant.CONFIG_FILE;
	//get properties
	public  static Properties loadProps(String configPath)  {
		Properties prop = new Properties();
		InputStream in = new PropertiesUtil().getClass().getResourceAsStream("/"+configPath);
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	//get value by key
	public static String getValue(Properties prop, String key){
		prop=loadProps(configPath);
		return prop.getProperty(key);
	}
	
	//get value by key
		public static String getValue(Properties prop, String key,String deafult){
			prop=loadProps(configPath);
			return prop.getProperty(key);
		}
	
	/*public static void main(String[] args) throws IOException {
		System.out.println(PropertiesUtil.getValue(loadProps(ConfigConstant.CONFIG_FILE), ConfigConstant.JDBC_DRIVER));
	}*/
}
