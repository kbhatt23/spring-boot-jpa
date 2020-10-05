package com.learning.jpahibernateadvanced.entity.inheritance;

import javax.persistence.Entity;

//used to represent inhericatnce heirachy with single table
@Entity
public class FullTimeEmployeeV2 extends EmployeeV2{

	private Double salary;

	public FullTimeEmployeeV2(String name, Double salary) {
		super(name);
		this.salary = salary;
	}

	public FullTimeEmployeeV2() {
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "FullTimeEmployeeV2 [salary=" + salary + "]";
	}
	
	
	
	
}
