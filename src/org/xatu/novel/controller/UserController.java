package org.xatu.novel.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.xatu.novel.pojo.Author;
import org.xatu.novel.pojo.Experience;
import org.xatu.novel.pojo.RegisterForm;
import org.xatu.novel.pojo.User;
import org.xatu.novel.service.AuthorService;
import org.xatu.novel.service.NovelTypeService;
import org.xatu.novel.service.RegisterFormService;
import org.xatu.novel.service.UserService;
import org.xatu.novel.util.CommonsUtil;
import org.xatu.novel.util.DataCheckUtil;
import org.xatu.novel.util.EncodUtil;
/**
 * 用户{@code Controller}类。
 * @author Feng
 * 2019年1月23日下午5:51:12
 */
@Controller
public class UserController {

	@Autowired
	private NovelTypeService typeService;
	@Autowired
	private RegisterFormService registerService;
	@Autowired
	private UserService userService;
	@Autowired
	private AuthorService authorService;

	/**
	 * 获取注册页面所需的数据，跳转到注册页面。
	 * @return
	 */
	@RequestMapping("/register")
	public String toRegister(HttpSession session) {
		// 获取小说类型数据
		List<String> list = this.typeService.listType();
		// 把注册信息数据放到session中
		session.setAttribute("types", list);
		session.setAttribute("name_placeholder", "输入：昵称");
		session.setAttribute("email_placeholder", "输入：email@example.com");
		session.setAttribute("password_placeholder", 
				"密码：用户密码由6到32位字符组成，至少一个数字，大写字母，小写字母，特殊字符(@#$%^&*? );例如：a123Ee#");
		session.setAttribute("tel_placeholder", "手机：填写手机号码");
		// 返回到register.jsp页面
		return "register";
	}

