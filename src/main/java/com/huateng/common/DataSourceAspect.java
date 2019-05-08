package com.huateng.common;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Aspect
@Component
public class DataSourceAspect {

	@Pointcut("execution(* com.huateng.service.impl.*.*(..))")
	private void anyMethod(){}
	
	@AfterReturning(value="anyMethod()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		System.out.println("***************这是切面 afterReturning***************");
		DataSourceHolder.clearDataSourceType();
	}
	
	@Before(value="anyMethod()")
	public void before(JoinPoint joinPoint){
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("***************这是切面 before***************");
		if(method.isAnnotationPresent(DataSource.class)){
			DataSource dataSource = method.getAnnotation(DataSource.class);
			DataSourceHolder.setDataSourceType(dataSource.value());
		}
	
	}
}
