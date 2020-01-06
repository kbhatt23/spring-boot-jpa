package com.learning.springbootjpa.courseApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.learning.springbootjpa.courseApplication.entity.CacheEntity;

@RepositoryRestResource(path = "cacheEntities")
public interface CacheEntityRepository extends JpaRepository<CacheEntity, Integer>{

}
