<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>company name</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=News+Cycle:400,700" />

<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@include file="nav.jsp"%>
	<div id="slider">
		<div class="w3-content w3-display-container" style="max-width: 1200px">
			<img class="mySlides" src="img1.jpg" style="width: 100%"> 
			<img class="mySlides" src="img2.jpg" style="width: 100%"> 
			<img class="mySlides" src="img3.jpg" style="width: 100%">
			<div
				class="w3-center w3-section w3-large w3-text-white w3-display-bottommiddle"
				style="width: 100%">
				<div class="w3-left w3-padding-left w3-hover-text-khaki"
					onclick="plusDivs(-1)">&#10094;</div>
				<div class="w3-right w3-padding-right w3-hover-text-khaki"
					onclick="plusDivs(1)">&#10095;</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<a href="#">
							500 x 200
						</a>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<a href="#">
							500 x 200
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="panel panel-default">
					<div class="panel-body">
						<a href="#">
							1100 x 200
						</a>
					</div>
				</div>
		</div>
	</div>
	<br/>
	<br/>
	<br/>
	<hr>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="panel panel-default">
					<div class="panel-heading">상품이름</div>
					<div class="panel-body">
						<a href="#"> <img alt="tshirt" src="itemImage/first_shirt.jpg">
						</a>
					</div>
					<div class="panel-footer">상품설명</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-default">
					<div class="panel-heading">상품이름</div>
					<div class="panel-body">
						<a href="#"> 
						</a>
					</div>
					<div class="panel-footer">상품설명</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-default">
					<div class="panel-heading">상품이름</div>
					<div class="panel-body">
						<a href="#">
						</a>
					</div>
					<div class="panel-footer">상품설명</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-default">
					<div class="panel-heading">상품이름</div>
					<div class="panel-body">
						<a href="#">
						</a>
					</div>
					<div class="panel-footer">상품설명</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="panel panel-default">
					<div class="panel-heading">상품이름</div>
					<div class="panel-body">
						<a href="#">
						</a>
					</div>
					<div class="panel-footer">상품설명</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-default">
					<div class="panel-heading">상품이름</div>
					<div class="panel-body">
						<a href="#">
						</a>
					</div>
					<div class="panel-footer">상품설명</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-default">
					<div class="panel-heading">상품이름</div>
					<div class="panel-body">
						<a href="#">
						</a>
					</div>
					<div class="panel-footer">상품설명</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-default">
					<div class="panel-heading">상품이름</div>
					<div class="panel-body">
						<a href="#">
						</a>
					</div>
					<div class="panel-footer">상품설명</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="panel panel-default">
					<div class="panel-heading">상품이름</div>
					<div class="panel-body">
						<a href="#">
						</a>
					</div>
					<div class="panel-footer">상품설명</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-default">
					<div class="panel-heading">상품이름</div>
					<div class="panel-body">
						<a href="#">
						</a>
					</div>
					<div class="panel-footer">상품설명</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-default">
					<div class="panel-heading">상품이름</div>
					<div class="panel-body">
						<a href="#">
						</a>
					</div>
					<div class="panel-footer">상품설명</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-default">
					<div class="panel-heading">상품이름</div>
					<div class="panel-body">
						<a href="#">
						</a>
					</div>
					<div class="panel-footer">상품설명</div>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<div class="row text-center">
		<div class="col-md-4">
			<p><img alt="icon" src="ui.jpg">Customer</p>
			<dl>
				<dd><h4>0000-0000</h4></dd>
				<dd>OPEN am9 ~ pm5</dd>
				<dd>Lunch pm12 ~ pm1</dd>
				<dd>토,일요일,공휴일 휴무</dd>
			</dl>
		</div>
		<div class="col-md-4">
			<p><img alt="icon" src="ui.jpg">FriendShip</p>
			<dl>
				<dd><h4>0000-0000</h4></dd>
				<dd>aaaaaa@naver.com</dd>
				<dd>companyName_offical</dd>
				<dd>대량문의 단체주문</dd>
			</dl>
		</div>
		<div class="col-md-4">
			<p><img alt="icon" src="ui.jpg">Delivery</p>
			<dl>
				<dd><small>반품주소</small></dd>
				<dd>서울특별시 종로구 봉익동 디아망 4층</dd>
			</dl>
		</div>
	</div>
	<hr>
	<%@include file="footer.jsp"%>

</body>

<script type="text/javascript">
	var slideIndex = 1;
	showDivs(slideIndex);

	function plusDivs(n) {
		showDivs(slideIndex += n);
	}

	function currentDiv(n) {
		showDivs(slideIndex = n);
	}

	function showDivs(n) {
		var i;
		var x = document.getElementsByClassName("mySlides");
		var dots = document.getElementsByClassName("demo");
		if (n > x.length) {
			slideIndex = 1
		}
		if (n < 1) {
			slideIndex = x.length
		}
		for (i = 0; i < x.length; i++) {
			x[i].style.display = "none";
		}
		for (i = 0; i < dots.length; i++) {
			dots[i].className = dots[i].className.replace(" w3-white", "");
		}
		x[slideIndex - 1].style.display = "block";
	}
</script>

</html>
