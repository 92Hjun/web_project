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
 
 <div class="container">
 	<h1> 도서 빌려간 사람들 목록 </h1>
 		<table class="table table-striped">
 			<tr>
 				<td> NO </td>
 				<td> NAME </td>
 				<td> ID </td>
 				<td> PW </td>
 			</tr>
 			<c:forEach var="user" items="${user }">
 			<tr>
 				<td> ${user.no} </td>
 				<td> <a href="book.hta?no=${user.no }"> ${user.name} </a> </td>
 				<td> ${user.id} </td>
 				<td> ${user.pw} </td>
 			</tr>
 			</c:forEach>
 		</table>
 </div>
</body>
</html>