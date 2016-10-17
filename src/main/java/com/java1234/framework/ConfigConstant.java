package com.java1234.framework;
/**
 * 用来维护配置文件中的配置项名称
 * @author phantomfjh
 *
 */
public interface ConfigConstant {
	
	//config file path
	String CONFIG_FILE="smart.properties";
	
	//jdbc driver
	String JDBC_DRIVER="smart.framework.jdbc.driver";
	//jdbc url
	String JDBC_URL="smart.framework.jdbc.url";
	//jdbc username
	String JDBC_USERNAME="smart.framework.jdbc.username";
	//jdbc password
	String JDBC_PASSWORD="smart.framework.jdbc.password";
	
	//app base package
	String APP_BASE_PACKAGE="smart.framework.app.base_package";
	//app jsp path
	String APP_JSP_PATH="smart.framework.app.jsp_path";
	//app asset path
	String APP_ASSET_PATH="smart.framework.app.asset_path";
	
	

}
