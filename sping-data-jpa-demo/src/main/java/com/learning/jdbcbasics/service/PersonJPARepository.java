package com.learning.jdbcbasics.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learning.jdbcbasics.entity.PersonV2;
import com.learning.jdbcbasics.entity.PersonV3;

//working with data base
@Repository
//better will be to keep transaction at business layer
@Transactional
public class PersonJPARepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static RowMapper<PersonV2> PersonV2RowMapper = PersonJPARepository::popluateMapper;
	
	private static PersonV2 popluateMapper(ResultSet rs , int numOfRows) {
		try {
			return new PersonV2(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getTimestamp("birth_date"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PersistenceContext
	private EntityManager em;
	
	public List<PersonV3> findAll(){
		TypedQuery<PersonV3> findAllNamedQuery = em.createNamedQuery("find_all_query", PersonV3.class);
		return findAllNamedQuery.getResultList();
	}
	
	public PersonV3 findByID(int id) {
		return em.find(PersonV3.class, id);
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
		em.remove(findByID(id));
	}
	
	//save and update have same method merge
	public void insert(PersonV3 PersonV3) {
		em.merge(PersonV3);
	}
	
	public void update(PersonV2 PersonV2) {
		em.merge(PersonV2);
	}
}
