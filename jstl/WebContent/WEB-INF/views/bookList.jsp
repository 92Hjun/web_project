<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>sample</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>책번호</th>
					<th>책이름</th>
					<th>책저자</th>
					<th>출판사</th>
					<th>책가격</th>
					<th>출판일</th>
				</tr>
			</thead>
			<tbody>
				<!-- 이네스트포문이랑 똑같음 bookList 에 있는것을 변수선언 해주는 코드 var 에 지정한 변수내부에 객체가 들어감. 
					 그거를 꺼내서 화면에 표시하는것.
				-->
				<c:forEach var="book" items="${bookList }">
					<tr>
						<td>${book.no }</td>
						<td><a href="detail.hta?no=${book.no }">${book.title }</a></td>
						<td>${book.author }</td>
						<td>${book.publisher }</td>
						<td>${book.price }</td>
						<td>${book.pubdate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>