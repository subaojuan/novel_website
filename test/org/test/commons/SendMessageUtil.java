package org.test.commons;

import org.junit.Test;
import org.xatu.novel.util.PhoneMessageUtil;
/**
 * 测试发送短信。
 * @author Feng
 * 2019年2月13日下午5:36:45
 */
public class SendMessageUtil {

	@Test
	public void test() {
		String res = PhoneMessageUtil.sendMessage("13259822660", "验证码：1249");
		System.out.println(res);
	}
}
