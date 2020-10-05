package com.learning.jpahibernateadvanced.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 50,unique = true, nullable = false)
	private String number;
	
	@CreationTimestamp
	//wont be modified ever and hence ofr performance good to use here
	@Column(updatable = false)
	private LocalDateTime creationDate;
	
	@OneToOne
	//columns annotatoin not allowed for one to one mapping
	//@Column(name = "student_id")
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@UpdateTimestamp
	private LocalDateTime lastModifiedDate;

	public Passport(String number) {
		super();
		this.number = number;
	}

	public Passport() {
		super();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + ", creationDate=" + creationDate + ", student=" + student
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	
	
	
}
