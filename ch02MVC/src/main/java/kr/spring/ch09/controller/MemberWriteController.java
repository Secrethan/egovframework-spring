package kr.spring.ch09.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	//전송된 데이터 처리
	@PostMapping("/member/write.do")              //@Valid : 어노테이션을 이용한 유효성 체크 시 호출 메소드에서 자바빈을 전달 받을때 명시해야 유효성 체크가 실행하고 오류 발생시 BindingResult에 저장  
	public String submit(@ModelAttribute("command") @Valid MemberVO vo, BindingResult result) {
		if(result.hasErrors()) {
			//유효성 체크 결과 오류 발생 시 폼 호출
			return "member/write";
		}
		
		//유효성 체크 결과 오류가 없으면 index.jsp 호출
		return "redirect:index.jsp";
	}
	
}
