package com.zxy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxy.dao.SchoolNewsMapper;
import com.zxy.domain.SchoolNews;

@Service
public class SchoolNewsService {

	@Resource
	private SchoolNewsMapper schoolNewsMapper;
	
	public List<SchoolNews> selectAllShengbao(String str,String beginDate,String endDate){
		if (str=="") {
			str = null;
		}
		if (beginDate == "") {
			beginDate =null;
		}
		if (endDate =="") {
			endDate=null;
		}
		Map<String, String> map = new HashMap<>();
		map.put("str", str);
		map.put("beginDate", beginDate);
		map.put("endDate", endDate);
		return schoolNewsMapper.selectAllNews(map);
	}
	
	public int selectCount(String str,String beginDate,String endDate) {
		if (str=="") {
			str = null;
		}
		if (beginDate == "") {
			beginDate =null;
		}
		if (endDate =="") {
			endDate=null;
		}
		Map<String, String> map = new HashMap<>();
		map.put("str", str);
		map.put("beginDate", beginDate);
		map.put("endDate", endDate);
		
		return schoolNewsMapper.selectCount(map);
	}
}
