package demo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.java2d.pipe.OutlineTextRenderer;

/**
 * Servlet implementation class Sample7Servlet
 */
@WebServlet(urlPatterns={"/sample7"})
public class Sample7Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String pubName = req.getParameter("pub_name");
		BookDAO dao = new BookDAO();
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>조회된 책정보</title></head>");
		out.println("<body>");
		out.println("<h1>검색 결과</h1>");
		out.println("<ul>");
		try {
			ArrayList<BookVO> bookList =dao.SerchBook(pubName);
			for(BookVO b : bookList) {
				String title = b.getTitle();
				System.out.println(title);
				String author = b.getAuthor();
				out.println("<li>"+title+"("+author+")</li>");
			}
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		
	
	}
}
