package com.learning.jpahibernateadvanced.entity.service.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.jpahibernateadvanced.entity.service.business.StudentService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentServiceTest {

	@Autowired
	private StudentService service;
	
	@Test
	public void testFirstLevelCache() {
		service.findStudentByIdTwice();
	}
}
