package org.xatu.novel.pojo;

/** 
 * 用户的部分信息，在注册页面中的那些信息
 * @author Feng
 * 2019年1月21日下午2:30:36
 */
public class RegisterForm {
	private String id;// 主键
	private String name;// 昵称
	private String email;// 邮箱
	private String password;// 密码
	private String telephone;// 电话
	private String info;// 个人描述
	private Integer like1;// 喜欢的书籍类型
	private Integer like2;
	private Integer like3;
	private Integer like4;
	private Integer like5;
	private Integer like6;
	private Integer like7;
	private Integer like8;
	private Integer like9;
	private Integer like10;
	private Integer like11;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return (null == telephone || "".equals(telephone.trim()))? "未添加" : telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getInfo() {
		return (null == info || "".equals(info.trim())) ? "没写什么呢…" : info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getLike1() {
		return like1 == null ? 0 : like1;
	}
	public void setLike1(Integer like1) {
		this.like1 = like1;
	}
	public Integer getLike2() {
		return like2 == null ? 0 : like2;
	}
	public void setLike2(Integer like2) {
		this.like2 = like2;
	}
	public Integer getLike3() {
		return like3 == null ? 0 : like3;
	}
	public void setLike3(Integer like3) {
		this.like3 = like3;
	}
	public Integer getLike4() {
		return like4 == null ? 0 : like4;
	}
	public void setLike4(Integer like4) {
		this.like4 = like4;
	}
	public Integer getLike5() {
		return like5 == null ? 0 : like5;
	}
	public void setLike5(Integer like5) {
		this.like5 = like5;
	}
	public Integer getLike6() {
		return like6 == null ? 0 : like6;
	}
	public void setLike6(Integer like6) {
		this.like6 = like6;
	}
	public Integer getLike7() {
		return like7 == null ? 0 : like7;
	}
	public void setLike7(Integer like7) {
		this.like7 = like7;
	}
	public Integer getLike8() {
		return like8 == null ? 0 : like8;
	}
	public void setLike8(Integer like8) {
		this.like8 = like8;
	}
	public Integer getLike9() {
		return like9 == null ? 0 : like9;
	}
	public void setLike9(Integer like9) {
		this.like9 = like9;
	}
	public Integer getLike10() {
		return like10 == null ? 0 : like10;
	}
	public void setLike10(Integer like10) {
		this.like10 = like10;
	}
	public Integer getLike11() {
		return like11 == null ? 0 : like11;
	}
	public void setLike11(Integer like11) {
		this.like11 = like11;
	}
	@Override
	public String toString() {
		return "RegisterForm [id=" + id + "name=" + name + ", email=" + email + ", password=" + password + ", telephone="
				+ telephone + ", like1=" + like1 + ", like2=" + like2 + ", like3=" + like3 + ", like4=" + like4
				+ ", like5=" + like5 + ", like6=" + like6 + ", like7=" + like7 + ", like8=" + like8 + ", like9="
				+ like9 + ", like10=" + like10 + ", like11=" + like11 + ", info=" + info + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
