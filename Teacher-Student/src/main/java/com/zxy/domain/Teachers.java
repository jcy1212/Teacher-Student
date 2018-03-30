package com.zxy.domain;

public class Teachers {
	private Integer id;
	private String teacherName;
	private String  teacherJob;
	private Integer isExist;
	private String comeDate;
	private String outDate;
	private String salary;
	

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherJob() {
		return teacherJob;
	}

	public void setTeacherJob(String teacherJob) {
		this.teacherJob = teacherJob;
	}

	public Integer getIsExist() {
		return isExist;
	}

	public void setIsExist(Integer isExist) {
		this.isExist = isExist;
	}

	public String getComeDate() {
		return comeDate;
	}

	public void setComeDate(String comeDate) {
		this.comeDate = comeDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

}
