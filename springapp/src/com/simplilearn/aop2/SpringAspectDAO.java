package com.simplilearn.aop2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SpringAspectDAO {

	@Before("execution(* com.simplilearn.service.EmployeeDaoService.saveDetails(..))")
	public void executeBefore() {
		System.out.println("execute Before");
	}
	
	@After("execution(* com.simplilearn.service.EmployeeDaoService.saveDetails(..))")
	public void executeAfter() {
		System.out.println("execute After  ");
	}
	
	public void executeAfterReturn() {
		System.out.println("execute After Return");
	}
	
}
