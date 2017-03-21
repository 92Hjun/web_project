package demo3;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/add.hta")
public class BoardAddServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		// 클라이언트가 전달한 값 보내기
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String contents = req.getParameter("contents");
		// BoardVO 객체를 생성해서 값 담기
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContents(contents);
		vo.setIp(req.getRemoteAddr());
		String ip = vo.getIp();
		// BoardDAO의 저장하는 메소드에게 BoardVO객체 전달해서 DB에 저장시키기
		BoardDAO dao = new BoardDAO();
		try{
			dao.addBoard(title, writer, contents,ip);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// 목록을 볼수있는 url을 브라우저에게 응답으로 제공해서 게시글목록을 다시 요청하게 하기
		res.sendRedirect("list.hta");
	}
}
