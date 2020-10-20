package springapp.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class SpringBeforeReturning implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(arg1);
		System.out.println("target---  "+arg3);
		System.out.println("Return value "+arg0);
	}

	
}
