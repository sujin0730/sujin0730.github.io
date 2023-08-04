package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// PrintWriter out = response.getWriter();
		
		String userid = request.getParameter("userid");
		String pass = request.getParameter("userpass");
		
		HttpSession session = request.getSession();
		
		if("admin".equals(userid) && "1234".equals(pass)) {
			session.setAttribute("LOGINID", userid);
		} 
		
		response.sendRedirect(request.getContextPath()+"/session/sessionLogin.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
