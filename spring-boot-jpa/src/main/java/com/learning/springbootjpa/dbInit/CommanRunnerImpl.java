package com.learning.springbootjpa.dbInit;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.springbootjpa.jdbcStyle.EmployeeJDBCDAO;
import com.learning.springbootjpa.jdbcStyle.bean.Footballer;

@Configuration
public class CommanRunnerImpl {
	@Autowired
	private EmployeeJDBCDAO repo;

	@Bean
	public CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {

				System.out.println("jai mahabali hanuman");
				
						System.out.println("new user created count"+repo.createNewFootballer(new Footballer(1004, "ram", new Date())));
						System.out.println("all footballer result "+repo.fetchAllEmployees());
						
						System.out.println("hanuman footballer data "+repo.fetchFootballerById(1001));
						
						System.out.println("delte footballer "+ repo.deleteFootballerById(1000));
						
						System.out.println("new updated footballer "+repo.updateFootballer(new Footballer(1002, "radhe krishna", new Date())));
				
			}
		};
	}
}
