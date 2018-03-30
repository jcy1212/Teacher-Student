package com.zxy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxy.dao.RenwuMapper;
import com.zxy.domain.Renwu;
import com.zxy.domain.Zhiban;

@Service
public class RenwuService {

	@Resource
	private RenwuMapper renwuMapper;
	
	public Renwu selectRenwuById(Integer id){
		return renwuMapper.selectRenwuById(id);
	}
	
	public List<Renwu> selectAllRenwu(String str,String beginDate,String endDate){
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
		return renwuMapper.selectAllRenwu(map);
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
		
		return renwuMapper.selectCount(map);
	}
	
	public int updateRenwu(Integer id,String studentName){
		Renwu remnwu = new Renwu();
		remnwu.setId(id);
		remnwu.setStudentName(studentName);
		return renwuMapper.updateRenwu(remnwu);
	}
	
}
