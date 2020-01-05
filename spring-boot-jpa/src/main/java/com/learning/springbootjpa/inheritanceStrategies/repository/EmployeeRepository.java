package com.learning.springbootjpa.inheritanceStrategies.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.springbootjpa.inheritanceStrategies.entity.Employee;
import com.learning.springbootjpa.inheritanceStrategies.entity.PartTimeEmployee;
import com.learning.springbootjpa.inheritanceStrategies.entity.PermanentEmployee;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	private EntityManager em;
	//commented becuase of mappedsuper class
	
	/*
	 * public void createEmployee(Employee employee) { em.persist(employee); }
	 * 
	 * public Employee findEmployeeById(int id) { return em.find(Employee.class,
	 * id); }
	 * 
	 * public List<Employee> findAllEmployees(){ return
	 * em.createQuery("select e from Employee e",Employee.class).getResultList(); }
	 */
	
	public void createParttimeEmployee(PartTimeEmployee employee) { em.persist(employee); }
	
	public void createPermanentEmployee(PermanentEmployee employee) { em.persist(employee); }
	
	
	public List<PartTimeEmployee> findPartimeEmployees(){
		return em.createQuery("select e from PartTimeEmployee e",PartTimeEmployee.class).getResultList();
	}
	
	public List<PermanentEmployee> findPermanentEmployees(){
		return em.createQuery("select e from PermanentEmployee e",PermanentEmployee.class).getResultList();
	}
}
