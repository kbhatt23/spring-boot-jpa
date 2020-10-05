package com.learning.jpahibernateadvanced.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Integer id;
	
	
	//0,1,2,3,4,5
	private int rating;
	
	//optional
	@Column(nullable = true)
	private String comment;
	
	@UpdateTimestamp
	@JsonIgnore
	private LocalDateTime lastModifiedDate;
	
	@JsonIgnore
	@CreationTimestamp
	//no need to update column ever
	@Column(updatable = false)
	private LocalDateTime creationDate;
	
	@ManyToOne
	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Review() {
		super();
	}

	public Review(int rating, String comment) {
		super();
		this.rating = rating;
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", comment=" + comment + ", lastModifiedDate="
				+ lastModifiedDate + ", creationDate=" + creationDate + "]";
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getId() {
		return id;
	}
	
	
}
