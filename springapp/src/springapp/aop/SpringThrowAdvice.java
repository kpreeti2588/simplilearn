package springapp.aop;

import org.springframework.aop.ThrowsAdvice;

public class SpringThrowAdvice implements ThrowsAdvice {

	
	public void afterThrowing(Exception ex) {
		System.out.println("After Exception");
	}
}
