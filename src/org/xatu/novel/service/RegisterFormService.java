package org.xatu.novel.service;

import org.xatu.novel.pojo.RegisterForm;
/**
 * 注册表服务接口。
 * @author Feng
 * 2019年1月24日下午1:54:48
 */
public interface RegisterFormService {

	/**
	 * 注册，增加一条数据到该表中
	 * @param form
	 * @return
	 */
	int addRegisterForm(RegisterForm form);
	
	/**
	 * 登陆，查询对应名字的一条注册表信息。
	 * @param name
	 * @return 若有数据就返回一个{@link String}对象,即密码。无数据，返回null
	 */
	String login(String name);
}
