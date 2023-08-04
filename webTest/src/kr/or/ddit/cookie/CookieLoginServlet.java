package kr.or.ddit.cookie;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// userid, userpass, chkid 값 받기
		String userId = request.getParameter("userid");
		String pass = request.getParameter("userpass");
		String chkid = request.getParameter("chkid");		// 데이터가 체크가 안되었으면 값은 null
		
		// userId를 쿠키값으로 갖는 Cookie객체 생성(쿠키이름 : USERID)
		Cookie userCookie = new Cookie("USERID", userId);
		
		System.out.println("체크박스의 체크 여부 : " + chkid);
		
		// 체크박스의 체크 여부에 따라 쿠키 저장 확인
		if(chkid != null) {		// 체크박스가 체크 되었을 때
			response.addCookie(userCookie); 	// 쿠키저장
		} else {
			userCookie.setMaxAge(0);
			response.addCookie(userCookie); 	// 쿠키삭제
		}
		
		if("test".equals(userId) && "1234".equals(pass)) {	// 로그인성공
			response.sendRedirect(request.getContextPath()+"/cookie/cookieMain.jsp");
		} else {	// 로그인실패 → 다시 입력값 받아야 하므로
			response.sendRedirect(request.getContextPath()+"/cookie/cookieLogin.jsp");
		}
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
