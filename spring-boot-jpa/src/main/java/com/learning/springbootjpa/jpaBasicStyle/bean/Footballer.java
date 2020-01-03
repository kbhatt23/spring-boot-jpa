package com.learning.springbootjpa.jpaBasicStyle.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "footballer_jpa_basic")
public class Footballer {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	public Footballer( String name, Date birth_date) {
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
