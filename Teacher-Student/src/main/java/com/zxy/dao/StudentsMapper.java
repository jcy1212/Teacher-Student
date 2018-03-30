package com.zxy.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zxy.domain.Students;

@Repository
public interface StudentsMapper {
	List<Students> selectAllStudent(Map<String, String> map);
	
	Students selectStudentById(Integer id);
	
	int selectCount(Map<String, String> map);
	
	int addNewStudent(Students students);
	
	int updateStudent(Students students);
	
	int deleteStudentById(int id);
}
