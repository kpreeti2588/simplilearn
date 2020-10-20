package com.simplilearn.aop2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.simplilearn.service.EmployeeDaoService;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.simplilearn.*")
public class JavaConfig {
     
	@Bean(name="aspect")
	SpringAspectDAO aspectDAO() {
		
		return new SpringAspectDAO();
	}
	
	@Bean(name="service")
	EmployeeDaoService daoService() {
		return new EmployeeDaoService();
	}
	
}
