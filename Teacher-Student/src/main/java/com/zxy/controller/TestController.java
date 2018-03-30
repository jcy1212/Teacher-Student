package com.zxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping(value="/")
	public ModelAndView index(){
		ModelAndView modelAndView= new ModelAndView("index");
		return modelAndView;
	}
	
	@RequestMapping(value="/welcome")
	public ModelAndView welcome(){
		ModelAndView modelAndView= new ModelAndView("welcome");
		return modelAndView;
	}
}
