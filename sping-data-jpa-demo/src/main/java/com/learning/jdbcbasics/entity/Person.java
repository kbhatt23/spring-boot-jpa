package com.learning.jdbcbasics.entity;

import java.util.Date;
//this class acts as entity without JPA
//we need to manually do row mapping in jdbc template for each entity -> too much labour work
public class Person {

	private int id;
	private String name;
	private String address;
	private Date birth_date;
	public Person() {
		super();
	}
	public Person(int id, String name, String address, Date birth_date) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.birth_date = birth_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", birth_date=" + birth_date + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
