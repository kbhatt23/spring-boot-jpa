package com.learning.jpahibernateadvanced.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
//automatic table name will be created as course
@NamedQuery(name = "find_all_courses", query = "select c from Course c")
public class Course {
	//final field can not be reassingned
	//automatic column will be gerneated with name as id
	@Id
	@GeneratedValue
	private Integer id;

	//automatic column will be gerneated with name as name
	@Column(name = "course_name")
	private String name;
	
	//hibernate specid annotation and can not be used outside hibernate
	@UpdateTimestamp
	private LocalDateTime lastModifiedDate;
	
	//do not add setter and getter other wise jackson will map this to DTO and post apis will have this field shown
	//public LocalDateTime getLastModifiedDate() {
		//return lastModifiedDate;
	//}

	//public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		//this.lastModifiedDate = lastModifiedDate;
	//}

	//hibernate specid annotation and can not be used outside hibernate
	@CreationTimestamp
	//no need to update column ever
	@Column(updatable = false)
	private LocalDateTime creationDate;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "course"  )
	private List<Review> reviews = new ArrayList<Review>();
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<Student>();
	

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public Course(String name) {
		this.name = name;
	}
	public Course(int id,String name) {
		this.name = name;
		this.id=id;
	}

	protected Course() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
