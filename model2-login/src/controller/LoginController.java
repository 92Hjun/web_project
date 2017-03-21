package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model2.Controller;
import vo.UserVO;

public class LoginController implements Controller{
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String userId = req.getParameter("userid");
		String userPwd = req.getParameter("userpwd");
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUserById(userId);
		
		if (user == null) {
			return "redirect:loginform.hta?err=fail";
		}
		if ( !user.getPwd().equals(userPwd)) {
			return "redirect:loginform.hta?err=fail";
		}
		
		HttpSession session = req.getSession(true);
		session.setAttribute("LOGINED_USER", user);
		
		// 로그인 상태로 컬럼의 값 변경하기.
		dao.changeUserStateY(userId);
		
		return "redirect:home.hta";
	}
}
