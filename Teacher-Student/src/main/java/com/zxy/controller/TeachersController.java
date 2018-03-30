package com.zxy.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.zxy.domain.Teachers;
import com.zxy.service.TeachersService;

@Controller
@RequestMapping(value = "/teachers")
public class TeachersController {
	public static final Logger logger = LoggerFactory.getLogger(TeachersController.class);
	@Autowired
	private TeachersService service;

	@RequestMapping("/teacherList")
	public ModelAndView teacherList(String str,String beginDate,String endDate) {
		ModelAndView modelAndView = new ModelAndView("teacher-list");
		List<Teachers> list = service.selectAllTeachers(str,beginDate,endDate);
		modelAndView.addObject("teacherList", list);
		int count = service.selectCount(str,beginDate,endDate);
		modelAndView.addObject("num", count);
		
		modelAndView.addObject("str", str);
		modelAndView.addObject("beginDate", beginDate);
		modelAndView.addObject("endDate",endDate);
		return modelAndView;
	}

	@RequestMapping(value = "/addTeacher")
	public String doAddTeacher(String name, String job,String salary) {
		if (StringUtils.isEmpty(name) && StringUtils.isEmpty(job) && StringUtils.isEmpty(salary)) {
			return "member-add";
		} else {
			try {
				int num = service.addTeacher(name, job,salary);
			} catch (Exception e) {
				// TODO Auto-generated catch block

				logger.error("TeachersController addTeacher error" + e.getMessage());
				return "error";
			}
			return "success";
		}
	}

	@RequestMapping(value = "/delTeacher")
	@ResponseBody
	public String delTeacher(int id) {
		JSONObject j = new JSONObject();

		try {
			int num = service.deleteTeacherById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("TeachersController delTeacher error" + e.getMessage());
			j.put("msg", "error");
			return j.toString();
		}
		j.put("msg", "删除成功");
		return j.toString();
	}

	@RequestMapping(value = "updateTeacher")
	public ModelAndView updateTeacher(Integer id, String teacherName, String teacherJob, Integer isExist, String comeDate,
			String outDate,String salary) {
		Teachers teachers= null;
		
		if (StringUtils.isEmpty(teacherName) && StringUtils.isEmpty(teacherJob) && StringUtils.isEmpty(comeDate)
				&& StringUtils.isEmpty(outDate)) {
			ModelAndView modelAndView = new ModelAndView("member-update");
			teachers= service.selectTeacherById(id);
			modelAndView.addObject("teacher", teachers);
			return modelAndView;
		}
		try {
			int num = service.updateTeacher(id, teacherName, teacherJob, isExist, comeDate, outDate,salary);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("TeachersController updateTeacher error" + e.getMessage());
		}

		return new ModelAndView();
	}
}
