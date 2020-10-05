package com.learning.jdbcbasics.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.jdbcbasics.entity.Person;
import com.learning.jdbcbasics.entity.PersonV2;


@Component
public class JDBCCommandLineRunnerV2 implements CommandLineRunner{
	@Autowired
	private PersonJDBCDAOV2 personJDBCDAO;
	private Logger logger = LoggerFactory.getLogger(JDBCCommandLineRunnerV2.class);
	
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("JDBCCommandLineRunner: jai shree ram from sperator command line runner component");
		logger.info("jai shree ram from sperator command line runner component");
		
		  int dId = 10002; logger.info("deleting person by id "+dId);
		  personJDBCDAO.deleteByID(dId);
		  
		  logger.info("creating person with id "+dId); 
		  PersonV2 createPerson = new
		  PersonV2(dId, "auto created", "temp", new Date());
		  personJDBCDAO.insert(createPerson);
		  
		  logger.info("updating person witd id "+dId);
		  createPerson.setPersonName("auto updated");
		  createPerson.setPersonAddress("updated temp"); personJDBCDAO.update(createPerson);
		 
		 
		
		personJDBCDAO.findAll()
					 .forEach(a -> logger.info(a.toString()));
		
		//System.out.println("JDBCCommandLineRunner:==========================================");
		logger.info("==========================================");
		
		  int pId= 10001; //int pId= 10077;
		  logger.info("Person with id {} is {} ",pId,personJDBCDAO.findByID(pId));
		  
		  String address = "everywhere"; personJDBCDAO.findByAddress(address).forEach(a
		  -> logger.info("Person with address {} is {}",address,a));
		  
		  String name = "narayan";
		  personJDBCDAO.findByAddressAndName(address,name).forEach(a ->
		  logger.info("Person with address {} and name {} is {}",address,name,a));
		 
		logger.info("==========================================");
	}

}
