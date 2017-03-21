<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true" %>
    
<%
	request.setAttribute("score", 98);
	
	UserVO user1 = new UserVO(100000,"홍길동","hong","hong1234");
	request.setAttribute("user1", user1);
	UserVO user2 = new UserVO(110000,"이순신","lee","lee1234");
	request.setAttribute("user2", user2);

	request.getRequestDispatcher("if_demo2.jsp").forward(request, response);
%>

















