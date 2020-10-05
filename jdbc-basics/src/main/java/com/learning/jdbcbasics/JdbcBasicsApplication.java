package com.learning.jdbcbasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.learning.jdbcbasics.service.PersonJDBCDAO;

@SpringBootApplication
public class JdbcBasicsApplication {
	
	private Logger logger = LoggerFactory.getLogger(JdbcBasicsApplication.class);
	@Autowired
	private PersonJDBCDAO personJDBCDAO;

	public static void main(String[] args) {
		SpringApplication.run(JdbcBasicsApplication.class, args);
	}
	
	//@Bean
	CommandLineRunner commandLingRunnerUsingBean() {
		return (args) ->{
			logger.info("jai shree ram from sperator command line runner bean");
			personJDBCDAO.findAll()
						 .forEach(a -> logger.info(a.toString()));
			
			//System.out.println("JDBCCommandLineRunner:==========================================");
			logger.info("-------------------------------------------");
		};
	}

}
