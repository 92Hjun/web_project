package demo3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/form.hta")
public class BoardFormServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<head><meta charset='utf-8'/><title>글쓰기 폼</title></head>");
		pw.println("<body>");
		pw.println("<h1>새글 등록폼</h1>");
		pw.println("<form method='post' action='add.hta'>");
		pw.println("글제목:<input type='text' name='title'/><br/>");
		pw.println("작성자:<input type='text' name='writer'><br/>");
		pw.println("글내용:<textarea name='contents' rows='3' cols='40'></textarea><br/>");
		pw.println("<button>등록</button>");
		pw.println("</form>");
		pw.println("<p><a href='list.hta'>돌아가기</a></p>");
		pw.println("</body>");
		pw.println("</html>");
	
	}
}
