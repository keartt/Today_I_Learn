package com.all.spring;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // 공통기능 지정 
public class LogAop {
	
	@Pointcut("within(com.all.spring.*)")
	private void pointcutMethod() {}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		// 핵심기능 읽어와서 동작
		String singatureStr = joinPoint.getSignature().toShortString();
		System.out.println(singatureStr + " : 어라운드 : 앞뒤로 항상");
		long st = System.currentTimeMillis();

		try {
			Object obj = joinPoint.proceed(); // 핵심기능
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(singatureStr + ": 어라운드 : 앞뒤로 항상 ");
			System.out.println(singatureStr + " 경과시간 : " + (et - st));
		}
		
		
	}
	@Before("pointcutMethod()")
	public void beforeAdvice() {
		System.out.println("비포 : 메소드 실행 전");
	}
	@AfterReturning("pointcutMethod()")
	public void afterReturningAdvice() {
		System.out.println("리터닝 : 에러 없이 성공적으로 실행");
	}
	@AfterThrowing("pointcutMethod()")
	public void afterThrowingAdvice() {
		System.out.println("쓰로잉 :  에러가 발생하여 Exception을 던지는 시점");
	}
	@After("pointcutMethod()")
	public void afterAdvice() {
		System.out.println("애프터 : 실행 후, 성공하든 실패하든");
	}

}
