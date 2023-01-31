package kr.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesController {
	@RequestMapping("/main.do")
	public String main() {
		
		//tiles설정의 식별 값 
		return "main";
	}
	@RequestMapping("/company.do")
	public String company() {
		
		//tiles설정의 식별 값 
		return "company";
	}
	@RequestMapping("/product.do")
	public String product() {
		//tiles설정의 식별 값 
		return "product";
	}
}
