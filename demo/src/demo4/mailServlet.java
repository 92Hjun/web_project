package demo4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns="/mail.hta")
public class mailServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// 요청객체에 들어있는 세션아이디로 세션객체 찾기
		HttpSession session = req.getSession(false);
		
		if (session == null) {
			res.sendRedirect("login.hta?err=deny");
		}else {
			String userId = (String) session.getAttribute("loginedId");
			String userName = (String) session.getAttribute("loginedname");
			
			res.setContentType("text/html;charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head><meta charset='utf-8'><title>메일</title></head>");
			pw.println("<body>");
			pw.println("<h1>"+userName+"("+userId+")님의 메일 리스트</h1>");
			pw.println("<p>10개의 읽지 않은 메일이 존재합니다.</p>");
			
			pw.println("</body>");
			pw.println("</html>");
		}
	
	}
}
