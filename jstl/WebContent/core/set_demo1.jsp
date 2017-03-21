<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
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
	UserVO user = new UserVO(10,"홍길동","hong","hong1234");
	request.setAttribute("user", user);
%>
	<div class="container">
		<h1> Core 태그 라이브러리 Set 태그 </h1>
		

	<!-- 	set으로 저장 -->
		<c:set var="name" value="홍길동" />
	<!-- 	불러내기 -->
		<p> ${name } </p>

	
	<!-- 	다른 표현식을 다른변수로 저장 -->
		<c:set var="owner" value="${name }" />
	<!--	불러내기 -->
		<p> ${owner } </p>
		
		
	<!-- 	객체를 변수로 저장 -->
		<c:set var="user01" value="${user }" />
	<!--	불러내기 -->
		<p> ${user01.name } </p>
		 
		
	<!-- 	대상의 프로퍼티를 변경함 -->
		<c:set target="${user01}" property="name" value="이순신" />
	<!-- 	변경된 프로퍼티로 출력됨 -->
		<p> ${user01.name } </p>
		
		
	</div>

 
</body>
</html>