package com.learning.springbootjpa;

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
import com.learning.springbootjpa.jpaBasicStyle.FootballerJPABasicDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootJpaApplication.class)
public class SpringBootJpaApplicationTests {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FootballerJPABasicDAO repo;
	
	@Test
	@DirtiesContext
	public void testDelete() {
		
		logger.info("starting delete tests for DB");
		
		repo.deleteById(1);
		assertNull("footballer should have beedn deleted with id "+1, repo.fetchFootballerById(1));
	}
	
	@Test
	public void contextLoads() {
		
		logger.info("starting create tests for DB");
		
		Footballer footballer = repo.fetchFootballerById(1);
		assertEquals(footballer.getName(), "raghunath");
	}
	


}
