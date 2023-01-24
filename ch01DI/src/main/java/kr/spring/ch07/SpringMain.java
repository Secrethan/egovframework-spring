package kr.spring.ch07;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		RegisterService service = (RegisterService)context.getBean("registerService");
		service.write();
		context.close();
	}
}
