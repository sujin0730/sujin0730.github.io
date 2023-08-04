package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDAOImpl;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	// 서비스에서 DAO를 호출하기 위한 객체 선언
	private IBoardDAO dao;
	// 싱글턴 패턴 설정
	private static BoardServiceImpl service;
	
	private BoardServiceImpl() {
		dao = BoardDAOImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}

	@Override
	public List<BoardVO> selectBoardList() {
		return dao.selectBoardList();
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return dao.insertBoard(boardVO);
	}

	@Override
	public BoardVO selectBoard(int bo_no) {
		dao.incrementHit(bo_no);	// 게시글 조회수 증가
		return dao.selectBoard(bo_no);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return dao.updateBoard(boardVO);
	}

	@Override
	public int deleteBoard(int bo_no) {
		return dao.deleteBoard(bo_no);
	}
}
















