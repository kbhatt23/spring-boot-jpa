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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.learning.springbootjpa.jpaBasicStyle.bean.Footballer;
import com.learning.springbootjpa.SpringBootJpaApplication;
import com.learning.springbootjpa.courseApplication.entity.Course;
import com.learning.springbootjpa.courseApplication.entity.Passport;
import com.learning.springbootjpa.courseApplication.entity.Review;
import com.learning.springbootjpa.courseApplication.entity.Student;
import com.learning.springbootjpa.jpaBasicStyle.FootballerJPABasicDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootJpaApplication.class)
public class ReviewJPARepositryTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ReviewRepository reviewRepo;
	
	@Test
	//roll back after function test
	//the getPassword need session persistence context ,if not set no session exception occurs
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void testOneToOneRelatioship() {
		
		logger.info("starting testing review repository");
		
		reviewRepo.findReviewByRating("4")
			.forEach(e -> System.out.println("rating ka item "+e));
		
		//testing the first level cache concept
		logger.info("starting sachayi ki shuruat");
		Review r1 = reviewRepo.findById(3003).orElseThrow(RuntimeException::new);
		logger.info("First review fetched "+r1);
		Review r2 = reviewRepo.findById(3003).orElseThrow(RuntimeException::new);
		
		
		logger.info("Second review fetched "+r2);
		fetchReviewInThirTransaction();
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void fetchReviewInThirTransaction() {
		logger.info("third review fetched ki shuruat ");
		
		Review r3 = reviewRepo.findById(3003).orElseThrow(RuntimeException::new);
		logger.info("third review fetched "+r3);
	}
	
	


}
