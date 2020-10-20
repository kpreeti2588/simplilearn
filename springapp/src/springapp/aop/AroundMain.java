package springapp.aop;

import org.springframework.aop.framework.ProxyFactory;

public class AroundMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProxyFactory pf= new ProxyFactory();
		pf.addAdvice(new AroundAdvice());
		pf.setTarget(new EmployeeDetails(111, "priya", "54455"));
		
		EmployeeDetails details = (EmployeeDetails) pf.getProxy();
		details.setName("priya");
		details.setId(123);
		details.setPhone("122311");
		
		int id=details.getId();
		String name=details.getName();
		String phone = details.getPhone();
	}

}
