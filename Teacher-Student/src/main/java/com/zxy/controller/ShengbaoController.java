package com.zxy.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zxy.domain.Shengbao;
import com.zxy.service.ShengbaoService;
import com.zxy.service.StudentsService;
import com.zxy.service.TeachersService;


@Controller
@RequestMapping(value="/shengbao")
public class ShengbaoController {
	
	public static final Logger logger = LoggerFactory.getLogger(ShengbaoController.class);
	@Autowired
	StudentsService studentsService;
	@Autowired
	TeachersService teachersService;
	@Autowired
	ShengbaoService shengbaoService;
	
	@RequestMapping("/shengbaoList")
	public ModelAndView shengbaoList(String str,String beginDate,String endDate) {
		ModelAndView modelAndView= new ModelAndView("shengbao-list");
		List<Shengbao> shengbaoList=shengbaoService.selectAllShengbao(str, beginDate, endDate);
		int count=studentsService.selectCount(str, beginDate, endDate);
		modelAndView.addObject("shengbaoList", shengbaoList);
		modelAndView.addObject("num", count);
		modelAndView.addObject("str", str);
		modelAndView.addObject("beginDate", beginDate);
		modelAndView.addObject("endDate", endDate);
		
		return modelAndView;
	}
	
	@RequestMapping("/addShengbao")
	public String doAddShengbao(String studentName,String sbName, String info) {
		if (StringUtils.isEmpty(sbName) && StringUtils.isEmpty(info)) {
			return "member-addShengbao";
		} else {
			try {
				int num = shengbaoService.addShengbao(studentName,sbName, info);
			} catch (Exception e) {
				// TODO Auto-generated catch block

				logger.error("ShengbaoController addShengbao error" + e.getMessage());
				return "error";
			}
			return "success";
		}
	}

}
