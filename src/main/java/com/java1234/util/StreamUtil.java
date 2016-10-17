package com.java1234.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 流操作工具类
 * @author phantomfjh
 *
 */
public final  class StreamUtil {
	
	/**
	 * 从输入流当中获取字符串
	 * @param is
	 * @return
	 */
	public static String getString(InputStream is){
		StringBuilder sb=new StringBuilder();
		BufferedReader reader=new BufferedReader(new InputStreamReader(is));
		String line=null;
		try {
			while((line=reader.readLine())!=null){
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
