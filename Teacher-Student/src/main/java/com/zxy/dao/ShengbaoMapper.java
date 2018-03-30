package com.zxy.dao;

import java.util.List;
import java.util.Map;

import com.zxy.domain.Shengbao;

public interface ShengbaoMapper {
	
	int addShengbao(Shengbao shengbao);
	
	List<Shengbao> selectAllShengbao(Map<String, String> map);
	 
	Shengbao selectShengbaoById(Integer id);
	
	int selectCount(Map<String, String> map);
}
