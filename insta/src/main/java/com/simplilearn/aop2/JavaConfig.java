package com.simplilearn.aop2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.simplilearn.dao.EmployeeDao;
import com.simplilearn.service.EmployeeDaoService;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.simplilearn.*")
public class JavaConfig {
     
	@Bean(name="aspectDao")
	public SpringAspectDAO aspectDAO() {
		
		return new SpringAspectDAO();
	}
	
	@Bean(name="dao")
	public EmployeeDao employeeDao() {
		return EmployeeDao.getEmpDao();
	}
	
	@Bean(name="daoService")
	public EmployeeDaoService daoService() {
		return new EmployeeDaoService();
	}
	
}
