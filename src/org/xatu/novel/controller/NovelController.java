package org.xatu.novel.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xatu.novel.pojo.NovelMain;
import org.xatu.novel.service.NovelService;
import org.xatu.novel.util.CommonsUtil;
import org.xatu.novel.util.KafkaProductor;
import org.xatu.novel.util.StringUtil;
/**
 * 小说控制层。
 * @author Feng
 * 2019年4月27日下午12:33:35
 */
@Controller
public class NovelController {

	@Autowired
	private NovelService novelService;
	
	/**
	 * 查询所有小说信息:测试时使用。
	 * @param session
	 * @return
	 */
	@Deprecated
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/top")
	public String listNovels(HttpSession session) {
		List<?> tops = novelService.selectNovels();
		Map<String, Object> novel = (Map<String, Object>) tops.get(0);
		System.out.println(novel.get("name"));
		System.out.println(tops.get(1));
		session.setAttribute("tops", tops);
		return "top";
	}
	
	/**
	 * 模糊查询，通过小说名进行查询小说信息。
	 * @param name 小说名
	 * @param request
	 * @return 查询页面
	 */
	@RequestMapping(value="/select")
	public String select(@RequestParam("novel_name")String novelName, HttpServletRequest request) {
		List<?> novels = novelService.select(novelName);
		request.setAttribute("novels", novels);
		return "select";
	}
	
	/**
	 * 小说详情页。进入之前，将小说名字传送到Kafka中。
	 * @param name
	 * @return 详情页面
	 */
	@RequestMapping(value="/detail")
	public String detail(@RequestParam("name")String name, HttpServletRequest request) {
		// 将小说名字传送到Kafka中。服务没开启时，注释该语句
		KafkaProductor.producer(name);	
		// 小说详情
		Map<String, Object> detail = novelService.detail(name);
		// 所有单元（章节）
		List<?> units = novelService.units(name);
		request.setAttribute("detail", detail);
		request.setAttribute("units", units);
		return "detail";
	}
	
	@RequestMapping(value="/mainInfo")
	public String content(@RequestParam("name")String name, 
			@RequestParam("unit")Integer unit, HttpServletRequest request) {
		// 从页面获取到查询所需要的条件，小说名和指定单元
		Map<String, Object> webData = new LinkedHashMap<String, Object>(2);
		webData.put("name", name);
		webData.put("unit", unit);
		// 查找数据
		Map<String, Object> data = novelService.mainInfo(webData);
		// 处理数据格式问题
		String content = null;
		try {
			content = StringUtil.ClobToString((Clob) data.get("content"));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		data.put("unit", unit);// 将当前章节数存储传送。
		if(content != null && !"".equals(content)) {
			// 内容放入map中。
			data.put("content", StringUtil.format(content));
		}
		// 分页所需数据 总的单元数。
		
		Map<String, Object> total = novelService.totalUnit(name);
		// 格式转换
		java.math.BigDecimal totalValue = (BigDecimal) total.get("tatal");
		Integer value = totalValue.intValue();
		data.put("lastUnit", value);
		request.setAttribute("data", data);
		return "read";
	}
	
	/**
	 * 去添加小说的页面
	 * @return
	 */
	@RequestMapping(value="/toAddNovel")
	public String toAddNovel() {
		return "addNovel";
	}
	
	@RequestMapping("/toModifying")
	public String toModifying(@RequestParam("name")String name, HttpServletRequest request) {
		request.setAttribute("novelDetail", novelService.selectNovelDetail(name));
		return "modifying";
	}
	
	/**
	 * 去到章节修改页面。
	 * @param novel
	 * @return
	 */
	@RequestMapping("toUnitsDetail")
	public String toUnitsDetail(@RequestParam("novel")String novel, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> unitList = (List<Map<String, Object>>) novelService.selectUnitByName(novel);
		// 处理内容：CLOB类型和String之间转换
		for (Map<String, Object> map : unitList) {
			try {
				map.put("content", StringUtil.ClobToString((Clob) (map.get("content"))));
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("novel", novel);
		request.setAttribute("unitList", unitList);
		return "toUpdateUnit";
	}
	
	/**
	 * 更新小说单元内容。
	 * @param novel
	 * @param unit
	 * @param content
	 * @return
	 */
	@RequestMapping("updateContent")
	public String updateContent(@RequestParam("novel")String novel, 
			@RequestParam("unit")String unit, 
			@RequestParam("content")String content) {
		String id = (String) novelService.selectIdByName(StringUtil.IOStoUTF8(novel)).get("novel_id");
		NovelMain novelMain = new NovelMain();
		novelMain.setNovel_id(id);
		novelMain.setContent(StringUtil.IOStoUTF8(content));
		novelMain.setUnit(Integer.parseInt(StringUtil.IOStoUTF8(unit)));
		novelMain.setUpdate_date(new Date());
		System.out.println(novelMain);
		novelService.updateContent(novelMain);
		return "index";
	}
}
