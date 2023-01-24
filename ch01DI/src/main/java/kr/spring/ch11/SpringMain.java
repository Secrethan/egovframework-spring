package kr.spring.ch11;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		
		ProtocolHandlerFactory handler = (ProtocolHandlerFactory)context.getBean("protocolHandlerFactory");
		
		System.out.println(handler);
		
		context.close();
	}
}
