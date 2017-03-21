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

	<h1>EL 의 연산자</h1>
	
	<h2>산술 연산자, 비교 연산자, 논리 연산자 ...</h2>
	
	<p>국어점수 ${kor }</p>
	<p>수학점수 ${math }</p>
	<p>영어점수 ${eng }</p>
	
	<p>총점 ${kor + math + eng }</p>
	<p>평균 ${(kor + math + eng) div 3 }</p>
	
	
	<p>국어점수 과락여부 ${kor < 40 }</p>
	<p>국어점수 과락여부 ${kor lt 40 }</p>
	
	<p>전 과목이 80점 이상인가? ${kor >= 80 && eng >= 80 && math >= 80 }</p>
	<p>전 과목이 80점 이상인가? ${kor ge 80 and eng ge 80 and math >= 80 }</p>
	
	<h2>empty 연산자</h2>
	
	<p>개봉영화 정보 ${movies }</p>
	
	<p>개봉영화 정보가 비어있는가? ${empty movies }</p>
	
	
	
	
</body>
</html>