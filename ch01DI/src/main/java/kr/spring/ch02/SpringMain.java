package kr.spring.ch02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
 public static void main(String[] args) {
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	 
	StudentBean studentBean = (StudentBean)context.getBean("studentBean");
	
	studentBean.Study("국어");
	
	context.close();
	 
	 
	 
}
}
