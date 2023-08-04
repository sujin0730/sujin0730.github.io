package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.vo.BoardVO;

public interface IBoardService {
	public List<BoardVO> selectBoardList();
	public int insertBoard(BoardVO boardVO);
	public BoardVO selectBoard(int bo_no);
	public int updateBoard(BoardVO boardVO);
	public int deleteBoard(int bo_no);
}
