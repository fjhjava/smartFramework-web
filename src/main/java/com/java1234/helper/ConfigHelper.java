package com.java1234.helper;

import java.util.Properties;

import com.java1234.framework.ConfigConstant;
import com.java1234.util.PropertiesUtil;

/**
 * 属性文件助手类
 * 
 * @author phantomfjh
 *
 */
public final class ConfigHelper {

	private static final Properties CONFIG_PROPS = PropertiesUtil.loadProps(ConfigConstant.CONFIG_FILE);

	// get jdbc driver
	public static String getJdbcDriver() {
		return PropertiesUtil.getValue(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
	}

	// get jdbc url
	public static String getJdbcUrl() {
		return PropertiesUtil.getValue(CONFIG_PROPS, ConfigConstant.JDBC_URL);
	}

	// get jdbc username
	public static String getJdbcUserName() {
		return PropertiesUtil.getValue(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
	}

	// get jdbc password
	public static String getJdbcPassword() {
		return PropertiesUtil.getValue(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
	}

	// get app base package
	public static String getAppBasePackage() {
		return PropertiesUtil.getValue(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
	}

	// get app jsp path
	public static String getAppJspPath() {
		return PropertiesUtil.getValue(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB-INF/view/");
	}

	// get app asset path
	public static String getAppAssetPath() {
		return PropertiesUtil.getValue(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/asset/");
	}

}
