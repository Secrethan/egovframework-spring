package kr.spring.ch01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//어노테이션이 명시된 클래스는 Controller 객체로 클라이언트가 요청하면 호출 가능한 객체가 됨 
@Controller
public class HelloController {
	//요청 URL과 실행 메소드를 연결
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		
		//뷰이름 지정
		mav.setViewName("hello");
		
		//뷰에서 사용할 데이터 세팅
		mav.addObject("greeting", "안녕하세요.");
		
		
				
		//DispatcherServlet에 반환 
		//DispatcherServlet이 greeting에 해당하는 값을 request에 저장 
		return mav;
	}
}
