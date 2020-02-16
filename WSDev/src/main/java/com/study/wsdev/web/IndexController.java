package com.study.wsdev.web;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.wsdev.utils.ServiceUtils;
import com.study.wsdev.vo.Modules;

@Controller
public class IndexController {
	
	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> redisTemplate;
	
	@RequestMapping(value="/")
	public String root() {
		
		// 자동 증가 쿼리
		redisTemplate.increment("loginCount");
		
		// 그냥 쿼리
		redisTemplate.set("simpleValue", "sm");
		
		// 시간 지나면 없어지는 쿼리
		redisTemplate.set("timeoutValue", "tm", Duration.ofMinutes(1));
		
		Map<String,String> mp = new HashMap<>();
		
		mp.put("mapValue1", "mp1");
		mp.put("mapValue2", "mp2");
		mp.put("mapValue3", "mp3");
		
		redisTemplate.multiSet(mp);
		
		System.out.println(ServiceUtils.getUser());
		return Modules.APP.getPath("/index");
	}
}
