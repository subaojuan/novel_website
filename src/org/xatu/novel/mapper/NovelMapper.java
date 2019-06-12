package org.xatu.novel.mapper;

import java.util.List;
import java.util.Map;

import org.xatu.novel.pojo.Novel;
import org.xatu.novel.pojo.NovelMain;
/**
 * 对实体类{@link org.xatu.novel.pojo.Novel}操作的接口
 * @author Feng
 * 2019年4月22日下午3:06:35
 */
public interface NovelMapper {

	/**
	 * 插入一本小说的信息
	 * @return
	 */
	int addNovel(Novel novel);
	
	/**
	 * 查找所有小说信息。
	 * @return
	 */
	List<?> selectNovels();
	
	/**
	 * 模糊查询。通过小说名查询相关小说。
	 * @param name
	 * @return
	 */
	List<?> select(String name);
	
	/**
	 * 按照名字查找小说详情。
	 * @param name 小说名
	 * @return 小说信息
	 */
	Map<String, Object> detail(String name);
	
	/**
	 * 按照小说名查询到小说对应的所有章节。
	 * @param name
	 * @return
	 */
	List<?> units(String name);
	
	/**
	 * 查询核心信息。指定小说的对应的单元。用于在线浏览。
	 * @param map
	 * @return
	 */
	Map<String, Object> mainInfo(Map<String, Object> map);
	
	/**
	 * 查询，有效的小说单元数目
	 * @param name
	 * @return
	 */
	Map<String, Object> totalUnit(String name);
	
	/**
	 * 根据小说名字查询到小说的详细信息（部分信息）。
	 * 此方法专门用于对修改页面的数据呈现。
	 * @param name
	 * @return
	 */
	Map<String, Object> selectNovelDetail(String name);
	
	/**
	 * 更新小说信息
	 * @param novel
	 * @return
	 */
	int updateNovelDetail(Novel novel);
	
	/**
	 * 查询某一指定书名的所有单元详细信息
	 * @param name 书名
	 * @return
	 */
	List<?> selectUnitByName(String name);
	
	/**
	 * 通过书名查找书的id
	 * @param name
	 * @return
	 */
	Map<String, Object> selectIdByName(String name);
	
	/**
	 * 更新单元内容
	 * @param map
	 * @return
	 */
	int updateContent(NovelMain novelMain);
}
