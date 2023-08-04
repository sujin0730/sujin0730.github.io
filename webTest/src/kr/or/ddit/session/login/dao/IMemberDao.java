package kr.or.ddit.session.login.dao;

import java.util.List;

import kr.or.ddit.session.login.vo.MemberVO;
import kr.or.ddit.vo.LprodVO;

public interface IMemberDao {
	
	/**
	 * 회원ID와 패스워드가 저장된 MemberVO객체를 파라미터로 받아서
	 * 해당 회원을 검색하여 반환하는 메서드
	 * 
	 * @param memVo 검색할 회원ID와 패스워드가 저장된 MemberVO객체
	 * @return 검색결과가 저장된 MemberVO객체(검색된 데이터가 없으면 null반환)
	 */
	public MemberVO getMemberLogin(MemberVO memVo);


}
