package com.learning.jdbcbasics.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learning.jdbcbasics.entity.Person;

//working with data base
@Repository
public class PersonJDBCDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findByID(int id) {
		//return jdbcTemplate.queryForObject("select * from person where id=?", Person.class, new Object[] {id});
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id}
		,new BeanPropertyRowMapper<Person>(Person.class));
	}
	public List<Person> findByAddress(String address) {
		//return jdbcTemplate.queryForObject("select * from person where id=?", Person.class, new Object[] {id});
		return jdbcTemplate.query("select * from person where address=?", new Object[] {address}
		,new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public List<Person> findByAddressAndName(String address,String name) {
		//return jdbcTemplate.queryForObject("select * from person where id=?", Person.class, new Object[] {id});
		return jdbcTemplate.query("select * from person where address=? and name=?", new Object[] {address,name}
		,new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public void deleteByID(int id) {
		jdbcTemplate.update("delete from person where id=?", new Object[] {id});
	}
	
	public void insert(Person person) {
		jdbcTemplate.update("insert into person(id,name,address,birth_date) values(?,?,?,?)",
				new Object[] {person.getId(),person.getName(),person.getAddress(),new Timestamp(person.getBirth_date().getTime())});
	}
	
	public void update(Person person) {
		jdbcTemplate.update("update person set name=?,address=?,birth_date=? where id=?",
				new Object[] {person.getName(),person.getAddress(),new Timestamp(person.getBirth_date().getTime()),person.getId()});
	}
}
