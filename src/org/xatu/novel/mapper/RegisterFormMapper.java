package org.xatu.novel.mapper;

import org.xatu.novel.pojo.RegisterForm;

public interface RegisterFormMapper {

	/**
	 * 添加表单数据，给user_register表增加数据
	 * @param form
	 * @return
	 */
	int addForm(RegisterForm form);
	
	/**
	 * 登陆操作。查询注册表，找到用户姓名和密码并返回。
	 * @param name 用户名
	 * @return
	 */
	String login(String name);
}
