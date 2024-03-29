<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
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
		<h1>ServletContext 객체의 주요 메소드 연습</h1>
		
		<h3>초기화 파라미터값 읽어오기</h3>
		
		<%
			String name = application.getInitParameter("companyName");
			String email = application.getInitParameter("admin");
		%>
		<dl>
			<dt>회사명</dt><dd><%=name %></dd>
			<dt>관리자메일</dt><dd><%=email %></dd>
		</dl>
		
		<h3>realpath 조회하기</h3>
		<%	
			//실제 배포되서 실행되고있는 경로를 가져다준다.
			String realPath = application.getRealPath("upload");
		%>
		<p>upload의 실제경로: <%=realPath %></p>
	</div>
</body>
</html>
