package com.zxy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxy.dao.TeachersMapper;
import com.zxy.domain.Teachers;

@Service
public class TeachersService {
	@Autowired
	private TeachersMapper mapper;

	public Teachers selectTeacherById(Integer id){
		return mapper.selectTeacherById(id);
	}
	public List<Teachers> selectAllTeachers(String str,String beginDate,String endDate) {
		Map<String, String> map = new HashMap<>();
		if (str == "") {
			str = null;
		}
		if (beginDate == "") {
			beginDate = null;
		}
		if (endDate == "") {
			endDate = null;
		}
		map.put("str", str);
		map.put("beginDate", beginDate);
		map.put("endDate", endDate);
		return mapper.selectAllTeachers(map);
	};
	
	public int selectCount(String str,String beginDate,String endDate){
		Map<String, String> map = new HashMap<>();
		if (str == "") {
			str = null;
		}
		if (beginDate == "") {
			beginDate = null;
		}
		if (endDate == "") {
			endDate = null;
		}
		map.put("str", str);
		map.put("beginDate", beginDate);
		map.put("endDate", endDate);
		return mapper.selectCount(map);
	}
	
	public int addTeacher(String name,String job,String salary){
		Teachers teachers= new Teachers();
		teachers.setTeacherName(name);
		teachers.setTeacherJob(job);
		teachers.setSalary(salary);
		
		return mapper.addTeacher(teachers);
	}
	
	public int deleteTeacherById(int id){
		return mapper.deleteTeacherById(id);
	}
	
	public int updateTeacher(Integer id,String teacherName,String teacherJob,Integer isExist,String comeDate,String outDate,String salary){
		Teachers teachers = new Teachers();
		teachers.setId(id);
		teachers.setTeacherName(teacherName);
		teachers.setTeacherJob(teacherJob);
		teachers.setIsExist(isExist);
		teachers.setComeDate(comeDate);
		teachers.setOutDate(outDate);
		teachers.setSalary(salary);
		return mapper.updateTeacher(teachers);
	}
}
