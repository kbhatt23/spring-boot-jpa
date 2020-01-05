package com.learning.springbootjpa.inheritanceStrategies.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permanent_employee")
public class PermanentEmployee extends Employee{
	
	private Double salary;
	
	protected PermanentEmployee (){
		
	}
	public PermanentEmployee(String name , Double salary) {
		super(name);
		this.salary=salary;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
}
