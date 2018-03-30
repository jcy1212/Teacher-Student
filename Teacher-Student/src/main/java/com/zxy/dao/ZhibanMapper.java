package com.zxy.dao;

import java.util.List;
import java.util.Map;

import com.zxy.domain.Teachers;
import com.zxy.domain.Zhiban;

public interface ZhibanMapper {

	//查询全部去新闻
	List<Zhiban> selectAllZhiban(Map<String, String> map);
	
	int selectCount(Map<String, String> map);
	
	int updateZb(Zhiban zhiban);
	
	Zhiban selectZbById(Integer id);
}
