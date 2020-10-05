package com.learning.jpahibernateadvanced.entity.service.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.learning.jpahibernateadvanced.entity.Passport;
import com.learning.jpahibernateadvanced.entity.Student;

@Repository
@Transactional
public class StudentJPARepositoryV1 {

	@PersistenceContext
	private EntityManager em;
	public void insertStudent(Student student) {
		
		//if cascade is set to all -> no need to nmaually persist passport
		//if(student.getPassport() != null) {
			//em.persist(student.getPassport());
		//}
		em.persist(student);
	}
	
	public Student findStudentById(int id) {
		return em.find(Student.class, id);
	}
	/*
	 * public void insertPassport(Passport passport) {
	 * 
	 * //if cascade is set to all -> no need to nmaually persist passport
	 * //if(student.getPassport() != null) { //em.persist(student.getPassport());
	 * //} em.persist(passport); }
	 */
}
