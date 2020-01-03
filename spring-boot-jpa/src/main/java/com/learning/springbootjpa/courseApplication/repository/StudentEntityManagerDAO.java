package com.learning.springbootjpa.courseApplication.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.learning.springbootjpa.courseApplication.entity.Student;

@Repository
@Transactional
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
	
}
