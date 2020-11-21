package com.java.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before; 
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.java.aopdemo.dao.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.java.aopdemo.aspect.revoltAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("==>> Executing @Before advice on method");
		
		//display the method signature
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		System.out.println("Signature - "+methodSignature.toString());
		
		//display the method arguments
		Object[] args = joinPoint.getArgs();
		
		for(Object argument : args) {
			System.out.println(argument);
			
			if(argument instanceof Account) {
				Account account = (Account) argument;
				
				System.out.println("Name: "+account.getName());
				System.out.println("Level: "+account.getLevel());
			}
		}
		
	}
}























