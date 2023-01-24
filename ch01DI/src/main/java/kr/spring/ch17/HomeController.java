package kr.spring.ch17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * 설정파일에 <context:component-scan> 태그를 추가하
 * 지정한 패키지에서 @Component 어노테이션이 적용된 클래스를 검색하여 빈객체로 등록해줌
 * 자동으로 등록된 빈객체의 아이디는 클래스 이름의 첫 글자를 소문자로 변환하여 사용
 * ex) HomeController의 빈객체 아이디는 homeController
 * 
 * 빈객체의 이름은 @Component("변경할이름") / @Component @Named("변경할 이름") 변경 가능 
 */

@Component("home")
public class HomeController {
	@Autowired //컨테이너에 있는 같은 타입의 객체를 넣어줌 
	private Camera camera;

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	@Override
	public String toString() {
		return "HomeController [camera=" + camera + "]";
	}
	
	
}
