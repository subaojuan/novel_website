package org.xatu.novel.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xatu.novel.service.NovelTypeService;
import org.xatu.novel.util.StringUtil;

@Controller
public class TypeController {

	@Autowired
	private NovelTypeService service;
	
	/**
	 * 显示商品列表
	 * @return
	 */
	@RequestMapping("/types")
	public String queryItemList(HttpSession session) {

		// 将类型x（玄幻等）类型的小说信息取出来
		Map<String, List<?>> typeXNovelsMap = new LinkedHashMap<String, List<?>>(11);
		for (int i = 1; i <= 11; i++) {
			typeXNovelsMap.put(i+"", this.service.selectByType(i));
		}
		session.setAttribute("typeXNovelsMap", typeXNovelsMap);
		// 获取商品数据
		List<String> list = service.listType();
		// 把商品数据放到模型中
		session.setAttribute("types", list);
		// 榜单数据，前5。暂时不从redis中查榜单
		//session.setAttribute("tops", StringUtil.getTops());
		return "index";
	}
	
	
	/**
	 * 显示某一类型的所有小说。
	 * @param type 指定的小说类型编号
	 * @return
	 */
	@RequestMapping("/type")
	public String typeIndex(@RequestParam("type")Integer type, HttpSession session) {
		List<?> typeIndex = service.typeIndex(type);
		Map<String, Object> typeIndexNameMap = service.selectNameById(type);
		session.setAttribute("typeIndex", typeIndex);
		session.setAttribute("typeIndexNameMap", typeIndexNameMap);
		return "typeIndex";
	}

}


