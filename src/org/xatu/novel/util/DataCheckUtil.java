package org.xatu.novel.util;
import java.util.regex.Pattern;

/**
 * 数据校验工具类。
 * @author Feng
 * 2019年1月23日下午2:46:12
 */
public class DataCheckUtil {

	/**
	 * 校验邮箱格式。
	 * @param email 邮箱
	 * @return 格式正确返回true。
	 */
	public static boolean isEmail(String email) {
		String patternStr = "^([A-Za-z0-9_\\-\\.])+"
				+ "\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$";
		return patternMatches(patternStr,email);
	}

	/**
	 * 校验手机格式。
	 * @param mobileNumber 手机号
	 * @return 格式正确返回true。
	 */
	public static boolean isPhoneNumber(String mobileNumber) {
		String patternStr = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9]))\\d{8}$";
		return patternMatches(patternStr,mobileNumber);
	}
	
	/**
	 * 包含中文校验。
	 * @param word 指定字符串
	 * @return 包含中文时，返回true。
	 */
	public static boolean inChinese(String word) {
		String patternStr = "[\u4E00-\u9FA5]";
		return patternFind(patternStr,word);
	}
	
	/**
	 * 校验密码格式，用户密码由6到32位字符，至少一个数字，大写字母，小写字母，特殊字符 {@code (@#$%^&*? )}。
	 * @param pwd 例如：{@code a123Ee#} 可以通过校验
	 * @return 格式正确时，校验通过返回true。
	 */
	public static boolean isPassword(String pwd) {
		String patternStr = "^.*(?=.{6,32})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*? ]).*$";
		return patternMatches(patternStr, pwd);
	}
	
	/**
	 * 校验的模板。只需要传入参数即可验证对应的字符串。
	 * {@code find }方法扫描输入序列以查找与该模式匹配的下一个子序列。 
	 * @param regex 验证格式，正则表达式。
	 * @param info 需要进行校验的信息
	 * @return 校验通过时，返回{@code true}。否则返回{@code false}。
	 */
	private static final boolean patternFind(String regex, String info) {
		if(CommonsUtil.strIsEmpty(info))
			return false;
		return Pattern.compile(regex).matcher(info).find();
	}
	
	/**
	 * 校验的模板。只需要传入参数即可验证对应的字符串。
	 * {@code matches} 方法尝试将整个输入序列与该模式匹配。
	 * @param regex 验证格式，正则表达式。
	 * @param info 需要进行校验的信息
	 * @return 校验通过时，返回{@code true}。否则返回{@code false}。
	 */
	private static final boolean patternMatches(String regex, String info) {
		if(CommonsUtil.strIsEmpty(info))
			return false;
		return Pattern.compile(regex).matcher(info).matches();
	}
	

}
