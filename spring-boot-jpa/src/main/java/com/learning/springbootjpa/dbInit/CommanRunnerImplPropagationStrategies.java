package com.learning.springbootjpa.dbInit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.learning.springbootjpa.courseApplication.entity.Course;
import com.learning.springbootjpa.courseApplication.entity.Passport;
import com.learning.springbootjpa.courseApplication.entity.Review;
import com.learning.springbootjpa.courseApplication.entity.Student;
import com.learning.springbootjpa.courseApplication.repository.CourseEntityManagerDAO;
import com.learning.springbootjpa.courseApplication.repository.PassportEntityManagerDAO;
import com.learning.springbootjpa.courseApplication.repository.ReviewRepository;
import com.learning.springbootjpa.courseApplication.repository.StudentEntityManagerDAO;
import com.learning.springbootjpa.inheritanceStrategies.entity.Employee;
import com.learning.springbootjpa.inheritanceStrategies.entity.PartTimeEmployee;
import com.learning.springbootjpa.inheritanceStrategies.entity.PermanentEmployee;
import com.learning.springbootjpa.inheritanceStrategies.repository.EmployeeRepository;
import com.learning.springbootjpa.jdbcStyle.EmployeeJDBCDAO;
import com.learning.springbootjpa.jdbcStyle.bean.Footballer;
import com.learning.springbootjpa.jpaBasicStyle.FootballerJPABasicDAO;
import com.learning.springbootjpa.util.MultiThreadingUtil;

@Configuration
public class CommanRunnerImplPropagationStrategies {
	@Autowired
	private EmployeeJDBCDAO repo;
	
	@Autowired 
	private FootballerJPABasicDAO repoJPABasic;
	
	@Autowired
	private CourseEntityManagerDAO repoCourse;
	
	@Autowired
	private StudentEntityManagerDAO studentRepo;
	
	@Autowired
	private PassportEntityManagerDAO passportRepo;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	ReviewRepository reviewRepo;
	
	
	

	@Bean
	public CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				System.out.println("naye game pro[pagation ki shurat");
				createTwoReviews();
				
			}

			

			

			
		};
	}
	
	private void createTwoReviews() {
		createFirstReview();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false,rollbackFor =RuntimeException.class)
	public void createFirstReview() {
		Review r1 = new Review("2", "fake propagation strategy1");
		reviewRepo.save(r1);
		createSecondReview();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false,rollbackFor =RuntimeException.class  )
	public void createSecondReview() {
		boolean tala=true;
		Review r1 = new Review("2", "fake propagation strategy2");
		reviewRepo.save(r1);
		
	}
	
}
