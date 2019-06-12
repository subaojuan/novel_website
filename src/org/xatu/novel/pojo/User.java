package org.xatu.novel.pojo;

import java.util.Date;

/**
 * 用户类。
 * @author Feng
 * 2019年1月21日下午2:30:43
 */
public class User {

	// 用户生日
	private Date birthday;
	// 验证码
	private String code;
	// 宝儿用书券
	private Double money;
	// 用户的id
	private String id;
	// 用户头像
	private String display;
	// 用户故乡
	private String city;
	// 最近在看
	private String book;
	// 职业
	private String job;
	// 注册日期
	private Date register_date;
	// 最后修改时间
	private Date last_modified_date;
	// 是否激活 默认为未激活(0)，1表示激活
	private Integer live;
	// 学历编号
	private String experience_id;
	
	public User() {}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public Date getLast_modified_date() {
		return last_modified_date;
	}
	public void setLast_modified_date(Date last_modified_date) {
		this.last_modified_date = last_modified_date;
	}
	public Integer getLive() {
		return live;
	}
	public void setLive(Integer live) {
		this.live = live;
	}
	public String getExperience_id() {
		return experience_id;
	}
	public void setExperience_id(String experience_id) {
		this.experience_id = experience_id;
	}
	@Override
	public String toString() {
		return "User [birthday=" + birthday + ", code=" + code + ", money=" + money + ", id=" + id + ", display="
				+ display + ", city=" + city + ", book=" + book + ", job=" + job + ", register_date=" + register_date
				+ ", last_modified_date=" + last_modified_date + ", live=" + live + ", experience_id=" + experience_id
				+ "]";
	}
	
	
}
