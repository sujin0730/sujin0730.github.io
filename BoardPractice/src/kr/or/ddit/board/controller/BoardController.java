package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

public class BoardController {
	// 입력을 위한 객체
	private Scanner scan;
	
	// 서비스 객체로 요청을 보내기 위한 서비스 객체
	private IBoardService service;
	
	// 기본 생성자
	public BoardController() {
		// 초기화
		scan = new Scanner(System.in);
		service = BoardServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		new BoardController().start();
	}
	
	// 게시판 시작
	public void start() {
		while(true) {
			// 리턴되서 돌아오는 int값은 선택된 메뉴 값
			int input = boardListView();	// 목록 데이터를 계속 조회(목록 띄우기)
			
			switch (input) {
			case 1:
				// 게시글 등록
				insertBoard();
				break;
			case 2:
				// 게시글 상세보기
				selectBoard();
				break;
			case 0:
				// 시스템 종료
				System.out.println();
				System.out.println("게시판 프로그램 종료");
				System.exit(0);
				break;
			default:
				System.out.println("메뉴를 잘못 선택하였습니다. 다시 입력바랍니다.");
			}
		}
	}
	
	public int boardListView() {
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println(" 번호          제 목                    작성자          조회수");
		System.out.println("---------------------------------------------------------------");
		
		List<BoardVO> boardList = service.selectBoardList();	// 게시판 목록 조회
		if(boardList == null || boardList.size() == 0) {
			System.out.println("조회하실 게시글이 존재하지 않습니다.");
		}else {
			for(BoardVO board : boardList) {
				System.out.println(
					board.getBo_no() + "\t" + 
					board.getBo_title() + "\t" +
					board.getBo_writer() + "\t" +
					board.getBo_hit() + "\t");
			}
		}
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("1.등록    2.게시글보기    0.종료");
		System.out.print("메뉴 선택 >> ");
		return scan.nextInt();
	}
	
	public void insertBoard() {
		System.out.println();
		scan.nextLine();	// 현상 입력 버퍼 비우기
		System.out.println(":::::::::::: 게시글 작성");
		System.out.print("- 제목 : ");
		String title = scan.nextLine();	// 제목 입력후 변수에 입력
		
		System.out.print("- 작성자 :");
		String writer = scan.nextLine();	// 작성자 입력 후 변수에 입력
		
		System.out.println("- 내용 : ");
		String content = scan.nextLine();	// 내용 입력 후 변수에 입력
		
		// 위에서 입력받은 총 3개의 데이터를 게시판 공간에 해당하는 
		// BoardVO 클래스 객체에 집어 넣는다.
		BoardVO boardVO = new BoardVO();
		boardVO.setBo_title(title);
		boardVO.setBo_writer(writer);
		boardVO.setBo_content(content);
		
		int status = service.insertBoard(boardVO);
		if(status > 0) {	// 등록 성공
			System.out.println("::: 게시글 등록 완료!");
		}else {				// 등록 실패
			System.err.println("::: 게시글 등록 실패!");
		}
	}
	
	public void selectBoard() {
		System.out.println();
		System.out.println("조회하실 게시글 번호를 입력해주세요.");
		System.out.print("번호 입력 >> ");
		int bo_no = scan.nextInt();
		
		BoardVO boardVO = service.selectBoard(bo_no);
		
		if(boardVO == null) {
			System.out.println(bo_no + "번의 게시글이 존재하지 않습니다.");
			return;
		}
		
		System.out.println();
		System.out.println(bo_no + "번 글 내용:::");
		System.out.println("----------------------------------------");
		System.out.println("번호 : " + boardVO.getBo_no());
		System.out.println("제목 : " + boardVO.getBo_title());
		System.out.println("작성자 : " + boardVO.getBo_writer());
		System.out.println("내용 : " + boardVO.getBo_content());
		System.out.println("조회수 : " + boardVO.getBo_hit());
		System.out.println("----------------------------------------");
		System.out.println("1.수정  2.삭제  3.목록");
		System.out.print("메뉴 선택 >>");
		int input = scan.nextInt();
		
		switch (input) {
		case 1:
			updateBoard(bo_no);
			break;
		case 2:
			deleteBoard(bo_no);
			break;
		case 3:
			return;
		}
	}
	
	// 게시글 수정
	public void updateBoard(int bo_no) {
		System.out.println();
		scan.nextLine();
		
		System.out.println(":::::::::: " + bo_no + "글을 수정합니다.");
		System.out.print("제목 : ");
		String title = scan.nextLine();
		
		System.out.print("내용 : ");
		String content = scan.nextLine();
		
		// 수정하기위한 데이터 셋팅
		BoardVO boardVO = new BoardVO();
		boardVO.setBo_no(bo_no);
		boardVO.setBo_title(title);
		boardVO.setBo_content(content);
		
 		int status = service.updateBoard(boardVO);
 		
 		if(status > 0) {	// 수정 성공
 			System.out.println(bo_no + "번 글 수정 완료!");
 		}else {				// 수정 실패
 			System.out.println(bo_no + "번 글 수정 실패!");
 		}
		
	}
	
	public void deleteBoard(int bo_no) {
		System.out.println();
		int status = service.deleteBoard(bo_no);
		if(status > 0) {
			System.out.println("::: 게시글 삭제 완료!");
		}else{
			System.out.println("::: 게시글 삭제 실패!");
		}
	}
	
}
















