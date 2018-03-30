package com.zxy.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.zxy.domain.Students;
import com.zxy.domain.Teachers;
import com.zxy.service.StudentsService;
import com.zxy.service.TeachersService;

@Controller
@RequestMapping(value="/students")
public class StudentsController {
	
	public static final Logger logger = LoggerFactory.getLogger(StudentsController.class);
	@Autowired
	StudentsService studentsService;
	@Autowired
	TeachersService teachersService;
	/**
	 * 全部查询
	 * @param str
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping("/studentList")
	public ModelAndView studentList(String str,String beginDate,String endDate) {
		ModelAndView modelAndView= new ModelAndView("student-list");
		List<Students> studentList=studentsService.selectAllStudent(str, beginDate, endDate);
		int count=studentsService.selectCount(str, beginDate, endDate);
		modelAndView.addObject("studentList", studentList);
		modelAndView.addObject("num", count);
		modelAndView.addObject("str", str);
		modelAndView.addObject("beginDate", beginDate);
		modelAndView.addObject("endDate", endDate);
		
		return modelAndView;
	}
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:studentList";
	}
	/**
	 * 删除学生
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delStudent")
	@ResponseBody
	public String delStudent(int id) {
		JSONObject j = new JSONObject();

		try {
			int num = studentsService.deleteStudentById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("TeachersController delTeacher error" + e.getMessage());
			j.put("msg", "error");
			return j.toString();
		}
		j.put("msg", "删除成功");
		return j.toString();
	}
	/**
	 * 修改学生
	 * @param studentName
	 * @param grade
	 * @param teacherId
	 * @param id
	 * @param outDate
	 * @param comeDate
	 * @param isExist
	 * @return
	 */
	@RequestMapping("/updateStudent")
	public ModelAndView updateTeacher(String studentName,String grade,String teacherId,Integer id,Integer isExist,String teacherName) {
		Students students= null;
		
		if (StringUtils.isEmpty(studentName) && StringUtils.isEmpty(grade)) {
			ModelAndView modelAndView = new ModelAndView("member-student-update");
			students= studentsService.selectStudentById(id);
			modelAndView.addObject("student", students);
			return modelAndView;
		}
		try {
			int num = studentsService.updateStudent(studentName, grade, teacherId, id, isExist, teacherName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("StudentsController updateTeacher error" + e.getMessage());
		}

		return new ModelAndView();
	}
	
	/**
	 * 添加学生
	 * @param name
	 * @param grade
	 * @param teacherId
	 * @return
	 */
	@RequestMapping("/addStudent")
	public String doAddStudent(String name,String grade,String teacherName){
		if(StringUtils.isEmpty(name) && StringUtils.isEmpty(grade) && StringUtils.isEmpty(teacherName)){
			return "member-student-add";
		}else{
			try {
				int num = studentsService.addStudent(name, grade, teacherName);
			} catch (Exception e) {
				logger.error("StudentController addStudents error" + e.getMessage());
				return "error";
			}
			return "success";
		}
		
	}
}
