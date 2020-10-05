package com.learning.jpahibernateadvanced.entity.service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.jpahibernateadvanced.entity.Student;

@Repository
//moving to service class for better first level cahce handling
@Transactional
public interface StudentJPARepositoryV2 extends JpaRepository<Student, Integer>{
	
	public List<Student> findByName(String name);
}