	/**
	 * 获取前端数据，并持久化。进行修改数据。
	 * 该方法用来用户注册，给{@code user_register}表和{@code user_main}表插入数据。
	 * <ul>以下情况将反馈为：<i>{@link HttpSession}对象携带反馈信息，继续返回在register页面。</i>
	 * <li>当存在重复名字(此处查询一次数据库)时；
	 * <li>当密码验证不通过时；
	 * <li>当邮箱校验不通过时；
	 * <li>当注册表中填写了手机号，并且手机号验证不通过时；
	 * </ul>
	 * @param session {@link HttpSession}对象，不需要自己实例化
	 * @param registerForm {@link RegisterForm}对象，不需要自己实例化
	 * @return 页面对应的字符串(其实就是页面文件名，包括其前缀)，在{@code springmvc.xml}中配置了该后缀为{@code jsp}
	 */
	@RequestMapping(value ="/doRegister", method=RequestMethod.POST)
	public String doRegister(HttpSession session, RegisterForm registerForm) {
		String userName = userService.distinctByName(EncodUtil.
				toUtf8(registerForm.getName()));
		
		// 有重复名字
		if(userName != null && !"".equals(userName.trim())) {
			session.setAttribute("name_placeholder", "名字重复了，请再另外想一个昵称！");
			return "register";
		}
		// 密码校验
		if(!DataCheckUtil.isPassword(registerForm.getPassword())) {
			session.setAttribute("password_placeholder", "密码格式："
					+ "用户密码由6到32位字符组成，至少一个数字，大写字母，小写字母，特殊字符(@#$%^&*? )");
			return "register";
		}
		// 邮箱校验
		if(!DataCheckUtil.isEmail(registerForm.getEmail())) {
			session.setAttribute("email_placeholder", "邮箱格式：email@example.com");
			return "register";
		}
		// 当写了电话时，进行对手机号码格式校验
		if(registerForm.getTelephone() != null || "".equals(registerForm.getTelephone().trim())) {
			if(!DataCheckUtil.isPhoneNumber(registerForm.getTelephone())) {
				session.setAttribute("tel_placeholder", "手机格式不对哦");
				return "register";
			}
		}
		
		// 直接使用service中的方法，给user_register表中插入数据
		registerService.addRegisterForm(registerForm);
		User user = new User();
		user.setId(registerForm.getId());// user_register的id为其外键
		user.setCode(CommonsUtil.getUUID());
		user.setMoney(20.00);// 新用户赠送20.00点券
		user.setLast_modified_date(new Date());
		user.setRegister_date(new Date());
		user.setLive(0);// 默认未激活
		// 该方法的调用必须在注册表中数据增加之后(存在外键约束)，给user_main表插入数据
		userService.addUser(user);
		
		// 准备发送验证邮件,当确定注册过了该名字之后发送邮件
		// 暂时先使用session发送到页面，进行激活。
		// http://localhost:8080/springmvc-mybatis01/activate.action?code=uuid
		String emailContent = "<p>恭喜你注册成功了，请点击下边的这条链接进行激活</p>"
				+ "<a href='http://localhost:8080/springmvc-mybatis01/activate.action?code="
				+ user.getCode() + "'>http://localhost:8080/springmvc-mybatis01/activate.action?code="
				+ user.getCode() + "</a>";
		session.setAttribute("emailMessage", emailContent);
		
		// 后期，会将此处使用邮箱发送工具类，发送到邮箱中。即完成邮箱验证。发送邮件需要联网
		// MailUtils.send(registerForm.getEmail(), emailContent);
		
		
		return "html/success";// 成功页面
	}
	
	
	/**
	 * 激活账户，通过激活码，对user_main表的live字段进行修改操作。
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/activate")
	public String activate(HttpServletRequest request, HttpSession session) {
		userService.activate(request.getParameter("code"));
		session.setAttribute("activateMessage", "恭喜，你已经激活成功了！");
		return "html/success";
	}
	
	/**
	 * 到登陆页面。
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String toLogin(HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("name_placeholder", "输入：登陆名（昵称）");
		request.setAttribute("pwd_placeholder", "输入：登陆密码");
		request.setAttribute("verify_placeholder", "输入：验证码(4位)");
		return "login";
	}
	
	/**
	 * 登陆操作。
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/doLogin", method=RequestMethod.POST)
	public String doLogin(HttpSession session,HttpServletRequest request, 
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		// 获取生成的验证码
		String verifyCode = (String) session.getAttribute("session_verifyCode");
		// 获取表单数据。
		String name = EncodUtil.toUtf8(request.getParameter("name")).trim();
		String password = request.getParameter("password").trim();
		@SuppressWarnings("unused")
		String type = request.getParameter("type");
		String verify = request.getParameter("verify");

		if(verify.equalsIgnoreCase(verifyCode)) {
			
			// 数据库中信息
			String pwd = registerService.login(name);
			password = CommonsUtil.SHA256(password);
			if(pwd == null) {
				request.setAttribute("name_placeholder", "该用户名不存在~");
			} else {// 验证通过
				if(password.equals(pwd)) {
					session.removeAttribute("session_verifyCode");
					session.setAttribute("username", name);
					return "index";
				} else {
					request.setAttribute("pwd_placeholder", "用户密码错误~");
					return "login";
				}
			}
		} else {
			request.setAttribute("verify_placeholder", "验证码错误，请重试~");
			return "login";
		} 
		return "login";
	}
	
	
	/**
	 * 注销用户信息。
	 * @param session 从该参数中删除属性{@code username}
	 * @return 返回主页{@code index.jsp}
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "index";
	}

	/**
	 * 查询用户信息详情，返回到用户的详情页面上。
	 * 注意事项：这里的map，是从数据库接收的，其键是大写的。
	 * 当前用户若已经是作者了，在标题中显示有“作者专栏”，当点击后可以跳走到作者的详情页。
	 * @param session 获得用户的昵称；保存用户的详细信息。
	 * @return 详情页
	 */
	@RequestMapping("/usermain")
	public String personalPage(HttpSession session) {
		String username = (String) session.getAttribute("username");
		Map<String ,Object> map = userService.selectUserDetail(username);
		session.setAttribute("detailMap", map);
		Map<String, Object> authorMap = authorService.selectAuthor(map.get("user_main_id").toString());
		session.setAttribute("authorMap", authorMap);
		return "personal";
	}
	
