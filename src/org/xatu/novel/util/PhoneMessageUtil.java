package org.xatu.novel.util;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
/**
 * 手机发送验证码。
 * @author Feng
 * 2019年2月13日下午4:37:53
 */
public class PhoneMessageUtil {

	/**
	 * 发送短信。
	 * @param smsMob 目标手机号
	 * @param smsText 短信内容
	 * @return 结果
	 * @throws IOException 
	 * @throws HttpException 
	 */
	private static String sendOneMessage(String smsMob, String smsText) throws HttpException, IOException {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn"); 
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
		NameValuePair[] data ={ new NameValuePair("Uid", "smsfeng"),// 注册的用户名
				new NameValuePair("Key", "d41d8cd98f00b204e980"),// 注册成功后，登陆网站使用的秘钥
				new NameValuePair("smsMob", smsMob),// 目标手机号
				new NameValuePair("smsText", smsText)};// 短信内容
		post.setRequestBody(data);

		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers)
		{
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("gbk"));

		System.out.println(result);
		post.releaseConnection();
		return result;
	}
	
	/**
	 * 给目标手机发送指定内容的短信。
	 * @param smsMob 目标手机号
	 * @param smsText 短信内容。
	 * @return 
	 */
	public static String sendMessage(String smsMob, String smsText) {
		String res = null;
		try {
			res = sendOneMessage(smsMob, smsText);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
}
