package org.xatu.novel.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.xatu.novel.pojo.Novel;
import org.xatu.novel.service.AuthorService;
import org.xatu.novel.service.NovelService;
import org.xatu.novel.service.NovelTypeService;
import org.xatu.novel.service.UserService;
import org.xatu.novel.util.CommonsUtil;
/**
 * 文件操作的控制类。
 * @author Feng
 * 2019年4月5日下午2:34:57
 */
@Controller
public class FileController {

	@Autowired
	private UserService userService;
	@Autowired
	private NovelService novelService;
	@Autowired
	private NovelTypeService typeService;
	@Autowired
	private AuthorService authorService;
	/**
	 * 上传头像。这里不做file的判断。
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/displaying")
	public String uploadDisplay(@RequestParam("display") CommonsMultipartFile file,HttpServletRequest request)
			throws IOException {
		//获取文件名称
		String fileName = file.getOriginalFilename();
		//写入本地磁盘
		InputStream is = file.getInputStream();
		byte[] bs = new byte[1024];
		int len;
		String savePath = request.getServletContext().getRealPath("/")+"img/displays/";
		OutputStream os = new FileOutputStream(
				new File(savePath + fileName));
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		os.close();
		is.close();
		
		// 修改数据库中的数据。
		String user_main_id = request.getParameter("user_main_id");
		Map<String, String> map = new HashMap<String, String>(2);
		map.put("display", "img/displays/" + fileName);
		map.put("user_main_id", user_main_id);
		userService.changeDisplay(map);
		return "personal";
	}
	
	/**
	 * 上传小说封面。这里不做file的判断。
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/addNovel")
	public String uploadNovelFace(@RequestParam("novelFace") CommonsMultipartFile file, 
			HttpServletRequest request, 
			@RequestParam("new_novel_name")String name, // 小说名字
			@RequestParam("new_novel_type")String type, // 小说类型名
			@RequestParam("new_novel_info")String info, // 小说的基本信息
			@RequestParam("authorId")String authorId) // 作者的id
			throws IOException {
		String fileName = null;
		if(!file.isEmpty()) {
			//获取文件名称
			fileName = file.getOriginalFilename();
			//写入本地磁盘
			InputStream is = file.getInputStream();
			byte[] bs = new byte[1024];
			int len;
			String savePath = request.getServletContext().getRealPath("/")+"img/novel_pic/novelsFace/";
			OutputStream os = new FileOutputStream(
					new File(savePath + fileName));
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			os.close();
			is.close();
		}
		
		// 查找对应类型名的类型编号
		Map<String, Object> type_id_name = typeService.getIdByName(type);
		Integer type_id = Integer.parseInt(type_id_name.get("type_id").toString());
		// 修改数据库中的数据。
		Novel novel = new Novel(CommonsUtil.getUUID(), type_id, 
				authorId, name, new Date(), info, file.isEmpty() ? "img/novel_pic/novelFace.png" : 
					"img/novel_pic/novelsFace/" + fileName, 
					"暂无信息", 0, new Date());
		novelService.addNovel(novel);
		// 更改作者表中的作品数目
		authorService.addNovelCount(authorService.selectAuthor(authorId).get("name").toString());
		return "index";
	}
	
	
	/**
	 * 更新小说的基本信息。
	 * @param file
	 * @param request
	 * @param new_novel_name
	 * @param new_novel_info
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("updateNovelDetail")
	public String updateNovel(@RequestParam("novelFace") CommonsMultipartFile file, 
			HttpServletRequest request, 
			@RequestParam("new_novel_name")String new_novel_name,
			@RequestParam("new_novel_info")String new_novel_info) 
					throws IOException {
		String fileName = null;
		if(!file.isEmpty()) {
			//获取文件名称
			fileName = file.getOriginalFilename();
			//写入本地磁盘
			InputStream is = file.getInputStream();
			byte[] bs = new byte[1024];
			int len;
			String savePath = request.getServletContext().getRealPath("/")+"img/novel_pic/novelsFace/";
			OutputStream os = new FileOutputStream(
					new File(savePath + fileName));
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			os.close();
			is.close();
		}
		// 更新数据
		Novel novel = new Novel();
		novel.setImg(fileName == null ? null : "img/novel_pic/novelsFace/" + fileName);
		novel.setInfo(new_novel_info);
		novel.setName(new_novel_name);
		novelService.updateNovelDetail(novel);
		return "index";
	}
	
	/**
	 * 下载文件
	 * @param request
	 * @param filename
	 * @param model
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,
            @RequestParam("filename") String filename,
            Model model,
            HttpServletResponse response) throws Exception{
		 // 下载文件路径
        String path = request.getServletContext().getRealPath("/novel/");
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();  
        // 下载显示的文件名，解决中文名称乱码问题  
        String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        // 弹出保存框即资源选择器  
        response.setHeader("Content-Disposition","attachment;filename=" + downloadFielName); 
        // application/octet-stream二进制流数据（文本下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                headers, HttpStatus.CREATED);  
	}
}
