package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.spring.vo.BoardVO;

@Mapper
public interface BoardMapper {
	public void insertBoard(BoardVO board);
	@Select("SELECT COUNT(*) FROm aboard")
	public int getBoardCount();
	public List<BoardVO> getBoardList(Map<String,Object> map);
	public BoardVO getBoard(int num);
	public void updateBoard(BoardVO board);
	public void deleteBoard(int num);
}
