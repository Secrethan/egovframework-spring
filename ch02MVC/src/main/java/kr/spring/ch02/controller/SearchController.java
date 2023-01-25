package kr.spring.ch02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	
	/*
	 * @RequstParam 어노테이션은 HTTP 요청 파라미터를 메소드의 파라미터로 전달 
	 * [형식]
	 * 1. @RequestParam(요청 파라미터 네임) 메소드의 인자 
	 * 2. 요청 파라미터 네임과 호출 메소드의 인자명이 같으면 
	 *    @RequestParam 메소드 인자명 
	 * 3. @RequestParam 생략 가능 (요청 파라미터 네임과 호출 메소드의 인자명을 동일하게 표기)  
	 * 
	 * [주의]
	 * 메소드에 @RequestParam을 명시하면 반드시 데이터를 넘겨줘야함 
	 * 만약 query를 필수적으로 사용하지 않는다면
	 * @RequestParam(value="query", required=false)으로 명시
	 * 
	 * 전송되는 데이터가 숫자일 경우 , 데이터가 전송되지 않으면 default 값을 사용할 수 있도록 세팅 
	 * @RequestParam(value="p", defaultValue = "0 혹은 1") int pageNumber 으로 명시
	 * 
	 */
	
	//요청URL과 실행 메소드를 연결 
 	@RequestMapping("/search/internal.do")			//파라미터이름
	public ModelAndView searchInternal(@RequestParam("query") String query) {
 		//	public ModelAndView searchInternal( String query)
		System.out.println("query =" + query);
		
								//뷰이름
		return new ModelAndView("search/internal");
	}
 	
 	@RequestMapping("/search/external.do")
 	public ModelAndView searchExternal(@RequestParam String query,@RequestParam("p") int pageNumber) {
 		System.out.println("query =" + query);
 		System.out.println("p = "+pageNumber);
 		
 									//뷰이름
 		return new ModelAndView("search/external");
 	}
}
