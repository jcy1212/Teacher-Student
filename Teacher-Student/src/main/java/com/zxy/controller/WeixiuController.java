package com.zxy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zxy.domain.Weixiu;
import com.zxy.service.WeixiuService;

@Controller
@RequestMapping(value="/weixiu")
public class WeixiuController {
	
	@Autowired
	private WeixiuService weixiuService;

	public static final Logger logger = LoggerFactory.getLogger(WeixiuController.class);
	
	@RequestMapping("/wxList")
	public ModelAndView baoxiuList(String str,String beginDate,String endDate) {
		ModelAndView modelAndView= new ModelAndView("weixiu-list");
		List<Weixiu> bxList=weixiuService.selectAllWeixiu(str, beginDate, endDate);
		int count=weixiuService.selectCount(str, beginDate, endDate);
		modelAndView.addObject("bxList", bxList);
		modelAndView.addObject("num", count);
		modelAndView.addObject("str", str);
		modelAndView.addObject("beginDate", beginDate);
		modelAndView.addObject("endDate", endDate);
		
		return modelAndView;
	}
}
