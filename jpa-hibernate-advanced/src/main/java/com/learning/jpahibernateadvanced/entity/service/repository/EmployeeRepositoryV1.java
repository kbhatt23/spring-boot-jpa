package com.learning.jpahibernateadvanced.entity.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.learning.jpahibernateadvanced.entity.inheritance.EmployeeV1;

@Repository
@Transactional
public class EmployeeRepositoryV1 {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(EmployeeV1 emp) {
		em.persist(emp);
	}
	
	public List<EmployeeV1> findAll(){
		return em.createQuery("select e from EmployeeV1 e", EmployeeV1.class)
				.getResultList();
	}
}
