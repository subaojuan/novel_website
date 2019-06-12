package org.xatu.novel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xatu.novel.mapper.RegisterFormMapper;
import org.xatu.novel.pojo.RegisterForm;
import org.xatu.novel.util.CommonsUtil;
import org.xatu.novel.util.EncodUtil;
@Service
public class RegisterFormServiceImpl implements RegisterFormService {

	@Autowired
	private RegisterFormMapper mapper;
	
	@Override
	public int addRegisterForm(RegisterForm form) {
		String info = form.getInfo();
		String name = form.getName();

		// 处理编码问题，此处会出现中文乱码。修改对象信息
		if("没写什么呢…".equals(info)) {
			form.setInfo(info);
		} else {
			form.setInfo(EncodUtil.toUtf8(info));
		}
			
		if(null != name)
			form.setName(EncodUtil.toUtf8(name));
		
		form.setId(CommonsUtil.getUUID());// 主键
		// 密码加密存储
		form.setPassword(CommonsUtil.SHA256(form.getPassword()));
		return mapper.addForm(form);
	}

	@Override
	public String login(String name) {
		return mapper.login(name);
	}
	


}
