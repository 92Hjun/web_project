package demo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sample6Servlet
 */
@WebServlet("/sample6")
public class Sample6Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		int price = Integer.parseInt(req.getParameter("price"));
		String date = req.getParameter("date");
		
		BookDAO dao = new BookDAO();
		String message = "";
		try{
			dao.addBook(title, author, publisher, price, date);
			message = "책 등록이 완료되었습니다.";
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			message = "책 등록중 오류가 발생하였습니다.";
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("<html>"
				+ "<head><title>결과 안내</title></head>"
				+ "<body>"
				+ "<h1>새 책 등록결과</h1>"
				+ "<p>"+message+"</p>"
				+ "</body>"
				+ "</html>");
		
	}	

}
