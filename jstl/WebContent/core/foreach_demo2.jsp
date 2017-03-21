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
	<h1> Core 태그라이브러리의 ForEach 태그 </h1>
	
<!-- 
	items : EL 표현식
	        반복처리할 대상이 되는 배열 혹은 컬렉션을 지정
	       
	var : 변수명
	      반복처리중인 항목이 저장된다   
-->
 	
 	<h2> 단순한 값을 가진 배열 </h2>
 	<c:forEach var="a" items="${names }">
 		<p>${a } </p>
 	</c:forEach>
 	
 	
 	<h2> 객체의 값을 가진 콜렉션</h2>
 	<c:forEach var="b" items="${user }">
 		<p>번호 : ${b.no } , 이름 : ${b.name } , 아이디 : ${b.id } , 비밀번호 : ${b.pw }</p>
 	</c:forEach>
 	
 
</body>
</html>