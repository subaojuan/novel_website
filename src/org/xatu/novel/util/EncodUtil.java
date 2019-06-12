package org.xatu.novel.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

/**
 * 解决从页面接收数据时，发生的中文乱码现象。
 * @author Feng
 * 2019年1月18日下午5:38:55
 */
public class EncodUtil {

	/**
	 * 将从页面获取到的数据进行编码转换。成为UTF-8格式。
	 * @param date 从页面获取到的字符串
	 * @return utf-8格式的字符串
	 */
	public static String toUtf8(String date) {
		String result = null;
		try {
			result = new String(date.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 设置request的编码格式为UTF-8。
	 * @param request
	 */
	public static void requestEncod(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
