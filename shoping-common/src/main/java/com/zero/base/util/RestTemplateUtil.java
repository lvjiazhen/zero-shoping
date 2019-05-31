package com.zero.base.util;

import java.util.Map;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUtil {

	
	public static Object doget(String url ,Class<?> responseType ,Map<String,Object> paramMap){
		RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		template.getForObject(url, responseType, paramMap);
		
		return template.getForObject(url, responseType, paramMap);
		
	}
	
}
