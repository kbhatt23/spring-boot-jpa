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
import com.learning.jdbcbasics.entity.PersonV3;
import com.learning.jdbcbasics.service.PersonJPARepository;
//based on jpa entity manager
@RequestMapping("/v3/persons")
@RestController
public class PersonV2Controller3 {

	@Autowired
	private PersonJPARepository service;
	
	@GetMapping
	public List<PersonV3> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public PersonV3 findAById(@PathVariable String id){
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
	public PersonV3 create(@RequestBody PersonV3 person) {
		service.insert(person);
		return person;
	}
	
	@PutMapping
	public PersonV3 update(@RequestBody PersonV3 person) {
		service.insert(person);
		return person;
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		service.deleteByID(Integer.parseInt(id));
	}
	
	
}
