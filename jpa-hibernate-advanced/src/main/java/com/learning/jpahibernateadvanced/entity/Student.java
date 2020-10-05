package com.learning.jpahibernateadvanced.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
//no need to defiune table -> Student named table will be auto created by entity manager
public class Student {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 50,unique = true,nullable = false)
	private String name;
	
	@CreationTimestamp
	//wont be modified ever and hence ofr performance good to use here
	@Column(updatable = false)
	private LocalDateTime creationDate;
	
	@UpdateTimestamp
	private LocalDateTime lastModifiedDate;
	
	@JsonIgnore
	@OneToOne(mappedBy = "student",cascade = CascadeType.ALL
			//lazy means if we do query for student the passport is not loaded form d.b
			//once we call getPassport it calls D.B but that method shud need transacion
			)
	private Passport passport;
	
	@ManyToMany
	private List<Course> courses = new ArrayList<Course>();
	
	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	protected Student() {
		super();
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
	

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", lastModifiedDate="
				+ lastModifiedDate + "]";
	}
	
	
	
}
