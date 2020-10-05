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

import com.learning.jdbcbasics.entity.PersonV2;
import com.learning.jdbcbasics.service.PersonJDBCDAOV2;

@RequestMapping("/v2/persons")
@RestController
public class PersonV2Controller {

	@Autowired
	private PersonJDBCDAOV2 service;
	
	@GetMapping
	public List<PersonV2> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public PersonV2 findAById(@PathVariable String id){
		return service.findByID(Integer.parseInt(id));
	}
	
	@GetMapping("/name/{name}/address/{address}")
	public List<PersonV2> findByNameAndAddress(@PathVariable String name , @PathVariable String address){
		return service.findByAddressAndName(address, name);
	}
	
	@GetMapping("/address/{address}")
	public List<PersonV2> findByAddress( @PathVariable String address){
		return service.findByAddress(address);
	}
	
	@PostMapping
	public PersonV2 create(@RequestBody PersonV2 person) {
		service.insert(person);
		return person;
	}
	
	@PutMapping
	public PersonV2 update(@RequestBody PersonV2 person) {
		service.update(person);
		return person;
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		service.deleteByID(Integer.parseInt(id));
	}
	
	
}
