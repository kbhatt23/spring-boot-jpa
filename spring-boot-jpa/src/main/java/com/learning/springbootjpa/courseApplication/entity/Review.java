package com.learning.springbootjpa.courseApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String rating;
	
	@Column(nullable = false)
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course; 

	public Review( String rating, String comment) {
		this.rating = rating;
		this.comment = comment;
	}

	protected Review() {
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", comment=" + comment + "]";
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
