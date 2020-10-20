package springapp.copy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    //		Object o =context.getBean("empObj");
	
		AbstractApplicationContext context =new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Object o =context.getBean("address");
		
		Address address =(Address)o;
		System.out.println(address);
		
		EmployeeDetails e = (EmployeeDetails)context.getBean("employeeDetails");
		System.out.println("Employee --->"+e);
		
		System.out.println("Employee address autowired "+ e.getAddress());
	    
		context.registerShutdownHook();
		
	}

}
