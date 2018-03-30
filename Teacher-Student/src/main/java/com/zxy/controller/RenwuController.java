package com.zxy.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zxy.domain.Renwu;
import com.zxy.domain.Zhiban;
import com.zxy.service.RenwuService;

@Controller
@RequestMapping(value="/renwu")
public class RenwuController {
	@Autowired
	RenwuService renwuService;
	
	public static final Logger logger = LoggerFactory.getLogger(ShengbaoController.class);

	@RequestMapping("/rwList")
	public ModelAndView shengbaoList(String str,String beginDate,String endDate) {
		ModelAndView modelAndView= new ModelAndView("rw-list");
		List<Renwu> rwList=renwuService.selectAllRenwu(str, beginDate, endDate);
		int count=renwuService.selectCount(str, beginDate, endDate);
		modelAndView.addObject("rwList", rwList);
		modelAndView.addObject("num", count);
		modelAndView.addObject("str", str);
		modelAndView.addObject("beginDate", beginDate);
		modelAndView.addObject("endDate", endDate);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "updateRenwu")
	public ModelAndView updateTeacher(Integer id, String studentName) {
		Renwu renwu= null;
		
		if (StringUtils.isEmpty(studentName)) {
			ModelAndView modelAndView = new ModelAndView("renwu-update");
			renwu= renwuService.selectRenwuById(id);
			modelAndView.addObject("renwu", renwu);
			return modelAndView;
		}
		try {
			int num = renwuService.updateRenwu(id, studentName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("ZhibanController updateZb error" + e.getMessage());
		}

		return new ModelAndView();
	}

}
