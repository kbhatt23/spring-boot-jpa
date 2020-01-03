package com.learning.springbootjpa.courseApplication.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue
	@Column(name = "course_id")
	private Integer courseId;
	
	@NotNull
	@Column(name="course_name")
	private String courseName;
	
	@Column(name = "creation_date")
	@CreationTimestamp
	private LocalDateTime creationDate;
	
	@Column(name = "last_modified_date")
	@UpdateTimestamp
	private LocalDateTime lastModifiedDate;

	public Course( @NotNull String courseName) {
		this.courseName = courseName;
	}
	protected Course() {
	}


	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseId() {
		return courseId;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + "]";
	}

	
}
