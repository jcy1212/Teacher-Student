package com.zxy.domain;

import java.util.Date;

public class Shengbao {
	
	private Integer id;
	private String sbName;
	private Integer studentId;
	private String studentName;
	private String comeDate;
	private String info;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSbName() {
		return sbName;
	}
	public void setSbName(String sbName) {
		this.sbName = sbName;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getComeDate() {
		return comeDate;
	}
	public void setComeDate(String comeDate) {
		this.comeDate = comeDate;
	}
	
	

}
