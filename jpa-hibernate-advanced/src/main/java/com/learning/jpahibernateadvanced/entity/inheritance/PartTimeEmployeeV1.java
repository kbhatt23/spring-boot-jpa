package com.learning.jpahibernateadvanced.entity.inheritance;

import javax.persistence.Entity;

//used to represent inhericatnce heirachy with single table
@Entity
public class PartTimeEmployeeV1 extends EmployeeV1{

	private Double hourlyWage;

	public PartTimeEmployeeV1(String name, Double hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	public PartTimeEmployeeV1() {
	}

	public Double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(Double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	@Override
	public String toString() {
		return "PartTimeEmployeeV1 [salary=" + hourlyWage + "]";
	}
	
	
	
	
}
