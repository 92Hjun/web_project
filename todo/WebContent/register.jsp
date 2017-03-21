<%@page import="todo.TodoDAO"%>
<%@page import="todo.TodoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%
	request.setCharacterEncoding("utf-8");

	TodoVO todo = new TodoVO();
	todo.setCategory(request.getParameter("category"));
	todo.setTitle(request.getParameter("title"));
	todo.setDescription(request.getParameter("description"));
	todo.setLocation(request.getParameter("location"));
	todo.setDate(request.getParameter("day"));
	
	TodoDAO dao = new TodoDAO();
	dao.addToo(todo);
	
	response.sendRedirect("main.jsp?pno=1");
%>