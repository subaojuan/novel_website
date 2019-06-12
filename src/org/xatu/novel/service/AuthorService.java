package org.xatu.novel.service;

import java.util.List;
import java.util.Map;

import org.xatu.novel.pojo.Author;
import org.xatu.novel.pojo.Experience;
/**
 * 对作者相关信息进行操作。
 * @author Feng
 * 2019年5月6日下午4:40:54
 */
public interface AuthorService {

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
	
	Map<String, Object> selectAuthor(String id);
	
	List<?> selectNovelByAuthor(String authorName);
	
	int addNovelCount(String name);
}
