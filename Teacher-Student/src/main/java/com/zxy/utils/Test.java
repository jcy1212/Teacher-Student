package com.zxy.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;



public class Test {
	public static void main(String[] args) {
	    String host = "http://jisutqybmf.market.alicloudapi.com";
	    String path = "/weather/query";
	    String method = "GET";
	    String appcode = "f23819e71b4d4f31a435e20ee4118a9c";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("city", "安顺");
//	    querys.put("citycode", "citycode");
//	    querys.put("cityid", "cityid");
//	    querys.put("ip", "ip");
//	    querys.put("location", "location");


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
	    	String strResult = EntityUtils.toString(response.getEntity());
	    	System.out.println(strResult);
	    	//获取response的body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}
