package com.learning.jpahibernateadvanced.entity.service.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseJPARepositoryV1Test {

	@Autowired
	private CourseJPARepositoryV1 repo;
	
	@Test
	//any modification in data is rolled back after method completes
	@DirtiesContext
	public void playWithCoursesTest() {
		repo.playWithEntitntyManager();
	}
}
