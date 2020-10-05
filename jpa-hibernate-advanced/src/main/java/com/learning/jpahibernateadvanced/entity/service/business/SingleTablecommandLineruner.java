package com.learning.jpahibernateadvanced.entity.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.jpahibernateadvanced.entity.inheritance.EmployeeV1;
import com.learning.jpahibernateadvanced.entity.inheritance.FullTimeEmployeeV1;
import com.learning.jpahibernateadvanced.entity.inheritance.PartTimeEmployeeV1;
import com.learning.jpahibernateadvanced.entity.service.repository.EmployeeRepositoryV1;

@Component
public class SingleTablecommandLineruner implements CommandLineRunner{
	@Autowired
	private EmployeeRepositoryV1 repo;
	
	@Override
	public void run(String... args) throws Exception {
		EmployeeV1 a = new PartTimeEmployeeV1("kannu", 10.10d);
		EmployeeV1 b = new FullTimeEmployeeV1("keshav", 101.10d);
		repo.insert(a);repo.insert(b);
		
		System.out.println("=======================================");
		
		repo.findAll()
			.stream()
			.forEach(System.out::println);
		System.out.println("=======================================");
	}

}
