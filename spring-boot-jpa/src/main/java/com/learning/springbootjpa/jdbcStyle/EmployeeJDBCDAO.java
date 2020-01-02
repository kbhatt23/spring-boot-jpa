package com.learning.springbootjpa.jdbcStyle;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.springbootjpa.jdbcStyle.bean.Footballer;

@Repository
public class EmployeeJDBCDAO {

	@Autowired
	private JdbcTemplate template;
	
	public List<Footballer> fetchAllEmployees(){
		//query functions allow only read only operations
		return template.query("select * from footballer", new BeanPropertyRowMapper(Footballer.class));
	}
	
	public Footballer fetchFootballerById(int id) {
		//this is read only plus we can pass input query params i.e where clause
		return template.queryForObject("select * from footballer where id=? AND name=?", new Object[] { id ,"hanuman"},
				new BeanPropertyRowMapper<Footballer>(Footballer.class));
	}
	
	public int deleteFootballerById(int id) {
		//can not use query function
		return template.update("delete from footballer where id=?", new Object[] { id})
				;
	}
	
	public int createNewFootballer(Footballer footballer) {
		return template.update("insert into footballer (id,name,birth_date)" + 
				"values(?,?,?)" , new Object[] {footballer.getId(), footballer.getName(), new Timestamp(footballer.getBirth_date().getTime())});
	}
	
	public int updateFootballer(Footballer footballer) {
		return template.update("update footballer set name =?" + 
				" where id=?" , new Object[] {footballer.getName(),footballer.getId()});
	}
	
	
}
