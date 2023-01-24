package kr.spring.ch03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		OperatorBean operatorBean = (OperatorBean)context.getBean("operatorBean");
		
		System.out.println(operatorBean.add(10, 30));
		
		context.close();
		
	}
}
