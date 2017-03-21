package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.BookVO;
import vo.UserVO;

@WebServlet("/detail.hta")
public class BookDetailServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int detailNo = Integer.parseInt(req.getParameter("no"));
		BookDao dao = new BookDao();
		UserVO book = null;
		try {
			book = dao.getBookByno(detailNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("book", book);
		
		req.getRequestDispatcher("WEB-INF/views/bookDetail.jsp").forward(req, res);
	
	}
}
