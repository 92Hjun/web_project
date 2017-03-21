package demo3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/list.hta")
public class BoardListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<head><meta charset='utf-8'><title>자유게시판</title></head>");
		out.println("<body>");
		out.println("<h1>자유게시판</h1>");
		out.println("<table width='100%' border='1'>");
		out.println("<tr>");
		out.println("<th>번호</th><th>제목</th><th>작성일</th><td>삭제</td>");
		out.println("</tr>");
		
		BoardDAO dao = new BoardDAO();
		try {
			ArrayList<BoardVO> boardList = dao.getAllBoards();
			for (BoardVO b : boardList) {
				int no = b.getNo();
				String title = b.getTitle();
				Date date = b.getRegdate();
				
				out.println("<tr>");
				out.println("<td>"+no+"</td>");
				out.println("<td><a href='detail.hta?bno="+no+"'>"+title+"</a></td>");
				out.println("<td>"+date+"</td>");
				out.println("<td><a href='del.hta?bno="+no+"'>삭제</a></td>");
				out.println("</tr>");
			}
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		out.println("</table>");
		out.println("<p><a href='form.hta'>글쓰기</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}
