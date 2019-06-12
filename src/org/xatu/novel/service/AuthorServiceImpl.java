package org.xatu.novel.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xatu.novel.mapper.AuthorMapper;
import org.xatu.novel.pojo.Author;
import org.xatu.novel.pojo.Experience;
/**
 * 用户升级为作者时，进行的相关操作。以及作者的相关操作。
 * @author Feng
 * 2019年5月6日下午4:41:51
 */
@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorMapper mapper;

	@Override
	public int addAuthor(Author author) {
		return mapper.addAuthor(author);
	}

	@Override
	public int addExperience(Experience experience) {
		return mapper.addExperience(experience);
	}

	@Override
	public Map<String, Object> selectAuthor(String id) {
		return mapper.selectAuthor(id);
	}

	@Override
	public List<?> selectNovelByAuthor(String authorName) {
		return mapper.selectNovelByAuthor(authorName);
	}

	@Override
	public int addNovelCount(String name) {
		return mapper.addNovelCount(name);
	}
	
}
