package kr.spring.ch05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Memberservice service = (Memberservice)context.getBean("memberservice");
		
		service.send();
		
		context.close();
	}
}
