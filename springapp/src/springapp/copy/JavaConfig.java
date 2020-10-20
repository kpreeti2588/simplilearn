package springapp.copy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	
	@Bean(name="address")
	Address address() {
		return new Address(102,"JGN Street","ajmer","India");
	}
	
	@Bean(name="employeeDetails")
	EmployeeDetails employeeDetails() {
		return new EmployeeDetails(101,"raju","65545343");
	}

	@PostConstruct
	 public void init() {
    	 System.out.println("initialize method");
    }
	@PreDestroy
    public void destroy() {
    	System.out.println("destroy method");
    }
}
