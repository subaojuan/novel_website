package org.xatu.novel.service;

import java.util.List;
import java.util.Map;

import org.xatu.novel.pojo.Novel;
import org.xatu.novel.pojo.NovelMain;

/**
 * 对小说映射类{@link org.xatu.novel.mapper.NovelMapper}
 * 中的方法进行服务。
 * @author Feng
 * 2019年4月27日下午5:01:07
 */
public interface NovelService {

	List<?> selectNovels();
	
	List<?> select(String name);
	
	Map<String, Object> detail(String name);
	
	List<?> units(String name);
	
	Map<String, Object> mainInfo(Map<String, Object> map);
	
	Map<String, Object> totalUnit(String name);

	int addNovel(Novel novel);
	
	Map<String, Object> selectNovelDetail(String name);
	
	int updateNovelDetail(Novel novel);
	
	List<?> selectUnitByName(String name);
	
	Map<String, Object> selectIdByName(String name);
	
	int updateContent(NovelMain novelMain);
}
