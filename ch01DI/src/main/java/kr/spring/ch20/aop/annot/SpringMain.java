package kr.spring.ch20.aop.annot;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.spring.product.Product;

public class SpringMain {
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAOPAnnot.xml");
		
		Product p = (Product)context.getBean("product");
		p.launch();
	
		context.close();
	}
}
