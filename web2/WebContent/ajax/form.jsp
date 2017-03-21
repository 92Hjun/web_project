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
</head>
<body>
	<div class="container">
		<h1>회원가입 폼</h1>
		<form action="register.jsp" method="post">
			<div class="form-group">
				<label>아이디</label>
				<input type="text" class="form-control" id="user-id" name="userId" onkeyup="duplicateCheck()">
				<div id="resultBox"></div>
			</div>
			<div class="form-group">
				<label>이름</label>
				<input type="text" class="form-control" id="user-name" name="userName">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-default">제출</button>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">

	function duplicateCheck() {
		
		var userid = document.getElementById('user-id').value;
		
		// 1. XHR생성
		var xhr = new XMLHttpRequest(); // chrome, IE7+, Safari, Opera
		
		// 4.XHR에서 이벤트 발생시 실행될 콜백함수 등록하기
		xhr.onreadystatechange = function () {
			// console.log(xhr.readyState);
			if (xhr.readyState == 4 && xhr.status == 200) {
				var result = xhr.responseText;
				
				var box = document.getElementById('resultBox');
				if (result == 'Y') {
					
					box.innerHTML = "<p class='text-danger'>이미 사용중인 아이디 입니다.</p>";
					
				}else if(result == 'N') {
					
					box.innerHTML = "<p class='text-success'>사용 가능한 아이디 입니다.</p>";
					
				}
			}
		}
		
		
		// 2. XHR에게 요청 URL 저장하기
		xhr.open("GET", "check.jsp?userId=" + userid);
		
		// 3. 서버로 보내기
		xhr.send(null); // 포스트방식일때만 써준다.
		
	}
</script>
</html>