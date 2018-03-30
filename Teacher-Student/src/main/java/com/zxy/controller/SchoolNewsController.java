package com.zxy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zxy.domain.SchoolNews;
import com.zxy.service.SchoolNewsService;
@Controller
@RequestMapping(value="/news")
public class SchoolNewsController {

	public static final Logger logger = LoggerFactory.getLogger(ShengbaoController.class);
	@Autowired
	SchoolNewsService schoolNewsService;
	
	@RequestMapping("/newsList")
	public ModelAndView shengbaoList(String str,String beginDate,String endDate) {
		ModelAndView modelAndView= new ModelAndView("news-list");
		List<SchoolNews> newsList=schoolNewsService.selectAllShengbao(str, beginDate, endDate);
		int count=schoolNewsService.selectCount(str, beginDate, endDate);
		modelAndView.addObject("newsList", newsList);
		modelAndView.addObject("num", count);
		modelAndView.addObject("str", str);
		modelAndView.addObject("beginDate", beginDate);
		modelAndView.addObject("endDate", endDate);
		
		return modelAndView;
	}
	
}
