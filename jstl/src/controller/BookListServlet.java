package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import vo.UserVO;

@WebServlet("/books.hta")
public class BookListServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// 클라이언트 요청 처리
		// 클라이언트가 전달한 값( 쿼리스트림, 폼 입력값 ) 을 꺼내기
		// DAO를 활용해서 DB Access 작업 진행
		// 요청이 데이터조회인 경우 보여주는 경우는 "뷰"역할을 수행하는 JSP에 조회된 데이터 전달
		// 요청객체(HttpServletRequest)에 속성으로 전달할 데이터 저장하기
		// 요청을 이동시키기
		// 저장소에 대한 Insert/Update/Delete 요청 -> redirect 이동
		// 저장소에 대한 Select 요청 --> forward 이동
		
		BookDao dao = new BookDao();
		ArrayList<UserVO> uservo;
		try {
			uservo = dao.getAllUser();
		
		req.setAttribute("user", uservo);
		
		req.getRequestDispatcher("WEB-INF/views/books.jsp").forward(req, res);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
