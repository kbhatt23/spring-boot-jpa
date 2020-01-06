package com.learning.springbootjpa.courseApplication.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Cacheable
public class CacheEntity {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String description;

	public CacheEntity(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public CacheEntity() {
		
	}

	@Override
	public String toString() {
		return "CacheEntity [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
