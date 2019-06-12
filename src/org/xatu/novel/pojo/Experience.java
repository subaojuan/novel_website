package org.xatu.novel.pojo;

import java.util.Date;

/**
 * 个人教育经历
 * @author Feng
 * 2019年5月6日下午5:27:58
 */
public class Experience {

	private String experience_id;
	private String school;
	private String subject;
	private Date inschool;
	private Date outschool;
	private String educational;
	
	public Experience() {}

	public Experience(String experience_id, String school, String subject, Date inschool, Date outschool,
			String educational) {
		super();
		this.experience_id = experience_id;
		this.school = school;
		this.subject = subject;
		this.inschool = inschool;
		this.outschool = outschool;
		this.educational = educational;
	}

	public String getExperience_id() {
		return experience_id;
	}

	public void setExperience_id(String experience_id) {
		this.experience_id = experience_id;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getInschool() {
		return inschool;
	}

	public void setInschool(Date inschool) {
		this.inschool = inschool;
	}

	public Date getOutschool() {
		return outschool;
	}

	public void setOutschool(Date outschool) {
		this.outschool = outschool;
	}

	public String getEducational() {
		return educational;
	}

	public void setEducational(String educational) {
		this.educational = educational;
	}

	@Override
	public String toString() {
		return "Experience [experience_id=" + experience_id + ", school=" + school + ", subject=" + subject
				+ ", inschool=" + inschool + ", outschool=" + outschool + ", educational=" + educational + "]";
	}
	
}
