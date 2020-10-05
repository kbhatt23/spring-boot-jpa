package com.learning.jpahibernateadvanced.entity.service.business;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//added to demonstarate first level cahce
//since first level cache works only within same transaction we must keep 
//@transactional in serivce layer increasing the chance for same query within same transaction

import com.learning.jpahibernateadvanced.entity.Student;
import com.learning.jpahibernateadvanced.entity.service.repository.StudentJPARepositoryV2;
@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentJPARepositoryV2 repo;
	
	
	public String findStudentByIdTwice() {
	
		String firstTimeName = repo.findById(20001).map(Student::getName).orElse(null);
		
		System.out.println("First time item fetched "+firstTimeName);
		
		String secondTimeName = repo.findById(20001).map(Student::getName).orElse(null);
		
		System.out.println("second time item fetched "+secondTimeName);
		return firstTimeName;
	}
}
