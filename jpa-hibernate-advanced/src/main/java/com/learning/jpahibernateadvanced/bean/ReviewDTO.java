package com.learning.jpahibernateadvanced.bean;

public class ReviewDTO {

	private Integer id;

	// 0,1,2,3,4,5
	private int rating;

	private String comment;

	public ReviewDTO() {
	}

	public ReviewDTO(int rating, String comment) {
		this.rating = rating;
		this.comment = comment;
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

	public Integer getId() {
		return id;
	}

}
