package com.zxy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxy.dao.RwJinduMapper;
import com.zxy.domain.Renwu;
import com.zxy.domain.RwJindu;

@Service
public class RwJinduService {
	
	@Autowired
	RwJinduMapper rwJinduMapper;

	public RwJindu  selectJdById(Integer id){
		return rwJinduMapper.selectJdById(id);
	}
	
	public List<RwJindu> selectAllRenwu(String str,String beginDate,String endDate){
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
		return rwJinduMapper.selectAllRwJindu(map);
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
		
		return rwJinduMapper.selectCount(map);
	}
	
	public int updateJindu(Integer id,String jindu){
		RwJindu rwJindu = new RwJindu();
		rwJindu.setId(id);
		rwJindu.setJindu(jindu);
		return rwJinduMapper.updateRwJindu(rwJindu);
	}
	
}
