package com.zxy.dao;

import java.util.List;
import java.util.Map;

import com.zxy.domain.Renwu;
import com.zxy.domain.Zhiban;

public interface RenwuMapper {
	
	//查询全部去新闻
		List<Renwu> selectAllRenwu(Map<String, String> map);
		
		int selectCount(Map<String, String> map);
		
		int updateRenwu(Renwu renwu);
		
		Renwu selectZbById(Integer id);
		
		Renwu selectRenwuById(Integer id);
}
