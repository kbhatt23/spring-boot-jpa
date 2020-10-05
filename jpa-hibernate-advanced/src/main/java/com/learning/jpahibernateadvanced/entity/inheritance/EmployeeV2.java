package com.learning.jpahibernateadvanced.entity.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//used to represent inhericatnce heirachy with single table
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "employee_type")
public abstract class EmployeeV2 {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String name;

	public EmployeeV2(String name) {
		this.name = name;
	}
	public EmployeeV2() {
	}
	@Override
	public String toString() {
		return "EmployeeV1 [id=" + id + ", name=" + name + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	
	
	
	
	
}
