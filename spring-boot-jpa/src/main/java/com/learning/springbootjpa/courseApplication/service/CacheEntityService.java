package com.learning.springbootjpa.courseApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.learning.springbootjpa.courseApplication.entity.CacheEntity;
import com.learning.springbootjpa.courseApplication.repository.CacheEntityRepository;
import com.learning.springbootjpa.util.MultiThreadingUtil;

@Service
public class CacheEntityService {
	@Autowired
	private CacheEntityRepository repo;
	
	@Cacheable(cacheNames="cacheEntity")
	public List<CacheEntity> fetchALLCaheEntity(){
		MultiThreadingUtil.sleep(2000);
		return repo.findAll();
	}

}
