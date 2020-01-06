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
import com.learning.springbootjpa.courseApplication.repository.StudentEntityManagerDAO;
import com.learning.springbootjpa.inheritanceStrategies.entity.Employee;
import com.learning.springbootjpa.inheritanceStrategies.entity.PartTimeEmployee;
import com.learning.springbootjpa.inheritanceStrategies.entity.PermanentEmployee;
import com.learning.springbootjpa.inheritanceStrategies.repository.EmployeeRepository;
import com.learning.springbootjpa.jdbcStyle.EmployeeJDBCDAO;
import com.learning.springbootjpa.jdbcStyle.bean.Footballer;
import com.learning.springbootjpa.jpaBasicStyle.FootballerJPABasicDAO;
import com.learning.springbootjpa.util.MultiThreadingUtil;

//@Configuration
public class CommanRunnerImplIsolationStrategies {
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
	
	
	

//	@Bean
	public CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {
			
			@Override
			//@Transactional
			public void run(String... args) throws Exception {
				
				repoCourse.courseWithNoStudent().forEach(e -> System.out.println("course with no student is "+e));
			
				studentRepo.studentWithNoCourse().forEach(e -> System.out.println("student with no course is "+e.getName()));
				
				//isolatioStrategy-dirtyRead
				
				
				runDirtyReadAndSolve();
			}

			private void runDirtyReadAndSolve() {
				Thread t1= new Thread(() -> {
					thread1Exec();
				}); 
				t1.start();
				MultiThreadingUtil.sleep(300);
				Thread t2= new Thread(() -> {
					threadt2Exec();
				}); 
				t2.start();
				
				MultiThreadingUtil.joinThread(t1);
				MultiThreadingUtil.joinThread(t2);
			}

			private void threadt2Exec() {
				System.out.println("Thread t2 started");
				
				
			}

			private void thread1Exec() {
				System.out.println("Thread t1 started");
				Course course = new Course("new fake dirty read course");
				MultiThreadingUtil.sleep(2000);
				System.out.println("course create by thread t1 ");
			}
			
		};
	}
	
}
