package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model2.Controller;
import vo.UserVO;

public class ListController implements Controller{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		UserDAO dao = new UserDAO();
		List<UserVO> userList =  dao.getAllUsers();
		
		req.setAttribute("users", userList);
		
		return "forward:list.jsp";
		
	}
	
}
