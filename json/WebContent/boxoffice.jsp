<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function() {
		$('#search-btn').click(function(event) {
			event.preventDefault();
			var searchDate = $('#search-date').val();
			if (searchDate){
				searchDate = searchDate.replace(/-/g, '');
				var xhr = new XMLHttpRequest();
				
				xhr.onreadystatechange = function() {
					
					if (xhr.readyState == 4 && xhr.status == 200){
						
							// 응답데이터가 JSON인 경우						 	
					/*   
						 var text = xhr.responseText;
						 var jsonText = JSON.parse(text);
						 var boxOfficeList = jsonText.boxOfficeResult.dailyBoxOfficeList;
						 
						 var htmlContent ="";
						 for (var i=0; i<boxOfficeList.length; i++) {
							 
							var movie = boxOfficeList[i];
							htmlContent += "<tr>"
							htmlContent += "<td>"+movie.rank+"</td>"
							htmlContent += "<td>"+movie.movieNm+"</td>"
							htmlContent += "<td>"+movie.openDt+"</td>"
							htmlContent += "<td>"+movie.salesShare+"</td>"
							htmlContent += "<td>"+movie.audiAcc+"</td>"
							htmlContent += "</tr>"
							
							$('tbody').html(htmlContent);
						}
					*/	
						//var xmlText = xhr.responseText;
						//var xmlDoc = $.parseXML(xmlText);
						
						var xmlDoc = xhr.responseXML;
						
						var htmlContent ="";
						$(xmlDoc).find('dailyBoxOffice').each(function(index,item) {
							var ranks = $(item).find('rank').text();
							var title = $(item).find('movieNm').text();
							var openDate = $(item).find('openDt').text();
							var salesShare = $(item).find('salesShare').text();
							var audiCnt = $(item).find('audiCnt').text();
							
							htmlContent += "<tr>";
							htmlContent += "<td>"+ranks+"</td>";
							htmlContent += "<td>"+title+"</td>";
							htmlContent += "<td>"+openDate+"</td>";
							htmlContent += "<td>"+salesShare+"</td>";
							htmlContent += "<td>"+audiCnt+" 명</td>";
							htmlContent += "</tr>";
							
							$('tbody').html(htmlContent);
							
						})
					}
				}
					
				xhr.open("get","boxoffice?date=" + searchDate);
				xhr.send(null);
			}
			
		})
	})
</script>

<title>sample</title>
</head>
<body>
	<div class="container">
		<h1>일일 박스오피스 조회</h1>
		
		<div class="row well">
			<form method="post" action="" class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-xs-1">날짜</label>
					<div class="col-xs-9">
						<input type="date" class="form-control" id="search-date"/>
					</div>
					<div class="col-xs-2">
						<button id="search-btn" class="btn btn-default">조회</button>
					</div>
				</div>
			</form>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>순위</th>
					<th>제목</th>
					<th>개봉일</th>
					<th>티켓 예매율</th>
					<th>누적관객수</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>