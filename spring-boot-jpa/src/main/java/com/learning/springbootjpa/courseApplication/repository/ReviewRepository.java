package com.learning.springbootjpa.courseApplication.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.learning.springbootjpa.courseApplication.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	public Stream<Review> findReviewByRating(String rating);

}
