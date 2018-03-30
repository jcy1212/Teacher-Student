package com.zxy.dao;

import java.util.List;
import java.util.Map;

import com.zxy.domain.Renwu;
import com.zxy.domain.RwJindu;

public interface RwJinduMapper {
	
	
	List<RwJindu> selectAllRwJindu(Map<String, String> map);
	
	int selectCount(Map<String, String> map);
	
	int updateRwJindu(RwJindu rwJindu);
	
	RwJindu selectJdById(Integer id);
	
}
