package com.learning.jpahibernateadvanced.entity.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.learning.jpahibernateadvanced.entity.inheritance.EmployeeV1;
import com.learning.jpahibernateadvanced.entity.inheritance.EmployeeV2;

@Repository
@Transactional
public class EmployeeRepositoryV2 {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(EmployeeV2 emp) {
		em.persist(emp);
	}
	
	public List<EmployeeV2> findAll(){
		return em.createQuery("select e from EmployeeV2 e", EmployeeV2.class)
				.getResultList();
	}
}
