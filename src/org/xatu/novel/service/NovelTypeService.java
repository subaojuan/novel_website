package org.xatu.novel.service;

import java.util.List;
import java.util.Map;
/**
 * 小说类型表的服务层接口。
 * @author Feng
 * 2019年1月17日下午4:32:17
 */
public interface NovelTypeService {
	/**
	 * 列出所有的类型名
	 * @return {@link List}
	 */
	List<String> listType();
	
	Map<String, Object> getIdByName(String typeName);
	
	List<?> selectByType(Integer type_id);
	
	List<?> typeIndex(Integer type_id);
	
	Map<String ,Object> selectNameById(Integer type_id);
}
