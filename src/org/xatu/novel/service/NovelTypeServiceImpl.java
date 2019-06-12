package org.xatu.novel.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xatu.novel.mapper.NovelTypeMapper;
import org.xatu.novel.service.NovelTypeService;

@Service
public class NovelTypeServiceImpl implements NovelTypeService {

	@Autowired
	private NovelTypeMapper typeMapper;
	
	@Override
	public List<String> listType() {
		return this.typeMapper.listTypes();
	}

	@Override
	public Map<String, Object> getIdByName(String typeName) {
		return typeMapper.getIdByName(typeName);
	}

	@Override
	public List<?> selectByType(Integer type_id) {
		return typeMapper.selectByType(type_id);
	}

	@Override
	public List<?> typeIndex(Integer type_id) {
		return typeMapper.typeIndex(type_id);
	}

	@Override
	public Map<String, Object> selectNameById(Integer type_id) {
		return typeMapper.selectNameById(type_id);
	}

}
