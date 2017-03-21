<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1>홈</h1>
		<c:choose>
			<c:when test="${empty LOGINED_USER}">
				<p><a href="form.hta">회원가입</a></p>
				<p><a href="loginform.hta">로그인</a></p>
			</c:when>
			<c:when test="${not empty LOGINED_USER}">
				<p>${LOGINED_USER.name }님 환영합니다</p>
				<p><a href="myinfo.hta">내 정보보기</a></p>
				<p><a href="logout.hta">로그아웃</a></p>
			</c:when>
		</c:choose>
	</div>
</body>
</html>