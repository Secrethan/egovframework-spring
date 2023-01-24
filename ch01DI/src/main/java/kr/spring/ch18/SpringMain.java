package kr.spring.ch18;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		//스프링 컨테이너 생성 	
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Executor executor = (Executor)context.getBean("executor");
		executor.addUnit();
	
		context.close();
	}
}
