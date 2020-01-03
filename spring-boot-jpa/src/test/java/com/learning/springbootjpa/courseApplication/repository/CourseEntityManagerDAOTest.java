package com.learning.springbootjpa.courseApplication.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.springbootjpa.jpaBasicStyle.bean.Footballer;
import com.learning.springbootjpa.SpringBootJpaApplication;
import com.learning.springbootjpa.courseApplication.entity.Course;
import com.learning.springbootjpa.jpaBasicStyle.FootballerJPABasicDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootJpaApplication.class)
public class CourseEntityManagerDAOTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseEntityManagerDAO repo;
	
	@Test
	public void createCourse() {
		
		logger.info("starting create tests for DB");
		Course course1 = new Course("Spring Boot ");
		Course createdCourse = repo.createOrUpdate(course1);
		assertEquals(createdCourse.getCourseName(), course1.getCourseName());
	}
	
	@Test
	//roll back after function test
	@DirtiesContext
	public void testDelete() {
		
		logger.info("starting delete tests for DB");
		
		repo.deleteCourseById(1);
		assertNull("course should have beedn deleted with id "+1, repo.findCourseById(1));
	}
	
	
	


}
