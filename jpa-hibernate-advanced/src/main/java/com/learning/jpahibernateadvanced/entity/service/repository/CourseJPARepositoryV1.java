package com.learning.jpahibernateadvanced.entity.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.learning.jpahibernateadvanced.bean.ReviewDTO;
import com.learning.jpahibernateadvanced.entity.Course;
import com.learning.jpahibernateadvanced.entity.Review;

@Repository
//without transactional the write methods will break , transaction is mandatory for write operations
//this transaction annotation adds aop interceptor for each emthod and before start of each emthod creats a trsnaction
//and at the end of method commits the transaction
@Transactional
public class CourseJPARepositoryV1 {

	@PersistenceContext
	private EntityManager em;
	
	public List<Course> findAll(){
		TypedQuery<Course> createNamedQuery = em.createNamedQuery("find_all_courses", Course.class);
		return createNamedQuery.getResultList();
	}
	
	public Course findById(int id) {
		return em.find(Course.class, id);
	}
	//now splitting ht functionality of Entity manager
	//using persist for saving and merge for updation
	//public Course insertOrUpdated(Course course) {
		//return em.merge(course);
	//}
	
	public Course update(Course course) {
		 Course merge = em.merge(course);
		 Course updateOne = em.find(Course.class, course.getId());
		 System.out.println("jai shree ram saying with latest course "+updateOne);
		 return merge;
	}
	public void insert(Course course) {
		 em.persist(course);
	}
	
	public void deleteById(int id) {
		em.remove(findById(id));
	}
	
	//public List<Course> findByNameContains(String name){
		//return em.createQuery("select c from Course c where name like '%"+name+"%'", Course.class).getResultList();
	//}
	
	public List<Course> findByNameContains(String name){
		TypedQuery<Course> createQuery = em.createQuery("select c from Course c where name like '%"+name+"%'", Course.class);
		createQuery.setParameter(1, name);
		
		//TypedQuery<Course> createQuery = em.createQuery("select c from Course c where name like '%"+":name"+"%'", Course.class);
		//createQuery.setParameter("name", name);
		return createQuery.getResultList();
	}
	
	public List<Course> findByNameEquals(String name){
		//TypedQuery<Course> createQuery = em.createQuery("select c from Course c where name = ?1", Course.class);
		//createQuery.setParameter(1, name);
		
		//using named query param
		TypedQuery<Course> createQuery = em.createQuery("select c from Course c where name = :name", Course.class);
		createQuery.setParameter("name", name);
		return createQuery.getResultList();
	}
	
	//whole methos is within same trsnasction that gets committed at end of method and starts at the beginining of method
	//any modicuation in entity will get flished at once by transaction
	public void playWithEntitntyManager() {
		System.out.println("Calling playWithEntitntyManager");
		Course playCourse = new Course("play course");
		em.persist(playCourse);
		
		//clear and detach everything done so far in the method
		//em.clear();
		//commit the transaction so far
		em.flush();
		
		Course newCourse = new Course("news course");
		em.persist(newCourse);
		
		em.flush();
		
		//if we put detach it wont accept any modification in entity
		//it ignores this entity tracking so even insertion will be ignored
		//however if we flush before this line it pushed to db at that time itslef -> commit the trasncation so far
		//em.detach(playCourse);
		
		//this detaches all the object and none of the session trsaction is committed
		//em.clear();
		
		playCourse.setName("play course updated");
		newCourse.setName("news course updated");
		
		//to take latest from db and ignore all changes since last flush
		em.refresh(playCourse);
		//now playcourse modifucation will be ignored but not ignored for new course
	}
	
	public void JPQLQueryLearning() {
		System.out.println("==========================");
		String rawSelectQuery = "select c from Course c";
		Query selectAllRawQuery = em.createQuery(rawSelectQuery);
		List resultList = selectAllRawQuery.getResultList();
		System.out.println("Raw query "+rawSelectQuery+ " result is "+resultList);
		System.out.println("==========================");
		TypedQuery<Course> typedSelectQuery = em.createQuery(rawSelectQuery, Course.class);
		List<Course> resultList2 = typedSelectQuery.getResultList();
		System.out.println("typed query "+rawSelectQuery+ " result is "+resultList2);
		System.out.println("==========================");
		String whereSelectQuery = "select c from Course c where name like '%spring%'";
		TypedQuery<Course> createQuery = em.createQuery(whereSelectQuery, Course.class);
		List<Course> resultList3 = createQuery.getResultList();
		
		System.out.println("typed query with where cluase "+whereSelectQuery+ " result is "+resultList3);
	
	}

	public void addReviewToCourse(ReviewDTO review, int id) {
		Course findById = findById(id);
		findById.addReview(new Review(review.getRating(), review.getComment()));
		update(findById);
	}
	
	public Review findReviewById(int id) {
		return em.find(Review.class, id);
	}
	
}
