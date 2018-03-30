package com.zxy.domain;


public class SchoolWork {
	private Integer id;
	private Integer studentId;
	private String workContent;
	private Integer workStatus;
	private Integer correctTeacher;
	private String createDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public Integer getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(Integer workStatus) {
		this.workStatus = workStatus;
	}

	public Integer getCorrectTeacher() {
		return correctTeacher;
	}

	public void setCorrectTeacher(Integer correctTeacher) {
		this.correctTeacher = correctTeacher;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
