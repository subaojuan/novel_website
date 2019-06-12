package org.xatu.novel.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;
/**
 * 公共工具类。提供了获取UUID，MD5加密，SHA256加密，日期转换等方法。
 * @author Feng
 * 2019年1月18日下午5:52:49
 */
public class CommonsUtil {
	
	/**
	 * 获取UUID,并且使用空字符串替换{@code “-”};
	 * 英文字母全转换为大写。
	 * @return 32位长度的字符串(uuid)
	 */
	public final static String getUUID() {
		String uid = UUID.randomUUID().toString();
		uid = uid.replace("-", "");
		return uid.toUpperCase();
	}
	
	/**
	 * 使用md5的算法进行加密
	 * @param plainText 目标字符串
	 * @return 加密后的字符串
	 */
	public final static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5这个算法！");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
		// 如果生成数字未满32位，需要前面补0
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}
	
	/**
	 * 得到sql的日期。
	 * @param date 工具包的日期
	 * @return sql包的日期
	 */
	public static Date toSqlDate(java.util.Date date) {
		return new Date(date.getTime());
	}
	
	/**
	 * {@code sql}日期转换到{@code util}日期。
	 * @param date sql包的日期
	 * @return 工具包的日期，其格式为{@code yyyy-MM-dd}
	 */
	public static java.util.Date toUtilDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		
		java.util.Date res = null;
		try {
			res = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 指定字符串格式转换为日期类型。
	 * @param str
	 * @return
	 */
	public static java.util.Date StringToDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * SHA-256加密
	 * @param plainText 目标文本
	 * @return 加密后的文本，64位
	 * 例如：<pre>
	 * {@code System.out.println(SHA256("冯劲松"));}
	 * 将得到：
	 * <pre>94e414d04a3fe2000be487f17e48ade9f0a9a4f684cedf0e69247f8f04c562f0
	 */
	public static String SHA256(String plainText) {
		return SHA(plainText,"SHA-256");
	}
	
	
	/**
	 * SHA加密。
	 * @param strText 目标文本
	 * @param strType 加密类型；推荐使用"SHA-256"
	 * @return 加密后的文本
	 */
	private static final String SHA(String strText, String strType) {
		String result = null;
		if(strText != null && strText.length() != 0) {
			try {
				// 加密类型
				MessageDigest md = MessageDigest.getInstance(strType);
				// 传入要加密的字符串。
				md.update(strText.getBytes());
				// 得到byte类型结果。
				byte[] byteBuffer = md.digest();
				
				StringBuffer strHexString = new StringBuffer();
				for(int i = 0; i < byteBuffer.length; i ++) {
					String hex = Integer.toHexString(0xff & byteBuffer[i]);
					if(hex.length() == 1) {
						strHexString.append('0');
					}
					strHexString.append(hex);
				}
				result = strHexString.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 判断字符串是否为空。特殊的，当字符串是null时，也判断为空。
	 * @param str
	 * @return 当字符串为null或空字符串时(剔除两边空格)，表示其为空，返回true。
	 */
	public static final boolean strIsEmpty(String str) {
		return (str == null) || (str.trim().equals("")) || (str.equals("null"));
	}
	
}
