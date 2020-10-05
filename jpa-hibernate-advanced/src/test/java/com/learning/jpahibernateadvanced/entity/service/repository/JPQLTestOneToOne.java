package com.learning.jpahibernateadvanced.entity.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.jpahibernateadvanced.entity.Student;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JPQLTestOneToOne {

	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	//@Test
	public void oneToOneTest() {
		//jpql is easier
		 List<Student> resultList = em.createQuery("select s from Student s where s.passport is empty", Student.class)
											.getResultList();
		 System.out.println("========================================students with empty passport============================================");
		 resultList.stream()
		 			//.map(Student::getName)
		 			.forEach(System.out::println);
		 System.out.println("========================================students with empty passport============================================");
	
		 List<Student> resultList1 = em.createQuery("select s from Student s where s.passport is not empty", Student.class)
					.getResultList();
System.out.println("========================================students with valid passport============================================");
resultList1.stream()
//.map(Student::getName)
.forEach(System.out::println);
System.out.println("========================================students with valid passport============================================");
	}
}
