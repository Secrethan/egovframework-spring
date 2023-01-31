package kr.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.service.BoardService;
import kr.spring.util.PagingUtil;
import kr.spring.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	//자바빈 초기화
	@ModelAttribute
	public BoardVO initCommand() {
		return new BoardVO();
	}
	//context root 또는 context path 연결
	@RequestMapping("/")
	public String main() {
		return "redirect:list.do";
	}
	
	@RequestMapping("/list.do")
	public ModelAndView getList(@RequestParam(value="pageNum", defaultValue="1")int currentPage) {
		
		//총 레코드 수
		int count = boardService.getBoardCount();
		
		//페이지 처리 
		PagingUtil page = new PagingUtil(currentPage,count,10,10,"list.do");
		
		//목록 호출
		List<BoardVO> list = null;
		if(count > 0) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("start", page.getStartRow());
			map.put("end", page.getEndRow());
			
			list = boardService.getBoardList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		//뷰 이름 설정 
		mav.setViewName("selectList");
		//데이터 저장
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("page",page.getPage());
		return mav;
	}
}
