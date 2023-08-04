package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// POST 방식으로 전달되는 문자의 인코딩
		request.setCharacterEncoding("utf-8");

		// Request객체.getParameter("파라미터명") → 해당 파라미터에 설정된 '값'을 가져온다.
		//		 							 → 가져오는 '값'의 자료형은 'String'이다.
		String strNum1 = request.getParameter("num1");
		String op = request.getParameter("op");
		String strNum2 = request.getParameter("num2");
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		double result=0;	// 계산 결과가 저장될 변수 선언
		boolean calcOK = true;		// 계산의 성공여부를 나타내는 변수(true(성공), false(실패))
		
		switch(op) {
		case "+":
			result=num1+num2;
			break;
		case "-":
			result=num1-num2;
			break;
		case "*":
			result=num1*num2;
			break;
		case "/":
			if(num2==0) {
				calcOK = false;
			} else {
				result=(double)num1/num2;
			}
			break;
		case "%":
			if(num2==0) {
				calcOK = false;
			} else {
				result=(double)num1%num2;
			}
			break;
		}
		
		// 계산결과는 응답으로 보내줌
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'><title>계산기</title></head>");
		out.println("<body>");
		
		out.println("<h3>계산 결과</h3><hr><p>");
		out.printf("%d %s %d = ", num1, op, num2);
		if(calcOK) {	// 계산성공
			out.println(result+"<br>");
		} else {
			out.println("계산 불능(0으로 나누기)<br>");
		}
		
		
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
