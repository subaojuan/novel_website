package org.xatu.novel.mapper;

import java.util.Map;

import org.xatu.novel.pojo.User;

/**
 * 用户映射接口。
 * {@link User}
 * @author Feng
 * 2019年1月21日下午4:47:50
 */
public interface UserMapper {

	/**
	 * 通过用户名查询对应的用户。
	 * @param name
	 * @return
	 */
	String distinctByName(String name);
	
	/**
	 * 增加一条用户数据，实际上是给数据库中的user_register表插入数据。
	 * 并且，同时对用户表进行插入数据。
	 * @return
	 */
	int addUser(User user);
	
	/**
	 * 用户激活，当点击邮箱中的链接时，会调用到该方法，进行对user_main中的live列的修改操作。
	 * @param key
	 * @return
	 */
	int activate(String key);
	
	/**
	 * 查询用户详情信息。
	 * @param name 用户名
	 * @return 
	 */
	Map<String, Object> selectUserDetail(String name);
	
	/**
	 * 更新头像。
	 * @param map 其中的两个键分别是newDisplay和id。
	 * newDisplay 新的头像的字符串。 id是表user_main的id。
	 * @return
	 */
	int changeDisplay(Map<String, String> map);
	
	/**
	 * 更新昵称。
	 * @param map 其中的两个键分别是用户的新的昵称name和id。
	 * id是表user_main(user_register的id与之相同)的id。
	 * @return
	 */
	int updateName(Map<String, String> map);
	
	/**
	 * 更新个人描述。
	 * @param map 其中的两个键分别是用户的info和id。
	 * id是表user_main的id。
	 * @return
	 */
	int updateInfo(Map<String, String> map);
	
	/**
	 * 更新故乡。
	 * @param map 其中的两个键分别是city和id。
	 * id是表user_main的id。
	 * @return
	 */
	int updateCity(Map<String, String> map);
	
	/**
	 * 更新钱包。在原始钱包数额基础上增加。
	 * @param map
	 * @return
	 */
	int updateMoney(Map<String, String> map);
	/**
	 * 查询到原始钱包数额。
	 * @param map
	 * @return
	 */
	int selectMoney(Map<String, String> map);
	
	/**
	 * 用户是否已经激活。实质上是查询到该数据表中的激活状态栏的数值。
	 * 对应的字段是{@code live}。
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
