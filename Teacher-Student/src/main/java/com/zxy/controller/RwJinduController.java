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
import com.zxy.domain.RwJindu;
import com.zxy.service.RwJinduService;

@Controller
@RequestMapping(value="/jindu")
public class RwJinduController {

	
	@Autowired
	RwJinduService rwJinduService;
	
	public static final Logger logger = LoggerFactory.getLogger(ShengbaoController.class);

	@RequestMapping("/jdList")
	public ModelAndView shengbaoList(String str,String beginDate,String endDate) {
		ModelAndView modelAndView= new ModelAndView("jd-list");
		List<RwJindu> jdList=rwJinduService.selectAllRenwu(str, beginDate, endDate);
		int count=rwJinduService.selectCount(str, beginDate, endDate);
		modelAndView.addObject("jdList", jdList);
		modelAndView.addObject("num", count);
		modelAndView.addObject("str", str);
		modelAndView.addObject("beginDate", beginDate);
		modelAndView.addObject("endDate", endDate);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "updateJindu")
	public ModelAndView updateJindu(Integer id, String jindu) {
		RwJindu rwJindu= null;
		
		if (StringUtils.isEmpty(jindu)) {
			ModelAndView modelAndView = new ModelAndView("jindu-update");
			rwJindu= rwJinduService.selectJdById(id);
			modelAndView.addObject("rwJindu", rwJindu);
			return modelAndView;
		}
		try {
			int num = rwJinduService.updateJindu(id, jindu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("ZhibanController updateZb error" + e.getMessage());
		}

		return new ModelAndView();
	}
}
