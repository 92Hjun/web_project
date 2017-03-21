<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<h1> Core 태그 라이브러리의 if태그 </h1>

<p> 취득 점수 : ${score } </p>

<c:if test="${score >= 95 }">
	<p> 장학금 지급 대상입니다. </p>
</c:if>

<c:if test="${score < 95 }">
	<p> 장학금 지급 대상이 아닙니다. </p>
</c:if>
 
 <table class="table table-striped">
 	<thead>
 		<tr>
 			<th> 번호 </th>
 			<th> 이름 </th>
 			<th> 아이디 </th>
 			<th> 비번 </th>
 		</tr>
 	</thead>
 	<tbody>
		<tr>
 			<th><fmt:formatNumber value="${user1.no }" type="number" /> 번 </th>
 			<th> ${user1.name } </th>
 			<th> ${user1.id } </th>
 			<th> ${user1.pw } </th>
		</tr>
		<tr>
 			<th><fmt:formatNumber value="${user2.no }" type="number" /> 번 </th>
 			<th> ${user2.name } </th>
 			<th> ${user2.id } </th>
 			<th> ${user2.pw } </th>
		</tr>
 	</tbody>
 </table>
</body>
</html>