package com.learning.springbootjpa.courseApplication.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.learning.springbootjpa.courseApplication.entity.Passport;

@Repository
@Transactional
public class PassportEntityManagerDAO {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@PersistenceContext
	private EntityManager em;
	
	public Passport findPassportById(int courseId) {
		return em.find(Passport.class, courseId);
	}
	
	public Passport createOrUpdate(Passport student) {
		if(student.getId() == null) {
			logger.info("Passport is not present and hence creating");
			em.persist(student);
			return student;
		}else {
			logger.info("Updating passport with id "+student.getId());
			return em.merge(student);
		}
		
	}
	
	public void deletePassportById(int courseId) {
		em.remove(findPassportById(courseId));
	}
	
}
