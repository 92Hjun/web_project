<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" isErrorPage="true"%>
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
	<div class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="main.jsp?pno=1" class="navbar-brand">Todo App</a>
				
			</div>
			<ul class="nav navbar-nav pull-right">
				<li><a href="main.jsp?pno=1">홈</a></li>
				<li><a href="form.jsp">등록</a></li>
			</ul>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-danger">
					<div class="panel-heading text-center">오류 발생</div>
					<div class="panel-body">
						<div class="col-md-6">
							<img alt="err" src="err.jpg">
						</div>
						<div class="col-md-6">
							<h2 class="text-danger">오류가 발생하였습니다.</h2>
							<p class="text-danger">등록 입력 창에 모든 값을 입력해 주시기 바랍니다.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>