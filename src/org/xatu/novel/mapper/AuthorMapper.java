package org.xatu.novel.mapper;

import java.util.List;
import java.util.Map;

import org.xatu.novel.pojo.Author;
import org.xatu.novel.pojo.Experience;

/**
 * 对类{@link org.xatu.novel.pojo.Author}进行操作的接口，
 * 对类{@link org.xatu.novel.pojo.Experience}进行操作。
 * @author Feng
 * 2019年4月22日下午3:54:09
 */
public interface AuthorMapper {

	/**
	 * 增加一个作者。
	 * @param author 作者的相关信息。
	 * @return
	 */
	int addAuthor(Author author);
	
	/**
	 * 增加一条教育经历信息。
	 * @param experience 教育经历表中的相关信息。
	 * @return
	 */
	int addExperience(Experience experience);
	
	/**
	 * 查询作者信息。用于判断该id对应的作者是否存在。
	 * @param map
	 * @return
	 */
	Map<String, Object> selectAuthor(String id);
	
	/**
	 * 查询指定作者的名下的小说信息
	 * @param authorName 作者的笔名
	 * @return
	 */
	List<?> selectNovelByAuthor(String authorName);
	
	/**
	 * 当给该作者创建一个小说时，给其名下的小说数目加1
	 * @param name 对应的作者名
	 * @return
	 */
	int addNovelCount(String name);
}
