package org.xatu.novel.service;

import java.util.Map;

import org.xatu.novel.pojo.User;

/**
 * 用户服务接口
 * @author Feng
 * 2019年1月21日下午5:33:36
 */
public interface UserService {

	/**
	 * 查找用户名并返回。
	 * @param name 要查找的用户名
	 * @return
	 */
	String distinctByName(String name);
	
	/**
	 * 增加一条数据到user_main表中
	 * @param user
	 * @return
	 */
	int addUser(User user);
	
	/**
	 * 通过激活码，进行用户账号激活
	 * @param code
	 * @return
	 */
	int activate(String code);
	
	/**
	 * 查询用户的详细信息 ，主要从{@code user_register}表和{@code user_main}表中查询数据
	 * 同时还有{@code user_experience}表的{@code id}，默认其为空
	 * @param name 用户名
	 * @return 包含几乎所有信息的{@code map}对象
	 */
	Map<String, Object> selectUserDetail(String name);
	
	/**
	 * 更新头像。调用mapper中的同名方法。
	 * @param newDisplay
	 * @param id
	 * @return
	 */
	int changeDisplay(Map<String, String> map);
	
	/**
	 * 更新昵称。调用mapper中的同名方法。
	 * @param map
	 * @return
	 */
	int updateName(Map<String, String> map);
	
	/**
	 * 更新个人描述。调用mapper中的同名方法。
	 * @param map
	 * @return
	 */
	int updateInfo(Map<String, String> map);
	
	/**
	 * 更新故乡。调用mapper中的同名方法。
	 * @param map
	 * @return
	 */
	int updateCity(Map<String, String> map);
	
	/**
	 * 更新钱包。
	 * @param map
	 * @return
	 */
	int updateMoney(Map<String, String> map);
	
	/**
	 * 激活状态的查询。是否激活。
	 * @param map
	 * @return
	 */
	int isActivated(Map<String, String> map);
	
	/**
	 * 查询用户的激活码
	 * @param map
	 * @return
	 */
	String selectCode(Map<String, String> map);
}
