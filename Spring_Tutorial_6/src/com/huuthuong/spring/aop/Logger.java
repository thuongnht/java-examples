package com.huuthuong.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

	@Pointcut("args(expose, aperture)")
	public void getArgsCamera(int expose, double aperture) {}
	
	@Before("getArgsCamera(expose, aperture)")
	public void beforeAdvice(int expose, double aperture) {
		System.out.println("Before Advice ...");

		System.out.printf("Expose %d and Aperture %2f \n", expose, aperture);
	}
	
//	@Pointcut("execution(void com.huuthuong.spring.aop.Camera.snap())")
//	public void cameraSnap() {}
	
//	@Pointcut("target(com.huuthuong.spring.aop.Camera)")
//	public void targetCamera() {}
	
	@Pointcut("within(com.huuthuong.spring.aop.Camera)")
	public void withinCamera() {}
	
	@Pointcut("@annotation(Deprecated)")
	public void annotationPC() {}
	
////	@Before("cameraSnap()")
//	@Before("targetCamera()")
//	public void beforeAdvice(JoinPoint jp) {
//		System.out.println("Before Advice ...");
//		for (Object obj: jp.getArgs()) {
//			System.out.println("Arg: " + obj);
//		}
//	}
	
//	@After("cameraSnap()")
	@After("withinCamera() && annotationPC()")
	public void afterAdvice() {
		System.out.println("After Advice ...");
	}
//	
//	@AfterReturning("cameraSnap()")
//	public void afterReturningAdvice() {
//		System.out.println("After Returing Advice ...");
//	}
//	
//	@AfterThrowing("cameraSnap()")
//	public void afterThrowingAdvice() {
//		System.out.println("After Throwing Advice ...");
//	}
//	
//	@Around("cameraSnap()")
//	public void aroundAdvice(ProceedingJoinPoint p) {
//		System.out.println("Around Advice (Before): ...");
//		
//		try {
//			p.proceed();
//		} catch (Throwable e) {
//			System.out.println("In Around Advice " + e.getMessage());
//		}
//		
//		System.out.println("Around Advice (After): ...");
//		
//		
//	}
	
}
