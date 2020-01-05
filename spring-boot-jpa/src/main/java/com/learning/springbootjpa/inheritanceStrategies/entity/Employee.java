package com.learning.springbootjpa.inheritanceStrategies.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

//removed to make it mappedsuperclass
//@Entity
@Table(name = "employee_table")
//commenting single table strategy for inheritance
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "employee_type")

//similar to table per concrete class, but it kills entity features of class and hence can not be used in jpql
@MappedSuperclass
//commenting out joined heirachy @Inheritance(strategy = InheritanceType.JOINED)
public /* commenting part of table per class strategy */ /*abstract */ abstract class Employee {
	@Id
	@GeneratedValue
	@Column(name = "employee_id")
	private Integer id;
	
	@Column(name = "employee_name" , nullable = false)
	private String name;

	public Employee(String name) {
		this.name = name;
	}
	protected Employee() {
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}
