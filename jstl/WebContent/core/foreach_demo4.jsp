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
 <div class="text-center">
	<h1> Core 태그 라이브러리의 ForEach 태그 </h1>
	
	<table class="table table-bordered">
		<tr>
			<th> index</th> <!-- 0부터 시작 -->
			<th> count</th> <!-- 1부터 시작 -->
			<th> first</th> <!-- 첫번째인지 확인 - 결과는 true , false -->
			<th> last </th> <!-- 마지막인지 확인 - 결과는 true , false -->
			<th> 이름 </th>
		</tr>
		<c:forEach var="name" items="${names }" varStatus="status">
		<tr>
			<th> ${status.index } </th>
			<th> ${status.count } </th>
			<th> ${status.first } </th>
			<th> ${status.last } </th>
			<th> 
				<c:if test="${status.first }">
					<h1> ${name } </h1>
				</c:if>
				<c:if test="${not status.first }">
					${name }
				</c:if>
			</th>
		</tr>
		</c:forEach>
	</table>
 </div>
</div>
</body>
</html>