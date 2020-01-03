package com.learning.springbootjpa.jpaBasicStyle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.learning.springbootjpa.jpaBasicStyle.bean.Footballer;


@Repository
@Transactional
public class FootballerJPABasicDAO {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext
	EntityManager entityManager;
	
	public Footballer fetchFootballerById(int id) {

		return entityManager.find(Footballer.class, id);
	}
	
	public void updateOrCreateFootballer(Footballer footballer) {
		 entityManager.merge(footballer);
	}
	
	public void deleteById(int id) {
		entityManager.remove(fetchFootballerById(id));
	}
	
	
}
