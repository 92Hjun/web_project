<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>sample</title>
</head>
<body>
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<th>책제목</th>
				<td><c:out value="${book.title }" /></td>
			</tr>
			<tr>
				<th>책저자</th>
				<td><c:out value="${book.author }" /></td>
			</tr>
			<tr>
				<th>출판일</th>
				<td><c:out value="${book.pubdate }" /></td>
			</tr>
			<tr>
				<th>책가격</th>
				<td><c:out value="${book.price }" /></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td><c:out value="${book.publisher }" /></td>
			</tr>
		</table>
		
		<div class="text-right">
			<a href="books.hta" class="btn btn-default">목록으로 가기</a>
		</div>
	</div>
</body>
</html>