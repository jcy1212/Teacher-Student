package com.zxy.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zxy.utils.HttpUtil;

@Service
public class TotalService {
	public String getAnswer(String question) {
		String host = "http://jisuznwd.market.alicloudapi.com";
	    String path = "/iqa/query";
	    String method = "GET";
	    String appcode = "f23819e71b4d4f31a435e20ee4118a9c";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("question", question);
	    String content=null;

	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtil.doGet(host, path, method, headers, querys);
	    	String result=EntityUtils.toString(response.getEntity());
	    	JSONObject json=JSON.parseObject(result);
	    	
	    	Map<String, String> resultMap=null;
	    	for (Map.Entry<String, Object> entry : json.entrySet()) {
	    		 if ("result".equals(entry.getKey())) {
					resultMap=(Map<String, String>) entry.getValue();
					break;
				}
			}
	    	content=resultMap.get("content");
	    	//获取response的body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return content;
	    
	}
}
