package kr.spring.ch19.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.spring.ch18.SpringConfig;
import kr.spring.product.Product;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAOP.xml");
	
		Product p = (Product)context.getBean("product");
		p.launch();
		
		context.close();
	}
}
