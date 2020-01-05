package com.learning.springbootjpa.dbInit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

@Configuration
public class CommanRunnerImpl {
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
	
	
	

	@Bean
	public CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				boolean skip =true;
				
				if(!skip) {

				System.out.println("jai mahabali hanuman");
				
						System.out.println("new user created count"+repo.createNewFootballer(new Footballer(1004, "ram", new Date())));
						System.out.println("all footballer result "+repo.fetchAllEmployees());
						
						System.out.println("hanuman footballer data "+repo.fetchFootballerById(1001));
						
						System.out.println("delte footballer "+ repo.deleteFootballerById(1000));
						
						System.out.println("new updated footballer "+repo.updateFootballer(new Footballer(1002, "radhe krishna", new Date())));
				
						
						System.out.println("select using id and custom row mapper "+repo.fetchFootballerByIdCustomRowMapper(1002));
			
			
					System.out.println("=================jai shree ram=============================");	
					
					com.learning.springbootjpa.jpaBasicStyle.bean.Footballer footballer = new com.learning.springbootjpa.jpaBasicStyle.bean.Footballer( "raghunath", new Date());
							repoJPABasic.updateOrCreateFootballer(footballer);
							
							com.learning.springbootjpa.jpaBasicStyle.bean.Footballer footballer1 = new com.learning.springbootjpa.jpaBasicStyle.bean.Footballer( "pavanputra", new Date());
							repoJPABasic.updateOrCreateFootballer(footballer1);
							
							com.learning.springbootjpa.jpaBasicStyle.bean.Footballer footballer2 = new com.learning.springbootjpa.jpaBasicStyle.bean.Footballer( "fakebanda", new Date());
							repoJPABasic.updateOrCreateFootballer(footballer2);
							
							footballer2.setName("fakkaupdate");
							repoJPABasic.updateOrCreateFootballer(footballer2);
							
							repoJPABasic.deleteById(4);
							
							System.out.println("====================================");
							repoCourse.playWithEntityManager();
							
				}
				else {
					System.out.println("=================Creating data for student passport system==============");
					
					Passport p = new Passport("EXP123232");
					passportRepo.createOrUpdate(p);
					
					Student stu = new Student("malinga");
					stu.setPassport(p);
					studentRepo.createOrUpdate(stu);
					createCourseAndStudentRelationship();
					
					
					//inheritance heirachies-single table
					
					PermanentEmployee john = new PermanentEmployee("John", 10000D);
					
					PartTimeEmployee jill = new PartTimeEmployee("Jill", 50D);
					//comented out to implment mappedusperclass
					/*
					 * employeeRepository.createEmployee(john);
					 * employeeRepository.createEmployee(jill);
					 * 
					 * employeeRepository.findAllEmployees() .forEach(emp ->
					 * System.out.println("Employee ka mazaq : "+emp));
					 * 
					 * Employee emp = employeeRepository.findEmployeeById(5);
					 * System.out.println("ek wala employee "+emp);
					 */
					employeeRepository.createParttimeEmployee(jill);
					employeeRepository.createPermanentEmployee(john);
					
					employeeRepository.findPartimeEmployees().forEach(emp -> System.out.println("part time all employees "+emp));
					
					employeeRepository.findPermanentEmployees().forEach(emp -> System.out.println("permanent time all employees "+emp));
					
				}
			}
			
		};
	}
	
	@Transactional
	public void createCourseAndStudentRelationship() {
		Student newstu = new Student("radhav");
		studentRepo.createOrUpdate(newstu);
		Course course = new Course("Spring Cloud Kubernetes");
		repoCourse.createOrUpdate(course);
		newstu.addCourse(course);
		course.addStudents(newstu);
		repoCourse.createOrUpdate(course);
		
	}
}
