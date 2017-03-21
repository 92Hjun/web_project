<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true" %>

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
<fmt:bundle basename="bundle.message">
	<div class="container">
		<h1><fmt:message key="login.title"></fmt:message></h1>
			<form method="post" action="login.jsp">
				<div class="form-group">
					<label><fmt:message key="login.label.id"></fmt:message></label>
					<input type="text" class="form-control" name=userid placeholder="<fmt:message key="login.hint.id"></fmt:message>"/>
				</div>
				<div class="form-group">
					<label><fmt:message key="login.label.pwd"></fmt:message></label>
					<input type="password" class="form-control" name=userid placeholder="<fmt:message key="login.hint.pw"></fmt:message>"/>
				</div>
				<div class="form-group">
					<button class="btn btn-defalut pull-right"><fmt:message key="login.btn"></fmt:message></button>
				</div>
			</form>
	</div>
</fmt:bundle>
</body>
</html>