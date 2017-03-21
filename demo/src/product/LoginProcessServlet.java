package product;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns="/loginprocess")
public class LoginProcessServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		
		try{
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			UserVO userVO = userDAO.getUserIdPwd(id, pwd);
			if (id.equals(userVO.getId()) && pwd.equals(userVO.getPwd())) {
				// 로그인이 되었을때.
				
				HttpSession session = req.getSession(true);
				System.out.println(session.getId());
				session.setAttribute("loginId", id);
				res.sendRedirect("login");
			}
			
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
	
	}
}
