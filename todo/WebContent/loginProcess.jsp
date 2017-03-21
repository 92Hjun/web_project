<%@page import="todo.UserVO"%>
<%@page import="util.MD5"%>
<%@page import="todo.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%	
	String id = request.getParameter("id");
	String pwd = MD5.hash(request.getParameter("pwd"));
	UserDAO dao = new UserDAO();
	UserVO user = dao.serchUserById(id);
	
	if (user == null) {
		response.sendRedirect("login.jsp?err=fail");
		return;
	}
	if (!pwd.equals(user.getUserpwd())) {
		response.sendRedirect("login.jsp?err=fail");
		return;
	}
	
	if (pwd.equals(user.getUserpwd())) {
		
		HttpSession session = request.getSession(true);
		session.setAttribute("loginUser", user);
		response.sendRedirect("main.jsp?pno=1");
		return;
		
	}
%>