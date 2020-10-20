package com.simplilearn.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpringAspectDAO {

	
	@AfterReturning(pointcut="execution(* com.simplilearn.service.EmployeeDaoService.getEmpDetails(..))")
	public void executeReturning(JoinPoint joinPoint,Object retVal) {
		System.out.println(joinPoint.getSignature().getName()+" ---> returning");
		System.out.println("The return value is "+ retVal);
	}
	
	@Before("execution(* com.simplilearn.service.EmployeeDaoService.saveDetails(..))")
	public void executeBefore() {
		System.out.println("execute Before saveEmpDetails");
	}
	
	
	@After("execution(* com.simplilearn.service.EmployeeDaoService.saveDetails(..))")
	public void executeAfter() {
		System.out.println("execute After execute Save Employee Details");
	}
	
	@Around("execution(* com.simplilearn.service.EmployeeDaoService.deleteEmpDetails(..))")
	public void executeAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println(joinPoint.getSignature().getName()+ " for being execute aound");
		joinPoint.proceed();
		
		System.out.println(joinPoint.getSignature().getName()+ " for being execute aound");
	}
	
}
