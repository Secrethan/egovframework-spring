package kr.spring.ch06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SystemMonitor monitor = (SystemMonitor)context.getBean("monitor");
		
		System.out.println(monitor);
		
		context.close();
	}
}
