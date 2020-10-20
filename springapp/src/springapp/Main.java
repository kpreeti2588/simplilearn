package springapp;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import springapp.copy.JavaConfig;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    //		Object o =context.getBean("empObj");

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Employee e = context.getBean("employee",Employee.class);
		System.out.println(e.getList());
		System.out.println(e.getSet());
		System.out.println(e.getMap());
		System.out.println(e.getNumberList());
		
		Address address = context.getBean("address", Address.class);
		System.out.println(address);
		
		context.registerShutdownHook();
     /*	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Object o =context.getBean("empObj");
		EmployeeDetails emp = (EmployeeDetails)o;
		
		System.out.println("Address  "+emp.getAddress());
		System.out.println("Employee   "+emp);
		
		System.out.println("constructor way to create object");
		System.out.println("Employee ==>"+emp);
		
		
		Address a = context.getBean("addressObject",Address.class);
		System.out.println(a);
		
		Resource resource= new ClassPathResource("spring.xml");
		BeanFactory beanf= new XmlBeanFactory(resource);
		
	//	EmployeeDetails employeeDetails1 = (EmployeeDetails)o;
		EmployeeDetails employeeDetails22=beanf.getBean("empObj",EmployeeDetails.class);
		EmployeeDetails employeeDetails23=beanf.getBean("empObj",EmployeeDetails.class);
		
	//	System.out.println(employeeDetails1);
		System.out.println(employeeDetails22);
		System.out.println(employeeDetails23);
		
	//	System.out.println(employeeDetails1.hashCode());
		System.out.println(employeeDetails22.hashCode());
		System.out.println(employeeDetails23.hashCode());
		
	//	EmployeeDetails employeeDetails = (EmployeeDetails)o;
	//	EmployeeDetails employeeDetails2=context.getBean("empObj",EmployeeDetails.class);
		EmployeeDetails employeeDetails2=beanf.getBean("empObj",EmployeeDetails.class);
// if scope is prototype, it wil give different object each time otherwise same object		
	//	System.out.println(employeeDetails);
		System.out.println(employeeDetails2);
		
	//	System.out.println(employeeDetails.hashCode());
		System.out.println(employeeDetails2.hashCode());*/
		
	}

}
