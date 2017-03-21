<%@page import="dao.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ include file="loginCheck.jsp" %> <%-- include 지시자. --%>
<%
	int cartNo = Integer.parseInt(request.getParameter("cno"));
	ItemDAO dao = new ItemDAO();
	dao.deleteCartItemByNo(cartNo);
	
	response.sendRedirect("cart.jsp");
%>