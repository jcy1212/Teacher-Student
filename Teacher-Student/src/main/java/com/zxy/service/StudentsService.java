package com.zxy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxy.dao.StudentsMapper;
import com.zxy.domain.Students;

@Service
public class StudentsService {

	@Autowired
	private StudentsMapper mapper;
	
	public List<Students> selectAllStudent(String str,String beginDate,String endDate){
		if (str=="") {
			str = null;
		}
		if (beginDate == "") {
			beginDate =null;
		}
		if (endDate =="") {
			endDate=null;
		}
		Map<String, String> map = new HashMap<>();
		map.put("str", str);
		map.put("beginDate", beginDate);
		map.put("endDate", endDate);
		return mapper.selectAllStudent(map);
	}
	
	public Students selectStudentById(Integer id) {
		return mapper.selectStudentById(id);
	}
	
	public int selectCount(String str,String beginDate,String endDate) {
		if (str=="") {
			str = null;
		}
		if (beginDate == "") {
			beginDate =null;
		}
		if (endDate =="") {
			endDate=null;
		}
		Map<String, String> map = new HashMap<>();
		map.put("str", str);
		map.put("beginDate", beginDate);
		map.put("endDate", endDate);
		
		return mapper.selectCount(map);
	}
	
	public int addStudent(String name,String grade,String teacherName) {
		Students students= new Students();
		students.setStudentName(name);
		students.setTeacherName(teacherName);
		students.setGrade(grade);
		students.setTeacherId("1");
		return mapper.addNewStudent(students);
	}
	
	public int updateStudent(String name,String grade,String teacherId,Integer id,Integer isExist,String teacherName) {
		Students students= new Students();
		students.setId(id);
		students.setStudentName(name);
		students.setGrade(grade);
		students.setTeacherId(teacherId);
		students.setTeacherName(teacherName);
		students.setIsExist(isExist);
		
		return mapper.updateStudent(students);
	}
	
	public int deleteStudentById(int id){
		return mapper.deleteStudentById(id);
	}
	
}
