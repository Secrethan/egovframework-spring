package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.AuthCheckException;
import kr.spring.util.FileUtil;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	// 자바빈(VO) 초기화
	@ModelAttribute
	public MemberVO initCommand() {
		return new MemberVO();
	}

	// =========회원가입============//
	// 아이디 중복 체크
	@RequestMapping("/member/confirmId.do")
	@ResponseBody
	public Map<String, String> process(@RequestParam String id) {
		logger.debug("<<id>> : " + id);

		Map<String, String> mapAjax = new HashMap<String, String>();

		MemberVO member = memberService.selectCheckMember(id);
		if (member != null) {
			// 아이디 중복
			mapAjax.put("result", "idDuplicated");
		} else {
			if (!Pattern.matches("^[A-Za-z0-9]{4,12}$", id)) {
				// 패턴 불일치
				mapAjax.put("result", "notMatchPattern");
			} else {
				// 패턴 일치하면서 아이디 미중복
				mapAjax.put("result", "idNotFound");
			}
		}

		return mapAjax;
	}

	// 회원가입 폼 호출
	@GetMapping("/member/registerUser.do")
	public String form() {
		return "memberRegister";// 타일스 설정값
	}

	// 회원가입 데이터 전송
	@PostMapping("/member/registerUser.do")
	public String submit(@Valid MemberVO memberVO, BindingResult result, Model model) {

		logger.debug("<<회원가입>> : " + memberVO);

		// 유효성 체크 결과 오류가 있으면 폼 호출
		if (result.hasErrors()) {
			return form();
		}

		// 회원가입
		memberService.insertMember(memberVO);

		model.addAttribute("accessMsg", "회원가입이 완료되었습니다.");

		return "common/notice";
	}

	// ======회원 로그인 =====/
	// 로그인 폼 호출
	@GetMapping("/member/login.do")
	public String formLogin() {
		return "memberLogin";
	}

	// 로그인 폼에 전송된 데이터 처리
	@PostMapping("/member/login.do")
	public String submitLogin(@Valid MemberVO memberVO, BindingResult result, HttpSession session,HttpServletResponse response) {
		logger.debug("<<회원로그인>>" + memberVO);

		// 유효성 체크(아이디,비밀번호만) 결과 오류 발생시 폼 호출
		if (result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
			return formLogin();
		}

		// 로그인 체크
		MemberVO member = null;
		try {
		member = memberService.selectCheckMember(memberVO.getId());

		boolean check = false;

		if (member != null) {
			check = member.isCheckedPassword(memberVO.getPasswd());
		}
		if (check) { // 인증성공
			// 자동 로그인 체크

			// 인증성공, 로그인 처리
			session.setAttribute("user", member);
			logger.debug("<<인증성공>>" + member.getId());

			if (member.getAuth() == 9) {
				return "redirect:/main/admin.do";
			} else {
				return "redirect:/main/main.do";
			}
		}
		// 인증 실패
		throw new AuthCheckException();
		}catch(
	AuthCheckException e)
	{
		// 인증 실패로 로그인 폼 호출
		if (member != null && member.getAuth() == 1) {
			// 정지회원 메시지 표시
			result.reject("noAutohority");
		} else {
			result.reject("invalidIdOrPassword");
		}
		logger.debug("<<인증 실패>>");
		return formLogin();
	}

}
	//로그아웃 폼 호출
	@GetMapping("/member/logout.do")
	public String processLogout(HttpSession session, HttpServletResponse response) {
		//로그아웃
		session.invalidate();
		
		//자동 로그인 클라이언트 쿠키 처리
		
		return "redirect:/main/main.do";
	}
	
	// ====== 회원 상세 정보 ======//
	@RequestMapping("/member/myPage.do") 
	public String process(HttpSession session, Model model) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		//회원 정보 읽어오기 
		MemberVO member = memberService.selectMember(user.getMem_num());
		
		logger.debug("<<회원상세정보>> : "+member);
		model.addAttribute("member",member);
		return "myPage";
	}
	//=====프로필 사진 업로드 =====//
	@RequestMapping("/member/updateMyPhoto.do")
	@ResponseBody
	public Map<String,String> processProfile(MemberVO memberVO, HttpSession session){
		Map<String,String> mapAjax = new HashMap<String,String>();
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user==null) {
			mapAjax.put("result", "logout");
		}
		else {
			memberVO.setMem_num(user.getMem_num());
			memberService.updateProfile(memberVO);
			
			mapAjax.put("result", "success");
			
		}
		return mapAjax;
	}
	
	
	//====회원 정보 수정 =====//
	@RequestMapping("/member/update.do")
	public String formUpdate(HttpSession session, Model model) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		MemberVO memberVO = memberService.selectMember(user.getMem_num());
		
		model.addAttribute("memberVO", memberVO);
		
		
		return "memberModify";
	}
	//수정 폼에서 전송된 데이터 호출
	@PostMapping("/member/update.do")
	public String submitUpdate(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {
			logger.debug("<<회원정보수정 처리>> :" +memberVO);	
			
			//유효성 체크 결과 오류가 있으면 폼 호출
			if(result.hasErrors()) {
				return "memberModify";
			}
			MemberVO user = (MemberVO)session.getAttribute("user");
			//회원번호가 전송되지 않아서 세션에 저장된 회원번호 사용 
			memberVO.setMem_num(user.getMem_num());
			
			//회원번호 수정
			memberService.updateMember(memberVO);
			return "redirect:/member/myPage.do";
	}
	//====프로필 사진 출력(로그인 출력)======//
	@RequestMapping("/member/photoView.do")
	public String getProfile(HttpSession session, HttpServletRequest request, Model model) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		logger.debug("<<photoView>>"+user);
		
		if(user==null) {
			byte[] readbyte = FileUtil.getBytes(request.getServletContext().getRealPath("/image_bundle/face.png"));
								//속성명, 속성값
			model.addAttribute("imageFile",readbyte);
			model.addAttribute("filename","face.png");
		}
		else {
			MemberVO memberVO = memberService.selectMember(user.getMem_num());
			
			viewProfile(memberVO,request,model);
		}
		return "imageView"; 
	}
	//프로필 사진 처리를 위한 공통 코드
	public void viewProfile(MemberVO memberVO, HttpServletRequest request, Model model) {
		if(memberVO.getPhoto_name()==null) {
			//기본 이미지	
			byte[] readbyte = FileUtil.getBytes(request.getServletContext().getRealPath("/image_bundle/face.png"));
			model.addAttribute("imageFile",readbyte);
			model.addAttribute("filename","face.png");
		}
		else {
			model.addAttribute("imageFile", memberVO.getPhoto());
			model.addAttribute("filename",memberVO.getPhoto_name());
		}
	}

	
}
