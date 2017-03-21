package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><meta charset='utf-8'><title>로그인</title></head>");
		pw.println("<body>");
		pw.println("<h1>로그인</h1>");
		if (session == null) {
		pw.println("<form method='post' action='loginprocess'>");
		pw.println("아이디: <br/> <input type='text' name='id'/><br/>");
		pw.println("비밀번호: <br/> <input type='password' name='pwd'/><br/>");
		pw.println("<input type='submit' value='로그인'/>");
		pw.println("</form>");
		}else {
			String userid = (String)session.getAttribute("loginId");
			pw.println("<p>"+userid+"님 환영합니다.</p>");
			pw.println("<h1>과일 목록 게시판</h1>");
			pw.println("<table width='100%' border='1'>");
			pw.println("<tr>");
			pw.println("<th>번호</th><th>제목</th><th>과일 갯수</th><td>삭제</td>");
			pw.println("</tr>");
			ProductDAO dao = new ProductDAO();
			try {
				ArrayList<ProductVO> proList = dao.getAllProduct();
				for (ProductVO p :proList) {
					int no = p.getNo();
					String name = p.getName();
					int count = p.getProcount();
					pw.println("<tr>");
					pw.println("<td>"+no+"</td>");
					pw.println("<td><a href='detail.hta?pno="+no+"'>"+name+"</a></td>");
					pw.println("<td>"+count+"</td>");
					pw.println("<td><a href='del?pno="+no+"'>삭제</a></td>");
					pw.println("</tr>");
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
			
		}
		pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
