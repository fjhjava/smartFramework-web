package com.java1234.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编解码工具类
 * 
 * @author phantomfjh
 *
 */
public final class CodecUtil {

	/**
	 * url编码
	 * 
	 * @param source
	 * @return
	 */
	public static String encodeURL(String source) {
		String target = null;
		;

		try {
			target = URLEncoder.encode(source, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return target;

	}

	public static String decodeURL(String source) {
		String target = null;
		try {
			target = URLDecoder.decode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return target;
	}

}
