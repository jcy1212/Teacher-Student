package com.zxy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxy.dao.SchoolNewsMapper;
import com.zxy.dao.ZhibanMapper;
import com.zxy.domain.SchoolNews;
import com.zxy.domain.Teachers;
import com.zxy.domain.Zhiban;

@Service
public class ZhibanService {

	@Resource
	private ZhibanMapper zhibanMapper;
	
	
	public Zhiban selectZbById(Integer id){
		return zhibanMapper.selectZbById(id);
	}
	
	public List<Zhiban> selectAllShengbao(String str,String beginDate,String endDate){
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
		return zhibanMapper.selectAllZhiban(map);
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
		
		return zhibanMapper.selectCount(map);
	}
	
	public int updateZb(Integer id,String zbName){
		Zhiban zhiban = new Zhiban();
		zhiban.setId(id);
		zhiban.setZbName(zbName);
		return zhibanMapper.updateZb(zhiban);
	}
}
