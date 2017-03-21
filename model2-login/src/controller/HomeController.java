package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.Controller;

public class HomeController implements Controller{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "forward:home.jsp";
	}
	
}
