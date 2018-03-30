package com.zxy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxy.dao.ShengbaoMapper;
import com.zxy.domain.Shengbao;
import com.zxy.domain.Students;

@Service
public class ShengbaoService {
	
	@Autowired
	private ShengbaoMapper shengbaoMapper;
	
	public List<Shengbao> selectAllShengbao(String str,String beginDate,String endDate){
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
		return shengbaoMapper.selectAllShengbao(map);
	}
	
	public int addShengbao(String studentName,String sbName,String info) {
		Shengbao shengbao= new Shengbao();
		shengbao.setInfo(info);
		shengbao.setSbName(sbName);
		shengbao.setStudentName(studentName);
		shengbao.setStudentId(1);
		return shengbaoMapper.addShengbao(shengbao);
	}

}
