package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SerchStudent
 */
@WebServlet(urlPatterns={"/SerchStudent"})
public class SerchStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		int stuNo = Integer.parseInt(req.getParameter("stuNo"));
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head><title>조회된 학생 정보</title></head>");
		pw.println("<body>");
		pw.println("<h1>검색 결과</h1><br/>");
		pw.println("<ul>");
		try {
			ArrayList<StudentVo> studentList = dao.serchStudentByGrade(stuNo);
			
			for (StudentVo s :studentList) {
				int no = s.getNo();
				String name = s.getName();
				String major = s.getMajor();
				int grade = s.getGrade();
				String phone = s.getPhone();
				pw.println("<li>학번 : "+no+" 이름: "+name+" 전공: "+major+" 학년: "+grade+" 전화번호: "+phone+"</li>");
			}
			
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		pw.println("</ul>");
		pw.println("</body");
		pw.println("</html>");
	}

}
