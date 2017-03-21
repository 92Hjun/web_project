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
		<h1>${emp.name }의 사원 정보</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>사원번호</th>
					<th>사원명</th>
					<th>이메일</th>
					<th>소속부서</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${emp.id }</td>
					<td>${emp.name }</td>
					<td>${emp.email }</td>
					<td>${emp.dept }</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>