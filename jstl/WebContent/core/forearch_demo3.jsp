<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true" %>

<%
	String[] names = {"A","B","C","D","E","F","I"};
	request.setAttribute("names", names);
	
	request.getRequestDispatcher("foreach_demo4.jsp").forward(request, response);
%>



