package com.learning.jdbcbasics.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learning.jdbcbasics.entity.PersonV2;

//working with data base
@Repository
public class PersonJDBCDAOV2 {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static RowMapper<PersonV2> PersonV2RowMapper = PersonJDBCDAOV2::popluateMapper;
	
	private static PersonV2 popluateMapper(ResultSet rs , int numOfRows) {
		try {
			return new PersonV2(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getTimestamp("birth_date"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<PersonV2> findAll(){
		return jdbcTemplate.query("select * from PersonV2", PersonV2RowMapper);
	}
	
	public PersonV2 findByID(int id) {
		//return jdbcTemplate.queryForObject("select * from PersonV2 where id=?", PersonV2.class, new Object[] {id});
		return jdbcTemplate.queryForObject("select * from PersonV2 where id=?", new Object[] {id}
		,PersonV2RowMapper);
	}
	public List<PersonV2> findByAddress(String address) {
		//return jdbcTemplate.queryForObject("select * from PersonV2 where id=?", PersonV2.class, new Object[] {id});
		return jdbcTemplate.query("select * from PersonV2 where address=?", new Object[] {address}
		,PersonV2RowMapper);
	}
	
	public List<PersonV2> findByAddressAndName(String address,String name) {
		//return jdbcTemplate.queryForObject("select * from PersonV2 where id=?", PersonV2.class, new Object[] {id});
		return jdbcTemplate.query("select * from PersonV2 where address=? and name=?", new Object[] {address,name}
		,PersonV2RowMapper);
	}
	
	public void deleteByID(int id) {
		jdbcTemplate.update("delete from PersonV2 where id=?", new Object[] {id});
	}
	
	public void insert(PersonV2 PersonV2) {
		jdbcTemplate.update("insert into PersonV2(id,name,address,birth_date) values(?,?,?,?)",
				new Object[] {PersonV2.getPersonId(),PersonV2.getPersonName(),PersonV2.getPersonAddress(),new Timestamp(PersonV2.getBirthDate().getTime())});
	}
	
	public void update(PersonV2 PersonV2) {
		jdbcTemplate.update("update PersonV2 set name=?,address=?,birth_date=? where id=?",
				new Object[] {PersonV2.getPersonName(),PersonV2.getPersonAddress(),new Timestamp(PersonV2.getBirthDate().getTime()),PersonV2.getPersonId()});
	}
}
