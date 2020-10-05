package com.learning.jpahibernateadvanced.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpahibernateadvanced.bean.CourseDTO;
import com.learning.jpahibernateadvanced.entity.Course;
import com.learning.jpahibernateadvanced.entity.service.business.CacheLearningService;
import com.learning.jpahibernateadvanced.entity.service.repository.CourseJPARepositoryV1;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseJPARepositoryV1 repo;
	
	@Autowired
	private CacheLearningService cacheService;
	
	
	@GetMapping
	public List<CourseDTO> findAllCourses(){
		return repo.findAll()
			.stream()
			.map(a -> new CourseDTO(a.getId(),a.getName()))
			.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public CourseDTO findById(@PathVariable String id){
		Course findById = repo.findById(Integer.parseInt(id));
		
		return new CourseDTO(findById.getId(),findById.getName());
	}
	
	@PostMapping
	public CourseDTO createCourse(@RequestBody CourseDTO course) {
		/* return */repo.insert(new Course(course.getName()));
		return course;
	}
	@PutMapping
	public CourseDTO updateCourse(@RequestBody CourseDTO course) {
		 repo.update(new Course(course.getId(),course.getName()));
		 return course;
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		repo.deleteById(Integer.parseInt(id));
	}
	
	@GetMapping("/name/{name}")
	public List<Course> findByNAmeContains(@PathVariable String name){
	//	return repo.findByNameContains(name);
		
		return repo.findByNameEquals(name);
	}
	
	@GetMapping("/courses/{index}")
	public String findCachedString(@PathVariable int index){
		return cacheService.findMessage(index);
		
	}
	
}
