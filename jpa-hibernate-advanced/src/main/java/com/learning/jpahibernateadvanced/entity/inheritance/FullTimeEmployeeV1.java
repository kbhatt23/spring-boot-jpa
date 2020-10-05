package com.learning.jpahibernateadvanced.entity.inheritance;

import javax.persistence.Entity;

//used to represent inhericatnce heirachy with single table
@Entity
public class FullTimeEmployeeV1 extends EmployeeV1{

	private Double salary;

	public FullTimeEmployeeV1(String name, Double salary) {
		super(name);
		this.salary = salary;
	}

	public FullTimeEmployeeV1() {
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "FullTimeEmployeeV1 [salary=" + salary + "]";
	}
	
	
	
	
}
