package org.xatu.novel.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xatu.novel.mapper.UserMapper;
import org.xatu.novel.pojo.User;
import org.xatu.novel.util.CommonsUtil;
/**
 * 用户业务实现类。
 * @author Feng
 * 2019年1月23日下午4:49:46
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public String distinctByName(String name) {
		return mapper.distinctByName(name);
	}

	@Override
	public int addUser(User user) {
		return mapper.addUser(user);
	}

	@Override
	public int activate(String code) {
		return mapper.activate(code);
	}


	@Override
	public Map<String, Object> selectUserDetail(String name) {
		Map<String, Object> map = mapper.selectUserDetail(name);
		// 转换日期格式。只保留年月日。
		Date birthday0 = (Date) map.get("birthday");
		java.sql.Date birthday = null;
		if(birthday0 != null) 
			birthday = CommonsUtil.toSqlDate(birthday0);
		java.sql.Date last_modified_date = CommonsUtil.
				toSqlDate((Date) map.get("last_modified_date"));
		java.sql.Date register_date = CommonsUtil.
				toSqlDate((Date) map.get("register_date"));
		map.put("last_modified_date", last_modified_date);
		map.put("birthday", birthday);
		map.put("register_date", register_date);
		return map;
	}

	@Override
	public int changeDisplay(Map<String, String> map) {
		return mapper.changeDisplay(map);
	}

	@Override
	public int updateName(Map<String, String> map) {
		return mapper.updateName(map);
	}

	@Override
	public int updateInfo(Map<String, String> map) {
		return mapper.updateInfo(map);
	}

	@Override
	public int updateCity(Map<String, String> map) {
		return mapper.updateCity(map);
	}

	@Override
	public int updateMoney(Map<String, String> map) {
		return mapper.updateMoney(map);
	}

	@Override
	public int isActivated(Map<String, String> map) {
		return mapper.isActivated(map);
	}

	@Override
	public String selectCode(Map<String, String> map) {
		return mapper.selectCode(map);
	}
	
	

}
