package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model2.Controller;
import vo.UserVO;

public class AddController implements Controller {
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		
		UserVO user = new UserVO();
		user.setId(id);
		user.setName(name);
		user.setPwd(pwd);
		user.setPhone(phone);
		user.setAddr(addr);
		
		UserDAO dao = new UserDAO();
		
		dao.addNewUser(user);
		
		return "redirect:list.hta";
	}
}
