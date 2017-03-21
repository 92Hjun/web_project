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
	<h1> Core 태그 라이브러리의 Out 태그 </h1>
	<h1><c:out value="${address }" /> </h1>
	
	
<!-- 	c:out 은 XXS 공격을 방어해줍니다. -->	
	<h1> ${memo } </h1>
	<h1><c:out value="${memo }" /> </h1>
	
	<h1> &lt;html&gt; 배우기 </h1>
	
</body>
</html>