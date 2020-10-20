package com.ymail.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ymail.dao.EmployeeDao;
import com.ymail.model.EmployeeDetails;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
       EmployeeDao dao = context.getBean("empDao",EmployeeDao.class);
       EmployeeDetails e = new EmployeeDetails(1249,"CTS","sana","98734",22.34f,'F');
   //  dao.saveEmployee(e);
    //   dao.updateEmployee(e);
     //  dao.deleteEmployee(e);
    //   dao.saveEmployee();
    //   dao.saveEmployee(new EmployeeDetails());
       List<EmployeeDetails> list= dao.getDetails();
       for (EmployeeDetails employeeDetails : list) {
		System.out.println(employeeDetails);
	}
		
	}

}
