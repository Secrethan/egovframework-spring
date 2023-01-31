package kr.spring.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.spring.board.dao.BoardMapper;
import kr.spring.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardmapper;
	
	@Override
	public void insertBoard(BoardVO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBoardCount() {
		
		return boardmapper.getBoardCount();
	}

	@Override
	public List<BoardVO> getBoardList(Map<String, Object> map) {
		return boardmapper.getBoardList(map);
	}

	@Override
	public BoardVO getBoard(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		
	}

}
