package kr.spring.ch17;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContextScan.xml");
		
		HomeController controller = (HomeController)context.getBean("home");
		
	System.out.println(controller);
	
	context.close();
	}
}
