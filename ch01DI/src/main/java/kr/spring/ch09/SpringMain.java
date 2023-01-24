package kr.spring.ch09;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		UploadController upload = (UploadController)context.getBean("upload");
		
		System.out.println(upload.toString());
		
		context.close();
	}
}
