package com.zxy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxy.dao.WeixiuMapper;
import com.zxy.domain.Weixiu;
import com.zxy.domain.Renwu;

@Service
public class WeixiuService {
	
	@Autowired
	private WeixiuMapper weixiuMapper;

	public List<Weixiu> selectAllWeixiu(String str,String beginDate,String endDate){
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
		return weixiuMapper.selectAllWeixiu(map);
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
		
		return weixiuMapper.selectCount(map);
	}
}
