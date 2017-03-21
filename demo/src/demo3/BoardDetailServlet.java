package demo3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/detail.hta")
public class BoardDetailServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 목록페이지에서 클릭한 게시글의 글번호 알아내기
		res.setContentType("text/html;charset=utf-8");
		BoardDAO dao = new BoardDAO();

		PrintWriter pw = res.getWriter();
		
		pw.println("<html>");
		pw.println("<head><meta charset='utf-8'/><title>상세 글 보기</title></head>");
		pw.println("<body>");
		pw.println("<h1>상세 글 보기</h1>");
		try {
			BoardVO board = dao.getBoardByNo(Integer.parseInt(req.getParameter("bno")));
			if (board != null) {
				pw.println("<dl>");
				pw.println("<dt>번호</dt><dd>"+board.getNo()+"</dd>");
				pw.println("<dt>제목</dt><dd>"+board.getTitle()+"</dd>");
				pw.println("<dt>작성자</dt><dd>"+board.getWriter()+"</dd>");
				pw.println("<dt>추천수</dt><dd>"+board.getLikes()+"</dd>");
				pw.println("<dt>내용</dt><dd>"+board.getContents()+"</dd>");
				pw.println("<dt>등록일</dt><dd>"+board.getRegdate()+"</dd>");
				pw.println("<dt>ip주소</dt><dd>"+board.getIp()+"</dd>");
				pw.println("</dl>");
			}else {
				pw.println("<h1>테이블 정보가 존재하지 않습니다.</h1>");
			}
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		pw.println("<p><a href='list.hta'>목록으로 가기</a></p>");
		pw.println("</body>");
		pw.println("</html>");
		
	
	}
}
