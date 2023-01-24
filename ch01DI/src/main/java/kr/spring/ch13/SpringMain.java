package kr.spring.ch13;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
		
		WriteArticleService service = (WriteArticleService)context.getBean("writeArticleService");
		
		service.write();
		
		context.close();
		/*
		 * 빈 객체의 타입인 이름을 이용하여 의존 관계를 자동으로 설정할 수 있는 기능
		 * bean 태그의 autowire 속성에 지정할 수 있는 값
		 * byName : 프로퍼티명과 같은 이름을 갖는 빈 객체를 설정
		 * byType : 프로퍼티타입과 같은 타입을 갖는 빈 객체를 성정
		 * constructor : 생성자 파라미터 타입과 같은 타입을 갖는 빈 객체를 생성자에게 전달 
		 * 
		 */
		
	}
}
