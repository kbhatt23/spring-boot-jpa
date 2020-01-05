package com.learning.springbootjpa.courseApplication.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.learning.springbootjpa.courseApplication.entity.Course;

@Repository
@Transactional
public class CourseEntityManagerDAO {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@PersistenceContext
	private EntityManager em;
	
	public Course findCourseById(int courseId) {
		return em.find(Course.class, courseId);
	}
	
	public Course createOrUpdate(Course course) {
		if(course.getCourseId() == null) {
			logger.info("Course is not present and hence creating");
			em.persist(course);
			return course;
		}else {
			logger.info("Updating course with id "+course.getCourseId());
			return em.merge(course);
		}
		
	}
	
	public void deleteCourseById(int courseId) {
		em.remove(findCourseById(courseId));
	}
	
	public void playWithEntityManager() {
		logger.info("started playing with entitymanager");
		
		Course course = new Course("react js for java developer");
		
		em.persist(course);
		em.flush();
		//em.clear();
		
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		//Course cUpdate = findCourseById(5);
		//cUpdate.setCourseName("updated react js");
		
	}
}
