package kr.or.ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.json.service.ILprodService;
import kr.or.ddit.json.service.LprodServiceImpl;
import kr.or.ddit.vo.LprodVO;


@WebServlet("/lprodList.do")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		ILprodService service = LprodServiceImpl.getInstance();
		
		List<LprodVO> lprodList = service.getAllLprod();
				
		Gson gson = new Gson();
		
		String jsonData= gson.toJson(lprodList);
		
		PrintWriter out = response.getWriter();
		out.write(jsonData);
		response.flushBuffer();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
