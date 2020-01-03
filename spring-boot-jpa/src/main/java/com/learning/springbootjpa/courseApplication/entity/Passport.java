package com.learning.springbootjpa.courseApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "passport")
public class Passport {
	@Id
	@GeneratedValue
	private Integer id;
	
	

	@Column(name = "passport_number" , nullable = false)
	private String passportNumber;
	
	protected Passport() {
		
	}
	public Passport(String passportNumber) {
		this.passportNumber=passportNumber;	
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Passport [passportId=" + id + ", passportNumber=" + passportNumber + "]";
	}
	
	
}
