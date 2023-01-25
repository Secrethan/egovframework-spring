package kr.spring.ch04.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	//쿠키를 생성하는 메소드 
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) {
		//쿠키를 생성해서 클라이언트에 전송
		response.addCookie(new Cookie("auth", "1"));
		
		return "cookie/make";
	}
	
	/*
	 * @CookieValue(value="쿠키명") 메소드 인자 
	 * 쿠키가 없을경우 오류가 발생하기 때문에
	 * @CookieValue(value="쿠키명",required=false or defaultValue = "설정할 디폴트 값 ")
	 */
	
	//쿠키를 읽는 메소드 
	@RequestMapping("/cookie/view.do")
	public String view(@CookieValue(value = "auth", defaultValue = "0") String auth) {
		System.out.println("auth 쿠키 :" + auth);
		
		return "cookie/view";
	}
}
