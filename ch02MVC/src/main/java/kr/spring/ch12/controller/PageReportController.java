package kr.spring.ch12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageReportController {
	@RequestMapping("/pageJsonReport.do")
	@ResponseBody //list,map반환 시 자동으로 Json으로 변환 (Jackson 라이브러리가 추가되어 있어야함)
	public List<PageRank> jsonReport(){
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		
		pageRanks.add(new PageRank(1,"/board/list.do"));
		pageRanks.add(new PageRank(2,"/board/detail.do"));
		pageRanks.add(new PageRank(3,"/board/write.do"));
		pageRanks.add(new PageRank(4,"/board/update.do"));
		
		
		return pageRanks; 
	}
}
