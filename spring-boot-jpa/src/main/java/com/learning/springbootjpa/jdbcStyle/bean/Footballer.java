package com.learning.springbootjpa.jdbcStyle.bean;

import java.util.Date;

public class Footballer {
	private int id;
	private String name;
	public Footballer(int id, String name, Date birth_date) {
		this.id = id;
		this.name = name;
		this.birth_date = birth_date;
	}
	@Override
	public String toString() {
		return "Footballer [id=" + id + ", name=" + name + ", birth_date=" + birth_date + "]";
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
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public Footballer() {
	}
	private Date birth_date;

}
