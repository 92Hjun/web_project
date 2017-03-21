<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%

	request.setAttribute("kor", 60);
	request.setAttribute("eng", 80);
	request.setAttribute("math", 100);
	
	/*
	
		ArrayList<String> movies = new ArrayList<>();
		movies.add("조작된 도시");
		request.setAttribute("movies", movies);
	
	*/
	
	request.getRequestDispatcher("demo2.jsp").forward(request, response);

%>