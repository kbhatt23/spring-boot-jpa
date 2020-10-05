package com.learning.jdbcbasics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jdbcbasics.entity.Person;
import com.learning.jdbcbasics.service.PersonJDBCDAO;

@RequestMapping("/v1/persons")
@RestController
public class PersonV1Controller {

	@Autowired
	private PersonJDBCDAO service;
	
	@GetMapping
	public List<Person> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Person findAById(@PathVariable String id){
		return service.findByID(Integer.parseInt(id));
	}
	
	@GetMapping("/name/{name}/address/{address}")
	public List<Person> findByNameAndAddress(@PathVariable String name , @PathVariable String address){
		return service.findByAddressAndName(address, name);
	}
	
	@GetMapping("/address/{address}")
	public List<Person> findByAddress( @PathVariable String address){
		return service.findByAddress(address);
	}
	
	@PostMapping
	public Person create(@RequestBody Person person) {
		service.insert(person);
		return person;
	}
	
	@PutMapping
	public Person update(@RequestBody Person person) {
		service.update(person);
		return person;
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		service.deleteByID(Integer.parseInt(id));
	}
	
	
}
