package org.test.commons;

import java.util.Date;

import org.junit.Test;
import org.xatu.novel.util.CommonsUtil;
/**
 * 测试公共工具类。
 * @author Feng
 * 2019年1月18日下午6:08:53
 */
public class CommonsUtilTest {

	/**
	 * 测试加密SHA256
	 */
	@Test
	public void print() {
		String name = CommonsUtil.SHA256("冯劲松");
		System.out.println(name);
		System.out.println(name.length());
	}
	/**
	 * 测试日期转换
	 */
	@Test
	public void print1() {
		System.out.println(CommonsUtil.toSqlDate(new Date()));
	}
	
	/**
	 * 测试UUID
	 */
	@Test
	public void print2() {
		System.out.println(CommonsUtil.getUUID());	
	}
	
	@Test
	public void print3() {
			System.out.println(CommonsUtil.toSqlDate(new Date()));
	}
	
	
}
