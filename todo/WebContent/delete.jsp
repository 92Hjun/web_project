<%@page import="todo.TodoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%
	TodoDAO dao = new TodoDAO();
	int dno = Integer.parseInt(request.getParameter("dno"));
	dao.deleteTodoByNo(dno);
	int pno = Integer.parseInt(request.getParameter("pno"));
	response.sendRedirect("main.jsp?pno="+pno);
%>