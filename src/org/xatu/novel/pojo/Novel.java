package org.xatu.novel.pojo;

import java.util.Date;

/**
 * 小说实体类。
 * @author Feng
 * 2019年4月15日下午2:41:57
 */
public class Novel {

	// 小说编号
	private String novel_id;
	// 类型编号
	private Integer type_id;
	// 作者id
	private String author_id;
	// 小说名字
	private String name;
	// 小说发布时间
	private Date birthday;
	// 内容简介
	private String info;
	// 图片
	private String img;
	// 出版社
	private String publish;
	// 已经更新的章节数目
	private Integer units;
	// 最后一次修改时间
	private Date last_modified_date;
	
	public Novel() {}
	
	public Novel(String novel_id, Integer type_id, String author_id, String name, Date birthday, String info,
			String img, String publish, Integer units, Date last_modified_date) {
		super();
		this.novel_id = novel_id;
		this.type_id = type_id;
		this.author_id = author_id;
		this.name = name;
		this.birthday = birthday;
		this.info = info;
		this.img = img;
		this.publish = publish;
		this.units = units;
		this.last_modified_date = last_modified_date;
	}

	public String getNovel_id() {
		return novel_id;
	}

	public void setNovel_id(String novel_id) {
		this.novel_id = novel_id;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public Date getLast_modified_date() {
		return last_modified_date;
	}

	public void setLast_modified_date(Date last_modified_date) {
		this.last_modified_date = last_modified_date;
	}

	@Override
	public String toString() {
		return "Novel [novel_id=" + novel_id + ", type_id=" + type_id + ", author_id=" + author_id + ", name=" + name
				+ ", birthday=" + birthday + ", info=" + info + ", img=" + img + ", publish=" + publish + ", units="
				+ units + ", last_modified_date=" + last_modified_date + "]";
	}
	
	
}
