package demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Sample4Servlet
 */
@WebServlet(urlPatterns={"/sample4"}) //포스트 방식의 Sample 4
public class Sample4Servlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userId");
		String pwd = req.getParameter("userPwd");
		
		System.out.println("아이디: "+ id);
		System.out.println("비밀번호: "+ pwd);
	}
	
}
