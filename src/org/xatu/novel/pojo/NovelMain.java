package org.xatu.novel.pojo;

import java.util.Date;

/**
 * 小说内容表
 * @author Feng
 * 2019年4月15日下午2:54:14
 */
public class NovelMain {

	// 小说编号
	private String novel_id;
	// 章节编号
	private Integer unit;
	// 该章节的内容(正文)
	private String content;
	// 该章节访问次数
	private Integer count;
	// 该章节更新时间
	private Date update_date;
	// 该章节创建时间
	private Date created_date;
	
	public NovelMain() {}

	public String getNovel_id() {
		return novel_id;
	}

	public void setNovel_id(String novel_id) {
		this.novel_id = novel_id;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "NovelMain [novel_id=" + novel_id + ", unit=" + unit + ", content=" + content + ", count=" + count
				+ ", update_date=" + update_date + ", created_date=" + created_date + "]";
	}
	
	
}
