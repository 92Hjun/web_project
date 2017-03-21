package demo1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sample5Servlet
 */
@WebServlet("/sample5")
public class Sample5Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// getParameter메소드를 호출하기 전에 해야된다.
		// 한번이라도 getParameter를 호출한다음에 setCharacterEncoding은 아무런 효력이없다.
		req.setCharacterEncoding("UTF-8");
		
		String gener = req.getParameter("gener");
		String memo = req.getParameter("memo");
		System.out.println(req.getParameter("house"));
		System.out.println(gener);
		System.out.println(memo);
		
	}
}
