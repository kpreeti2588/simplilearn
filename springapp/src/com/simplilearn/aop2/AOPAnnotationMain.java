package com.simplilearn.aop2;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simplilearn.model.EmployeeDetails;
import com.simplilearn.service.EmployeeDaoService;

public class AOPAnnotationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	ApplicationContext context =new ClassPathXmlApplicationContext("spring2.xml");
		
		AbstractApplicationContext context =new AnnotationConfigApplicationContext(JavaConfig.class);
		EmployeeDaoService service = context.getBean("service",EmployeeDaoService.class);
		try {
			service.saveEmpDetails(new EmployeeDetails(1234,"mani", 4554.3f, "34343", 'F', "ITC"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
