package org.xatu.novel.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xatu.novel.mapper.NovelMapper;
import org.xatu.novel.pojo.Novel;
import org.xatu.novel.pojo.NovelMain;

@Service
public class NovelServiceImpl implements NovelService {

	@Autowired
	private NovelMapper mapper;

	@Override
	public List<?> selectNovels() {
		return this.mapper.selectNovels();
	}

	@Override
	public List<?> select(String name) {
		return mapper.select(name);
	}

	@Override
	public Map<String, Object> detail(String name) {
		return mapper.detail(name);
	}

	@Override
	public List<?> units(String name) {
		return mapper.units(name);
	}

	@Override
	public Map<String, Object> mainInfo(Map<String, Object> map) {
		return mapper.mainInfo(map);
	}

	@Override
	public Map<String, Object> totalUnit(String name) {
		return mapper.totalUnit(name);
	}

	@Override
	public int addNovel(Novel novel) {
		return mapper.addNovel(novel);
	}

	@Override
	public Map<String, Object> selectNovelDetail(String name) {
		return mapper.selectNovelDetail(name);
	}

	@Override
	public int updateNovelDetail(Novel novel) {
		return mapper.updateNovelDetail(novel);
	}

	@Override
	public List<?> selectUnitByName(String name) {
		return mapper.selectUnitByName(name);
	}

	@Override
	public Map<String, Object> selectIdByName(String name) {
		return mapper.selectIdByName(name);
	}

	@Override
	public int updateContent(NovelMain novelMain) {
		return mapper.updateContent(novelMain);
	}



}
