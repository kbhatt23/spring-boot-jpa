package com.learning.springbootjpa.courseApplication.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.learning.springbootjpa.courseApplication.entity.Course;
import com.learning.springbootjpa.util.MultiThreadingUtil;

@Repository
public class CourseEntityManagerDAO {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public List<Course> findAllCourses(){
		 TypedQuery<Course> courseAllQuery = em.createQuery("select c from Course c", Course.class);
		return courseAllQuery.getResultList();
	}
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public Course findCourseById(int courseId) {
		return em.find(Course.class, courseId);
	}
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
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
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void deleteCourseById(int courseId) {
		em.remove(findCourseById(courseId));
	}
	@Transactional(isolation = Isolation.SERIALIZABLE)
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
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public List<Course> courseWithNoStudent() {
		Query query = em.createQuery("select c from Course c where c.students is empty" , Course.class);
		return query.getResultList();
	}
	
}
