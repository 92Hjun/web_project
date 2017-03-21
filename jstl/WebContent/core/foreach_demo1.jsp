<%@page import="vo.UserVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true" %>
 
<%
	String[] names = {"이순신", "홍길동", "김유신", "강감찬"};
	request.setAttribute("names", names);
	
	ArrayList<UserVO> user = new ArrayList<>();
	user.add(new UserVO(10,"홍길동1","hong1","hong12341"));
	user.add(new UserVO(11,"홍길동2","hong2","hong12342"));
	user.add(new UserVO(12,"홍길동3","hong3","hong12343"));
	user.add(new UserVO(13,"홍길동4","hong4","hong12344"));
	user.add(new UserVO(14,"홍길동5","hong5","hong12345"));
	request.setAttribute("user", user);
	
	request.getRequestDispatcher("foreach_demo2.jsp").forward(request, response);
%>