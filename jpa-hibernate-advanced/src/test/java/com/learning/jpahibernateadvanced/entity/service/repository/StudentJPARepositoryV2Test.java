package com.learning.jpahibernateadvanced.entity.service.repository;

import java.util.List;

import org.hibernate.criterion.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.jpahibernateadvanced.entity.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentJPARepositoryV2Test {

	// demonstration sorting

	@Autowired
	private StudentJPARepositoryV2 repo;

	@Test
	public void testPagination() {
		Pageable pageable = PageRequest.of(0, 1);
		Page<Student> pageStudent = repo.findAll(pageable);

		List<Student> firstPAgeContnet = pageStudent.getContent();
		System.out.println("============first page content=============");

		System.out.println(firstPAgeContnet);

		System.out.println("============first page content=============");

		
		Pageable secondPageContent = pageStudent.nextPageable();
		Page<Student> secondpageStudent = repo.findAll(secondPageContent);
		System.out.println("============second page content=============");
		System.out.println(secondpageStudent.getContent());

		System.out.println("============second page content=============");

		
		Pageable thirdPageContent = secondpageStudent.nextPageable();
		Page<Student> thirdPageContentStu = repo.findAll(thirdPageContent);
		System.out.println("============third page content=============");
		System.out.println(thirdPageContentStu.getContent());

		System.out.println("============third page content=============");
	}

}
