package com.learning.jpahibernateadvanced.entity.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.jpahibernateadvanced.entity.Course;
import com.learning.jpahibernateadvanced.entity.Student;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JPQLTestOneToMany {

	@Autowired
	@PersistenceContext
	private EntityManager em;
	
//	@Test
	public void oneToManyTest() {
		//jpql is easier
		 List<Course> resultList = em.createQuery("select s from Course s where s.reviews is empty", Course.class)
											.getResultList();
		 System.out.println("========================================Course with empty reviews============================================");
		 resultList.stream()
		 			//.map(Student::getName)
		 			.forEach(System.out::println);
		 System.out.println("========================================Course with empty reviews============================================");
		 
		 List<Course> resultList1 = em.createQuery("select s from Course s where s.reviews is not empty", Course.class)
					.getResultList();
System.out.println("========================================Course with valid reviews============================================");
resultList1.stream()
//.map(Student::getName)
.forEach(System.out::println);
System.out.println("========================================Course with valid reviews============================================");
	}
	
	@Test
	public void oneToManyTestSize() {
		//jpql is easier
		 List<Course> resultList = em.createQuery("select s from Course s where size(s.reviews) >=2", Course.class)
											.getResultList();
		 System.out.println("========================================Course with 2 or more reviews============================================");
		 resultList.stream()
		 			//.map(Student::getName)
		 			.forEach(System.out::println);
		 System.out.println("========================================Course with 2 or more reviews============================================");
		 
	}
}
