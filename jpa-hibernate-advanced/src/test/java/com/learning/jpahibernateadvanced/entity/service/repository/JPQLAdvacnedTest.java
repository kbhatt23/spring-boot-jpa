package com.learning.jpahibernateadvanced.entity.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.jpahibernateadvanced.entity.Course;
import com.learning.jpahibernateadvanced.entity.Student;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JPQLAdvacnedTest {
	@PersistenceContext
	private EntityManager em;
	
	@Test
	public void testAdvanecedJPQL() {
		System.out.println("jai shree ram");
		List<Course> resultList = em.createQuery("select s from Course s order by size(s.students)", Course.class).getResultList();
		
		 System.out.println("========================================Course with order by size of students============================================");
		 resultList.stream()
		 			//.map(Student::getName)
		 			.forEach(System.out::println);
		 System.out.println("========================================Course with order by size of students============================================");
	}
	
	@Test
	public void testAdvanecedJPQL1() {
		System.out.println("jai shree ram again");
		List<Student> resultList = em.createQuery("select s from Student s where s.passport.number like '%AVE%'", Student.class).getResultList();
		
		 System.out.println("========================================Course with passport pattern============================================");
		 resultList.stream()
		 			//.map(Student::getName)
		 			.forEach(System.out::println);
		 System.out.println("========================================Course with passport pattern============================================");
	}
}
