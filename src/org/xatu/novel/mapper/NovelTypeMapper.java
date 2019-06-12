package org.xatu.novel.mapper;

import java.util.List;
import java.util.Map;

/**
 * {@link NovelType}的{@code Mapper}接口
 * @author Feng
 * 2019年1月17日下午5:14:07
 */
public interface NovelTypeMapper {
	/**
	 * 列出所有的小说类型，按照{@code type_name}的格式返回成List集合
	 * @return {@link List}
	 */
	List<String> listTypes();
	
	/**
	 * 通过类型名查找类型id
	 * @param typeName 类型名
	 * @return
	 */
	Map<String, Object> getIdByName(String typeName);
	
	/**
	 * 通过类型编号找到指定类型的小说的信息（前10条）。
	 * 当数目在10条以下时，将取出所有数据。
	 * @param type_id 对应的类型id
	 * @return
	 */
	List<?> selectByType(Integer type_id);
	
	/**
	 * 通过类型编号查找指定的类型小说。
	 * @param type_id
	 * @return
	 */
	List<?> typeIndex(Integer type_id);
	
	/**
	 * 通过类型编号查找到指定的类型名
	 * @param type_id
	 * @return
	 */
	Map<String ,Object> selectNameById(Integer type_id);
}
