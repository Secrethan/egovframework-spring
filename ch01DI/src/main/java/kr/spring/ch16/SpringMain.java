package kr.spring.ch16;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
		HomeController controller = (HomeController)context.getBean("homeController");
		
		System.out.println(controller);
		
		context.close();
	}
}
