package springapp.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SpringBeforeAdvice implements MethodBeforeAdvice {


	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(arg0.getName());
		System.out.println(arg2);
		System.out.println("Method before Advice");
	}

}
