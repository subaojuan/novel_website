package org.xatu.novel.pojo;

import java.util.Date;
/**
 * 小说类型(表)的实体类。
 * @author Feng
 * 2019年1月17日下午5:14:50
 */
public class NovelType {

	private Integer type_id;// 类型编号
	private String type_name;// 类型名
	private Date create_date;// 创建日期
	private Date last_modified_date;// 最后修改时间
	
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getLast_modified_date() {
		return last_modified_date;
	}
	public void setLast_modified_date(Date last_modified_date) {
		this.last_modified_date = last_modified_date;
	}
	@Override
	public String toString() {
		return "NovelType [type_id=" + type_id + ", type_name=" + type_name + ", create_date=" + create_date
				+ ", last_modified_date=" + last_modified_date + "]";
	}
	
}
