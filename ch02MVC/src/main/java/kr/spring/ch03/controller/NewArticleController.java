package kr.spring.ch03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.spring.ch03.service.ArticleService;
import kr.spring.ch03.vo.NewArticleVO;

@Controller
public class NewArticleController {
	@Autowired //set메소드 생략 가능
	private ArticleService articleService;
 
	/*public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	*/

	//요청 URL과 실행 메소드를 연결 
	//GET 요청이 들어올 때 호출 
	@GetMapping("/article/newArticle.do")
	public String form() {
		return "article/newArticleForm";
	}
	/*
	 * @ModelAttribute 어노테이션을 이용해서 전송된 데이터 자바빈에 담기 
	 * 1. VO 생성 
	 * 2. 전송된 데이터를 VO에 저장
	 * 3. View에서 사용할 수 있도록 request에 VO 저장 
	 * 
	 * [형식]
	 * 1. @ModelAttribute(속성명) NewArticleVO vo
	 * 지정한 속성명으로 JSP(View)에서 request에 접근하여 VO를 호출함
	 * 
	 * 2. @ModelAttribute 생략
	 *    호출 메소드의 인자명만 명시 
	 *    ex) NewArticleVo vo
	 *    request에 저장되는 속성명은 클래스명의 첫글자가 소문자로 자동 저장됨  
	 */
	
	//POST 요청이 들어올 때 호출 
	@PostMapping("/article/newArticle.do")
	public String submit(@ModelAttribute("vo") NewArticleVO vo) {
			
		articleService.writeArticle(vo);
	
		return "article/newArticleSubmited";
	}
}
