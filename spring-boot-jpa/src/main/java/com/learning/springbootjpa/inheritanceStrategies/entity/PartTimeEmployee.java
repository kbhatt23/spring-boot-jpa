package com.learning.springbootjpa.inheritanceStrategies.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "part_time_employee")
public class PartTimeEmployee extends Employee{

	private Double hourlyWage;
	
	protected PartTimeEmployee() {
	}
	public PartTimeEmployee(String name, Double hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	public Double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(Double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
}
