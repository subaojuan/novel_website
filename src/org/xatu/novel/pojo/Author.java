package org.xatu.novel.pojo;

import java.util.Date;
/**
 * 作者实体类。继承了用户类，表示逻辑关系必须先成为注册用户，才能当作者。
 * @author Feng
 * 2019年4月10日下午4:01:41
 */
public class Author extends User {
	// 作者id
	private String author_id;
	// 成为作者的日期
	private Date create_date;
	// 作品的数目
	private Integer novel_count;
	// 作者笔名
	private String name;
	
	public Author() {}

	
	public Author(String author_id, Date create_date, Integer novel_count, String name) {
		super();
		this.author_id = author_id;
		this.create_date = create_date;
		this.novel_count = novel_count;
		this.name = name;
	}


	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Integer getNovel_count() {
		return novel_count;
	}

	public void setNovel_count(Integer novel_count) {
		this.novel_count = novel_count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", create_date=" + create_date + ", novel_count=" + novel_count
				+ ", name=" + name + "]";
	} 
}
