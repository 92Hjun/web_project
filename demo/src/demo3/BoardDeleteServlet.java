package demo3;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet(urlPatterns="/del.hta")
public class BoardDeleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int bno = Integer.parseInt(req.getParameter("bno"));
		BoardDAO dao = new BoardDAO();
		try {
			dao.deleteBoardByNo(bno);
		}catch (SQLException e) {
			System.err.println(e.getMessage());
	}
	
		// 게시글 목록을 조회하는 url을 브라우저가 다시 요청하게 하는 응답을 보내기
	res.sendRedirect("list.hta");
		
	}
}
