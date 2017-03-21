package demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sample3
 */
@WebServlet(urlPatterns={"/sample3"})
public class Sample3Sverblet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
						//input text타입 검색어 입력한것을 getparameter메소드를 실행해 검색 값을 얻어온다.
		String value = req.getParameter("keyword");
		System.out.println("전달받은 검색어: "+value);
		System.out.println("Sample 3 Servlet의 doGet메소드 실행");
	
	}

}
