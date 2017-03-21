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
	<h1>맛집</h1>
		종류: <select id="kind-box" onchange="getMenu()">
					<option value=""> -- 선택하세요 -- </option>
					<option value="kr">한식</option>
					<option value="ch">중식</option>
					<option value="jp">일식</option>
			  </select>
		메뉴: <select id="menu-box">
					<option> 종류를 먼저 선택하세요 </option>
			  </select>
	</div>
</body>

<script type="text/javascript">
	function getMenu() {
		
		// 선택한 종류 가져오기
		var kindMenu = document.getElementById('kind-box').value;
		
		if (kindMenu) {
			
			// xhr생성하기
			var xhr = new XMLHttpRequest();
			
			// xhr에 콜백함수 등록하기
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					// 서버가 보낸 응답데이터 처리하기
					var kind = xhr.responseText;
					var kindValue = kind.split(",");
					var html="";
					for (var i =0; i<kindValue.length; i++) {
						var menuBox = document.getElementById('menu-box');
						html += '<option value="'+kindValue[i]+'">'+kindValue[i]+'</option>';
					}
					
					menuBox.innerHTML = html;
					
				}
			}
			
			// xhr초기화하기
			xhr.open("GET", "menuItem.jsp?kind="+ kindMenu);
			
			
			// xhr 전송하기	
			xhr.send(null);
		}else {
			
			document.getElementById('menu-box').innerHTML = "<option> 종류를 먼저 선택하세요 </option>";
			
		}
		
	}
</script>
</html>