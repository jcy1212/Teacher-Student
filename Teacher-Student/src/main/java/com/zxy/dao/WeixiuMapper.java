package com.zxy.dao;

import java.util.List;
import java.util.Map;

import com.zxy.domain.Weixiu;


public interface WeixiuMapper {
	
	//查询全部去新闻
			List<Weixiu> selectAllWeixiu(Map<String, String> map);
			
			int selectCount(Map<String, String> map);
			
			int updateBaoxiuu(Weixiu weixiu);
			
			Weixiu selectBaoxiuById(Integer id);
			
			

}
