package com.zxy.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zxy.domain.Teachers;
import com.zxy.domain.Zhiban;
import com.zxy.service.ZhibanService;

@Controller
@RequestMapping(value="/zb")
public class ZhibanController {

	public static final Logger logger = LoggerFactory.getLogger(ShengbaoController.class);
	@Autowired
	ZhibanService zhibanService;
	
	@RequestMapping("/zbList")
	public ModelAndView shengbaoList(String str,String beginDate,String endDate) {
		ModelAndView modelAndView= new ModelAndView("zb-list");
		List<Zhiban> zbList=zhibanService.selectAllShengbao(str, beginDate, endDate);
		int count=zhibanService.selectCount(str, beginDate, endDate);
		modelAndView.addObject("zbList", zbList);
		modelAndView.addObject("num", count);
		modelAndView.addObject("str", str);
		modelAndView.addObject("beginDate", beginDate);
		modelAndView.addObject("endDate", endDate);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "updateZb")
	public ModelAndView updateTeacher(Integer id, String zbName) {
		Zhiban zhiban= null;
		
		if (StringUtils.isEmpty(zbName)) {
			ModelAndView modelAndView = new ModelAndView("zb-update");
			zhiban= zhibanService.selectZbById(id);
			modelAndView.addObject("zhiban", zhiban);
			return modelAndView;
		}
		try {
			int num = zhibanService.updateZb(id, zbName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("ZhibanController updateZb error" + e.getMessage());
		}

		return new ModelAndView();
	}
}
