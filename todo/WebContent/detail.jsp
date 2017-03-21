<%@page import="todo.TodoVO"%>
<%@page import="todo.TodoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%
	TodoDAO dao = new TodoDAO();
	int detailNo = Integer.parseInt(request.getParameter("detailNo"));
	TodoVO todo = dao.detailTodo(detailNo);
	int pno = Integer.parseInt(request.getParameter("pno"));
%>
    
    
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
				<a href="form.jsp" class="navbar-brand">Todo App</a>
				
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">일정 상세정보</div>
					<div class="panel-body">
						<table class="table table-striped">
						<colgroup>
						<col width="20%">
						<col width="*">
						</colgroup>
							
						
								<tr>
									<th>종류</th><td><%=todo.getCategory() %></td>
								</tr>
								<tr>
									<th>제목</th><td><%=todo.getTitle() %></td>
								</tr>
								<tr>
									<th>내용</th><td><%=todo.getDescription() %></td>
								</tr>
								<tr>
									<th>장소</th><td><%=todo.getLocation() %></td>
								</tr>
								<tr>
									<th>일시</th><td><%=todo.getDate() %></td>
								</tr>
								<tr>
									<th>처리 완료 여부</th><td><%=todo.getCompleted() %></td>
								</tr>
						</table>
					</div>
					<div class="panel-footer text-right">
						
						<a href="main.jsp?pno=<%=pno %>" class="btn btn-default">목록보기</a>
					</div>
				</div>
			</div>
		</div>
	
	</div>
</body>
</html>