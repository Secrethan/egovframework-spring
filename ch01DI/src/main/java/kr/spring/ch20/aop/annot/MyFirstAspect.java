package kr.spring.ch20.aop.annot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//공통 기능이 구현되는 클래스 
@Aspect
public class MyFirstAspect {

	/*
	 * 구현 가능한 Advice(언제 공통 기능을 핵심 로직에 적용할지 정의)종류
	 * 
	 * 
	 * Before Advice : 대상 객체의 메소드 호출 전에 공통 기능을 실행	
	 * @Before
	 *  
	 * After Returing Advice : 대상 객체의 메소드가 '예외 없이' 실행한 이후에 공통 기능을 실행 
	 * @AfterReturning
	 * 
	 * After Throwing Advice : 대상 객체의 메소드를 실행하는 중 '예외 발생 시' 공통 기능 실행
	 * @AfterThowing
	 * 
	 * After Advice : 대상 객체의 메소드를 실행 중 '예외 여부와 관계 없이' 공통 기능 실행
	 * @After
	 * 
	 * Around Advice : 대상 객체의 메소드 실행 전, 후 또는 예외 발생 시점에 공통 기능을 실행 
	 * @Around
	 */
	
	//핵심 기능 검색
	@Pointcut("execution(public String launch())")
	public void getPointcut() {
		
	}
	//@Before("getPointcut()")
	public void before() {
		System.out.println("Hello Before! **메소드가 호출되기 전 실행 ! ");
	}
	//@AfterReturning(value = "getPointcut()", returning = "msg")
	public void afterReturning(String msg) {
		//메소드 호출이 예외를 내보내지 않고 종료했을 때 동작하는 어드바이스
		System.out.println("Hello AfterReturning ! ** 메소드가 호출 후에 나온다. 전달된 객체 :"+msg);
	}
	// @AfterThrowing(value = "getPointcut()", throwing = "ex")
	public void afterThrowing(Exception ex) {
		//메소드 호출이 예외를 던졌을 때 동작하는 어드바이스
		System.out.println("Hello AfterThrowing! **예외가 발생 시 나온다 !"+ ex);
	}
	//@After("getPointcut()")
	public void after() {
		//예외가 발생해도 실행됨
		//메소드 종료 후에 동작하는 어드바이스
		System.out.println("Hello After! **메소드가 호출된 후에 나온다.");
	}
	//반환 타입을 지정하면 이 기능 이후에 실행되는 공통 기능에서 반환하는 데이터를 받을 수 있음
	//ProceedingJoinPoint : 핵심기능을 수행하는 객체정보를 갖고 있음 
	@Around("getPointcut()")
	public String around(ProceedingJoinPoint joinPoint) throws Throwable {
		//메소드 호출 전후 동작하는 어드바이스 
		//핵심기능 호출 전 
		System.out.println("Hello Around before ! **메소드가 호출되기 전에 나온다.  ");
		String s = null;
		
		try {
			//핵심 기능을 수행하는 메소드를 호출 
			s = (String)joinPoint.proceed(); //Product의 launch 메소드 호출 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//핵심기능 호출 후 
			System.out.println("HELLO Around After ! **메소드가 호출된 후에 나온다."+s);
		}
		
		
		return s;
	}
	
	
}
