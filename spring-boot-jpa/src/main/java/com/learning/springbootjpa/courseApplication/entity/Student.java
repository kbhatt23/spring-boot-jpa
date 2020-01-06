package com.learning.springbootjpa.courseApplication.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	//if we set below as lazy then student.getPassport function
	//should be inside transaction
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;
	
	

	@Column(name = "student_name" , nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "students")
	private List<Course> courses = new ArrayList<Course>();
	
	
	protected Student() {
		
	}
	public Student(String name) {
		this.name=name;	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", passport=" + passport + ", name=" + name + "]";
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
	
}
