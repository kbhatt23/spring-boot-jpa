package com.learning.springbootjpa.courseApplication.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.learning.springbootjpa.courseApplication.entity.Course;
import com.learning.springbootjpa.courseApplication.entity.Student;

@Repository
@Transactional(isolation = Isolation.DEFAULT)
public class StudentEntityManagerDAO {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@PersistenceContext
	private EntityManager em;
	
	public Student findStudentById(int courseId) {
		return em.find(Student.class, courseId);
	}
	
	public Student createOrUpdate(Student student) {
		if(student.getId() == null) {
			logger.info("Student is not present and hence creating");
			em.persist(student);
			return student;
		}else {
			logger.info("Updating course with id "+student.getId());
			return em.merge(student);
		}
		
	}
	
	public void deleteStudentById(int courseId) {
		em.remove(findStudentById(courseId));
	}
	
	public List<Student> studentWithNoCourse() {
		Query query = em.createQuery("select s from Student s where s.courses is empty" , Student.class);
		return query.getResultList();
	}
	
}
