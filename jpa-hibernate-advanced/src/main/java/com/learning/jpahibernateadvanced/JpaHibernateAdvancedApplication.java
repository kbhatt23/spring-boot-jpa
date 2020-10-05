package com.learning.jpahibernateadvanced;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

import com.learning.jpahibernateadvanced.entity.Course;
import com.learning.jpahibernateadvanced.entity.Passport;
import com.learning.jpahibernateadvanced.entity.Review;
import com.learning.jpahibernateadvanced.entity.Student;
import com.learning.jpahibernateadvanced.entity.service.repository.CourseJPARepositoryV1;
import com.learning.jpahibernateadvanced.entity.service.repository.StudentJPARepositoryV1;

@SpringBootApplication
@EnableCaching
public class JpaHibernateAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateAdvancedApplication.class, args);
	}
	
	

}
//@Component
class PlayWithEntityManagerRunner implements CommandLineRunner{
	@Autowired
	private CourseJPARepositoryV1 repo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Calling command line runner");	
		repo.playWithEntitntyManager();
	}
}

//@Component
class JPQLLearningRunner implements CommandLineRunner{
	@Autowired
	private CourseJPARepositoryV1 repo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Calling jpql command line runner");	
		repo.JPQLQueryLearning();
	}
}
	//for one to one demo
	//@Component
	class StudentPassportRunner implements CommandLineRunner{
		@Autowired
		private StudentJPARepositoryV1 repo;
		
		@Override
		public void run(String... args) throws Exception {
			System.out.println("Calling student passport runner for one to one demo");	
			Passport p = new Passport("AVEPV199SS");
			Student s = new Student("kanishk");
			s.setPassport(p);
			p.setStudent(s);
			repo.insertStudent(s);
			
			System.out.println("=========================================");
			Student s1 = repo.findStudentById(1);
			System.out.println("student fetched is "+s1);
			Passport p1 = s1.getPassport();
			System.out.println("passport fetched is "+p1);
			
		}
	}
	//since this class have lazy ionitalziation for one to many relationship
	//and since we are not calling entitny manager to find review objects from course
	//we need transactional
	//@Component
	//@Transactional
	class CourseReviewsRunner implements CommandLineRunner{
		@Autowired
		private CourseJPARepositoryV1 repo;
		
		@Override
		public void run(String... args) throws Exception {
			System.out.println("Calling command line runner for course review one to many mapping");
			Review r1 = new Review(5, "Great Course");
			Review r2 = new Review(4, "Good of rbeginners only");
			Course course  = new Course("Reactive Spring");
			
			course.addReview(r1);course.addReview(r2);
			r1.setCourse(course);r2.setCourse(course);
			repo.insert(course);
			
			Course course2  = new Course("SQL using MySQL");
			repo.insert(course2);
			
			//reading ones
			
			System.out.println("===============================================");
			Course courseFind1 = repo.findById(1);
			System.out.println("course found "+courseFind1 +" wit reviews "+courseFind1.getReviews());
			System.out.println("-----------------------------------------------");
			Course courseFind2 = repo.findById(4);
			System.out.println("course found "+courseFind2+" wit reviews "+courseFind2.getReviews());
			
			Review review1 = new Review(5, "wow what a job by teacher");
			review1.setCourse(courseFind1);
			courseFind1.addReview(review1);
			repo.update(courseFind1);
			
			Review review2 = new Review(1, "dont enroll to this course");
			courseFind2.addReview(review2);
			review2.setCourse(courseFind2);
			repo.update(courseFind2);
			System.out.println("***************************************");
			Course courseFind1Updated = repo.findById(1);
			System.out.println("updated course found "+courseFind1Updated +" wit reviews "+courseFind1Updated.getReviews());
			
			System.out.println("***************************************");
			Course courseFind2Updated = repo.findById(4);
			System.out.println("updated course found "+courseFind2Updated +" wit reviews "+courseFind2Updated.getReviews());
		
			System.out.println("++++++++++++++++++++++++++++++++++++++++++");
			
			Review reviewFecthed1 = repo.findReviewById(2);
			Review reviewFecthed2 = repo.findReviewById(6);
			System.out.println("review fetched "+reviewFecthed1 + " with course "+reviewFecthed1.getCourse());
			
			System.out.println("review fetched "+reviewFecthed2 + " with course "+reviewFecthed2.getCourse());
		}
	}