	/**
	 * 更新用户昵称。
	 * 此处，需要注意，用户的信息是经过严格把控的。需要验证重复与否(现在未实现)，和设置Session属性。
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/updateName")
	public String updateName(HttpServletRequest request, HttpSession session) {
		EncodUtil.requestEncod(request);
		String name = request.getParameter("name");
		String user_register_id = request.getParameter("user_main_id");
		
		// TODO 验证名字是否已经存在
		// 更改并保存信息
		Map<String, String> map = new HashMap<String, String>(2);
		map.put("name", name);
		map.put("user_register_id", user_register_id);
		userService.updateName(map);
		session.setAttribute("username", name);
		return "index";
	}
	
	/**
	 * 更新个人描述。
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateInfo")
	public String updateInfo(HttpServletRequest request) {
		EncodUtil.requestEncod(request);
		String info = request.getParameter("info");
		String user_register_id = request.getParameter("user_main_id");
		
		Map<String, String> map = new HashMap<String, String>(2);
		map.put("info", info);
		map.put("user_register_id", user_register_id);
		userService.updateInfo(map);
		return "index";
	}
	
	/**
	 * 修改故乡。
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateCity")
	public String updateCity(HttpServletRequest request) {
		EncodUtil.requestEncod(request);
		String city = request.getParameter("city");
		String province = request.getParameter("province");
		String user_main_id = request.getParameter("user_main_id");
		
		System.out.println(city);
		System.out.println(province);
		System.out.println(user_main_id);
		
		Map<String, String> map = new HashMap<String, String>(2);
		map.put("city", province + " " + city);
		map.put("user_main_id", user_main_id);
		userService.updateCity(map);
		return "index";
	}
	
	@RequestMapping("/updateMoney")
	public String updateMoney(HttpServletRequest request) {
		String money = request.getParameter("money");
		String user_main_id = request.getParameter("user_main_id");
		
		System.out.println(money);
		System.out.println(user_main_id);
		
		Map<String, String> map = new HashMap<String, String>(2);
		map.put("money", money);
		map.put("user_main_id", user_main_id);
		userService.updateMoney(map);
		return "index";
	}
	
	/**
	 * 判断该登陆用户是否已经激活。
	 * @param mainId
	 * @param request
	 * @return
	 */
	@RequestMapping("/isActivated")
	public String isActivated(@RequestParam("mainId")String mainId, 
			HttpServletRequest request) {

		Map<String, String> map = new HashMap<String, String>(1);
		map.put("user_main_id", mainId);
		int live = userService.isActivated(map);
		String code = userService.selectCode(map);
		request.setAttribute("id", mainId);
		request.setAttribute("code", code);
		request.setAttribute("live", live);
		request.setAttribute("mainId", mainId);
		return "toAuthor";
	}
	
	/**
	 * 成为作者，需要注册信息，增加教育经历。
	 * @param experience_id 主键，与用户id一致
	 * @param school 毕业学校
	 * @param subject 所学专业
	 * @param inschool 入学时间
	 * @param outschool 毕业时间
	 * @param educational 教育经历（专科，本科，博士等）
	 * @param name 笔名
	 * @return 注册成功后，返回到作者详情页面。可以做一些作者专有的操作。
	 */
	@RequestMapping("/doAuthor")
	public String doAuthor(@RequestParam("experience_id")String experience_id,
			@RequestParam("school")String school,
			@RequestParam("subject")String subject,
			@RequestParam("inschool")String inschool,
			@RequestParam("outschool")String outschool,
			@RequestParam("educational")String educational,
			@RequestParam("name")String name) {
		// 创建教育经历对象。
		Experience experience = new Experience(experience_id,
				outschool, subject, CommonsUtil.StringToDate(inschool),
				CommonsUtil.StringToDate(outschool), educational);
		// 创建作者对象。
		Author author = new Author(
				experience_id, new Date(), 0, name);
		// 添加数据到数据表中
		authorService.addAuthor(author);
		authorService.addExperience(experience);
		return "personal";
	}
	
	@RequestMapping("/authorDetail")
	public String authorDetail(@RequestParam("authorName")String authorName,
			HttpServletRequest request) {
		List<?> list = authorService.selectNovelByAuthor(authorName);
		request.setAttribute("novelList", list);
		return "authorDetail";
	}
	
	
}
