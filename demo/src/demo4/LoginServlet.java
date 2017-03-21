package demo4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns="/login.hta")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// 요청객체가 가지고있는 sessionId에 해당 httpSession객체를 찾아서 반환한다.
		// 첫방문이거나 로그인하지 않은 사용자의 요청이라면 session의 값은 null이다.
		HttpSession session = req.getSession(false);
		
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><meta charset='utf-8'><title>로그인</title></head>");
		pw.println("<body>");
		
		pw.println("<h1>로그인</h1>");
		if (session == null) {
			
			String err = req.getParameter("err");
			if (err!=null) {
				if ("deny".equals(err)) {
					pw.println("<p style='color:red;'>로그인이 필요한 서비스입니다.</p>");
				}else if ("fail".equals(err)) {
					pw.println("<p style='color:red;'>아이디 혹은 비밀번호가 일치하지 않습니다.</p>");
					
				}
			}
			
		// 로그인이전
		pw.println("<form method='post' action='loginprocess.hta'>");
		pw.println("아이디: <br/> <input type='text' name='id'/><br/>");
		pw.println("비밀번호: <br/> <input type='password' name='pwd'/><br/>");
		pw.println("<input type='submit' value='로그인'/>");
		pw.println("</form>");
		}else {
			// 로그인한 사용자
			String userId = (String)session.getAttribute("loginedId");
			String username = (String)session.getAttribute("loginedname");
			String recentDate = (String)session.getAttribute("recentLogionedDate");
			pw.println("<p>"+username+"님 환영합니다.</p>");
			pw.println("<p>최근 로그인 날짜: "+recentDate+"</p>");
			pw.println("<p><a href='mail.hta'>메일</a></p>");
			pw.println("<p><a href='logout.hta'>로그아웃</a></p>");
		}
		pw.println("</body>");
		pw.println("</html>");
	
	}
}
