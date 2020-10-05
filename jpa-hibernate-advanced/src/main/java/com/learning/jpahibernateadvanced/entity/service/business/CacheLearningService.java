package com.learning.jpahibernateadvanced.entity.service.business;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheLearningService {

	private static final Map<Integer, String> cacheMessageMap ;
	
	static {
		cacheMessageMap = new HashMap<Integer, String>();
		cacheMessageMap.put(1, "one");
		cacheMessageMap.put(2, "two");
		cacheMessageMap.put(3, "three");
		cacheMessageMap.put(4, "four");
	}
	
	@Cacheable("strCache")
	public String findMessage(int index) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cacheMessageMap.get(index);
	}
	
}
