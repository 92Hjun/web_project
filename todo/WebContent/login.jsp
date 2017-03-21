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

	<style type="text/css">
		#grid{
			position: absolute;
			margin-top: 19%;
			margin-left: 380px;
		}
		#navi{
			position: absolute;
		}
		label {
			margin-left:15px;
			display: inline-block; width: 121px;
		}
		button{
			margin-left: 250px;
		}
	</style>
	
</head>
<body>
	<div id="grid" class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h1 class="text-center"> 로그인</h1>
					</div>
					<div class="panel-body">
						<form method="post" action="loginProcess.jsp">
							<div class="form-group">
								<p>
									<label>아이디</label> <input type="text" name="id"/>
								</p>
							</div>
							<div class="form-group">
								<p>
									<label>비밀번호</label> <input type="password" name="pwd"/>
								</p>
							</div>	
							<div class="form-group">
								<button type="submit" class="btn btn-info btn-xs">로그인</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<img alt="background" src="background.jpg">
</body>
</html>