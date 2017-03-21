<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>JSP</title>
</head>
<body>
<%
	request.setAttribute("today", new Date());
%>
<div class="container"> 
	<h1> fmt 태그 라이브러리의 formatDate </h1>

	<p> 날짜 : <fmt:formatDate value="${today }"/> </p>
	<!-- 날짜 : 2017. 2. 17 -->
	
	<p> 날짜 : <fmt:formatDate value="${today }" pattern="yyyy.MM.dd"/> </p>
	<!-- 날짜 : 2017.02.17 -->
	
	<p> 날짜 : <fmt:formatDate value="${today }" pattern="yyyy년MM월dd일 EEEE"/> </p>
	<!-- 날짜 : 2017년02월17일 금요일 -->
	
	<p> 날짜 : <fmt:formatDate value="${today }" pattern="yyyy년MM월dd일 EEEE a hh:mm:ss"/> </p>
	<!-- 날짜 : 2017년02월17일 금요일 오전 09:53:04 -->
	
	<p> 날짜 : <fmt:formatDate value="${today }" type="time" /> </p>
	<!-- 날짜 : 오전 9:54:50 -->
	
	
</div>
</body>
</html>