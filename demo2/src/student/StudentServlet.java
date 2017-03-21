package student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			StudentDAO dao = new StudentDAO();
		try {
			req.setCharacterEncoding("utf-8");
			String name = req.getParameter("name");
			String major = req.getParameter("major");
			int grade = Integer.parseInt(req.getParameter("grade"));
			String phone = req.getParameter("phone");
			dao.addStudent(name, major, grade, phone);
			
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	
	}
}
