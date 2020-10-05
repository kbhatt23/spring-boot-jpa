package com.learning.jpahibernateadvanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpahibernateadvanced.entity.Passport;
import com.learning.jpahibernateadvanced.entity.Student;
import com.learning.jpahibernateadvanced.entity.service.repository.StudentJPARepositoryV1;

@RestController
@RequestMapping("/students")
public class StudentsController {
	@Autowired
	private StudentJPARepositoryV1 repo;
	
	@GetMapping
	public Student findStudent() {
		Student student = repo.findStudentById(1);
		//Passport passport = student.getPassport();
		//System.out.println("paspport fetched for student is "+passport);
		return student;
	}
	
}
