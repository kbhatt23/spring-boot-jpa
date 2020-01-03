package com.learning.springbootjpa.jdbcStyle.bean;

import java.util.Date;

public class FootballerCustom {
	private int id;
	private String name;
	public FootballerCustom(int id, String name, Date birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "FootballerCustom [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public FootballerCustom() {
	}
	//name different to that present in table
	private Date birthDate;

}
