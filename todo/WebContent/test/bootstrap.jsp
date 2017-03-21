<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
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
<style type="text/css">

#top {
	background-color: #31A8E7;
	height: 270px;
}

#headerText {
	display: inline-block;
	margin-top: 50px;
	font-size: 65px;
	color:white;
}
</style>
</head>
<body>
	<div class="navbar navbar-info">
		<div class="container">
			<div class="navbar-header">
				<a href="home.jsp" class="navbar-brand">부트스트랩</a>

			</div>
			<ul class="nav navbar-nav">
				<li><a href="">시작하기</a></li>
				<li><a href="">CSS</a></li>
				<li><a href="">콤포넌트</a></li>
				<li><a href="">자바스크립트</a></li>
				<li><a href="">맞춤화</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="">전시관</a></li>
				<li><a href="">블로그</a></li>
			</ul>
		</div>
	</div>
	<div id="header" class="container-fluid">
		<div id="top" class="row">
			<div class="container">
				<font id="headerText">CSS</font> 
				<p style="font-size:20px; color:white;">전반적인 CSS 환경, 스타일이 적용되고
					진보된 그리드 시스템과 확장가</p><p style="font-size:20px; color:white;">능한 클래스로 강화된 기본적인 HTML 요소들.</p>
			</div>
		</div>
	</div>
</body>
</html>