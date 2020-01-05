package com.learning.springbootjpa.courseApplication.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "course" , fetch = FetchType.LAZY)
	private List<Review> reviews;
	
	@ManyToMany()
	@JoinTable(name = "course_student_join_table" , 
			joinColumns = { @JoinColumn(name = "course_join_id") },
			inverseJoinColumns = { @JoinColumn(name = "student_join_id") }
			)
	private List<Student> students=new ArrayList<Student>();

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
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void addStudents(Student student) {
		this.students.add(student);
	}

	
}
