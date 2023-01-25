package kr.spring.ch09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.spring.ch09.vo.MemberVO;

@Controller
public class MemberWriteController {
	
	//자바빈 초기화
	@ModelAttribute("command")
	public MemberVO initCommand() {
		return new MemberVO();
	}
	
	@GetMapping("/member/write.do")
	public String form() {
		return "member/write";
	}
}
