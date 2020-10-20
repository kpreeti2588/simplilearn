package com.ymail.aop;

import org.aspectj.lang.JoinPoint;

public class YmailAspect {

	public void executeBefore(JoinPoint joinPoint) {
		System.out.println("before");
	}
	
}
