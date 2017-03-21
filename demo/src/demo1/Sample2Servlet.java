package demo1;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
			// url에 입력할 패턴을 지정해준다.
@WebServlet(urlPatterns={"/sample2"})
public class Sample2Servlet extends HttpServlet{
	@Override			// 리퀘스트 객체가 생성되서 전달한다.
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Sample 2 Servlet의 doget() 메소드 실행...");
		// Requst에 getparameter메소드를 활용하면 html태그에 입력되어있는값, 입력된값을 얻어올수있다.
		String id = req.getParameter("id");
		System.out.println("request ID: "+id);
	}
}
