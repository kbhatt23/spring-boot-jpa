package com.learning.jpahibernateadvanced.entity.inheritance;

import javax.persistence.Entity;

//used to represent inhericatnce heirachy with single table
@Entity
public class PartTimeEmployeeV2 extends EmployeeV2{

	private Double hourlyWage;

	public PartTimeEmployeeV2(String name, Double hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	public PartTimeEmployeeV2() {
	}

	public Double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(Double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	@Override
	public String toString() {
		return "PartTimeEmployeeV2 [salary=" + hourlyWage + "]";
	}
	
	
	
	
}
