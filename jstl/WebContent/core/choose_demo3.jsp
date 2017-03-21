<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true" %>
 
<%
	request.setAttribute("grade", "실버");
	request.getRequestDispatcher("choose_demo4.jsp").forward(request, response);
%>
