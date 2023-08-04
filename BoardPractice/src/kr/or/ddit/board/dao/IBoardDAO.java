package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.vo.BoardVO;

public interface IBoardDAO {
	public List<BoardVO> selectBoardList();
	public int insertBoard(BoardVO boardVO);
	public BoardVO selectBoard(int bo_no);
	public int updateBoard(BoardVO boardVO);
	public void incrementHit(int bo_no);
	public int deleteBoard(int bo_no);
}
