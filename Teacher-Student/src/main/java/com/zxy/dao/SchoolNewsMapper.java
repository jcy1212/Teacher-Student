package com.zxy.dao;

import java.util.List;
import java.util.Map;

import com.zxy.domain.SchoolNews;

public interface SchoolNewsMapper {
	
	//查询全部去新闻
	List<SchoolNews> selectAllNews(Map<String, String> map);
	
	int selectCount(Map<String, String> map);

}
