package kr.spring.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {

		//MessageBean messageBean = new MessageBean(); heap 영역에 생성하지만 컨테이너에는 넣어지지 않음  
	
		//applicationContext.xml 설정 파일을 읽어들여 스프링 컨테이너를 생성
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//객체를 컨테이너로부터 읽어들임
		MessageBean messageBean =(MessageBean)context.getBean("messageBean");
		
		messageBean.sayHello("배고파");
		
		//어플리케이션 종료시 컨테이너에 존재하는 모든 빈(객체)를 종료
		context.close();
		
	}
}
