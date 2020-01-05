package com.learning.springbootjpa.courseApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.springbootjpa.courseApplication.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
