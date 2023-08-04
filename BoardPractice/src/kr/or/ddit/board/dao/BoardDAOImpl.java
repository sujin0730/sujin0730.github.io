package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.BoardVO;

public class BoardDAOImpl implements IBoardDAO {
	// 싱글턴 적용
	private BoardDAOImpl() {}
	private static BoardDAOImpl dao;
	public static BoardDAOImpl getInstance() {
		if(dao == null) dao = new BoardDAOImpl();
		return dao;
	}
	@Override
	public List<BoardVO> selectBoardList() {
		SqlSession session = null;
		List<BoardVO> boardList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			boardList = session.selectList("Board.selectBoardList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return boardList;
	}
	@Override
	public int insertBoard(BoardVO boardVO) {
		SqlSession session = null;
		int cnt = 0;	// 게시글 등록 후 받을 결과 상태 값
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("Board.insertBoard", boardVO);
			if(cnt > 0) session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return cnt;
	}
	@Override
	public BoardVO selectBoard(int bo_no) {
		SqlSession session = null;
		BoardVO boardVO = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			boardVO = session.selectOne("Board.selectBoard", bo_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return boardVO;
	}
	
	@Override
	public int updateBoard(BoardVO boardVO) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("Board.updateBoard", boardVO);
			if(cnt > 0) {
				session.commit();
			}
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return cnt;
	}
	@Override
	public void incrementHit(int bo_no) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("Board.incrementHit", bo_no);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	@Override
	public int deleteBoard(int bo_no) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.delete("Board.deleteBoard", bo_no);
			if(cnt > 0) {	// 삭제 완료
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return cnt;
	}
}



















