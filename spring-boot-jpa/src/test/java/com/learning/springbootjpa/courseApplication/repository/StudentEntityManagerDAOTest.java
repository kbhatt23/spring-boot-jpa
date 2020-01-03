package com.learning.springbootjpa.courseApplication.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

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
import com.learning.springbootjpa.courseApplication.entity.Passport;
import com.learning.springbootjpa.courseApplication.entity.Student;
import com.learning.springbootjpa.jpaBasicStyle.FootballerJPABasicDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootJpaApplication.class)
public class StudentEntityManagerDAOTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentEntityManagerDAO repo;
	
	@Test
	//roll back after function test
	//the getPassword need session persistence context ,if not set no session exception occurs
	@Transactional
	public void testOneToOneRelatioship() {
		
		logger.info("starting testing one to onerelation");
		
		Student stu = repo.findStudentById(7000);
		logger.info("student data "+ stu);
		Passport pass = stu.getPassport();
		logger.info("passport data "+pass);
	}
	
	
	


}
