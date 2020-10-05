package com.learning.jpahibernateadvanced.entity.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.jpahibernateadvanced.entity.inheritance.EmployeeV2;
import com.learning.jpahibernateadvanced.entity.inheritance.FullTimeEmployeeV2;
import com.learning.jpahibernateadvanced.entity.inheritance.PartTimeEmployeeV2;
import com.learning.jpahibernateadvanced.entity.service.repository.EmployeeRepositoryV2;

//@Component
public class TablePerClasscommandLineruner2 implements CommandLineRunner{
	@Autowired
	private EmployeeRepositoryV2 repo;
	
	@Override
	public void run(String... args) throws Exception {
		EmployeeV2 a = new PartTimeEmployeeV2("kannu", 10.10d);
		EmployeeV2 b = new FullTimeEmployeeV2("keshav", 101.10d);
		repo.insert(a);repo.insert(b);
		
		System.out.println("=======================================");
		
		repo.findAll()
			.stream()
			.forEach(System.out::println);
		System.out.println("=======================================");
	}

}
