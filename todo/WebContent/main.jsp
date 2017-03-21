<%@page import="util.NumberUtil"%>
<%@page import="todo.TodoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="todo.TodoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%
	String category = request.getParameter("category");
	TodoDAO dao = new TodoDAO();
	
	
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
<%@include file="common/header.jsp"%>
<%

	final int ROWS_PER_PAGE = 10;
	
	// 내가등록한 총 일정갯수 조회
		int totalRows = dao.getTotalRows(user.getUserid());
	
	// 총 페이지 갯수 계산하기
		int totalPages = (int) Math.ceil((double)totalRows/ROWS_PER_PAGE);
	
	// 페이지 번호를 알아내기
		int pageNo = NumberUtil.StringToInt(request.getParameter("pno"), 1);
	
	// 조회시 구간시작값과 구간끝값 알아내기
		int beginIndex = (pageNo - 1)*ROWS_PER_PAGE + 1;
		int endIndex = pageNo*ROWS_PER_PAGE;
		
		ArrayList<TodoVO> todoList = dao.getTodoListForPaging(beginIndex, endIndex, user.getUserid());
		
		ArrayList<TodoVO> todoListCateGory = dao.serchTodoByCategory(beginIndex, endIndex, user.getUserid(),category);
%>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">일정 목록
					
						<form class="form-inline text-right" method="get" action="main.jsp">
						
							<div class="form-group">
								<input type="hidden" name="pno" value="1"/>
								<select class="form-control" name="category">
									<option>개인</option>
									<option>회사</option>
									<option>기타</option>
								</select>
							</div>
							<button type="submit" class="form-control">조회</button>
							
						</form>
					</div>
					<div class="panel-body">
						<table class="table table-striped">
						<colgroup>
						<col width="*">
						<col width="15%">
						<col width="15%">
						<col width="20%">
						</colgroup>
							<thead>
								<tr>
									<th>제목</th>
									<th>날짜</th>
									<th>완료여부</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							<%
							if(category == null){
								if(!todoList.isEmpty()) {
									
									
									
									for (TodoVO todo : todoList) {
							%>
								<tr>
									<td><a href="detail.jsp?detailNo=<%=todo.getNo() %>&pno=<%=pageNo %>"><%=todo.getTitle() %></a></td><td><%=todo.getDate() %></td><td><%=todo.getCompleted() %></td>
									<td>
									<%
										if("NO".equals(todo.getCompleted())) {
									%>
										<a href="success.jsp?sno=<%=todo.getNo() %>&pno=<%=pageNo %>" class="btn btn-success btn-xs">완료</a>
										
									<%
										}
									%>
										<a href="delete.jsp?dno=<%=todo.getNo() %>&pno=<%=pageNo %>" class="btn btn-danger btn-xs">삭제</a>
									</td>
								</tr>
								<%
									}
								}else {
								%>
									<tr>
										<td style="column-span: 4">일정이 등록되어있지 않습니다.</td>
									</tr>	
								<%
								}
							}else {
								

								
								
								if (!todoListCateGory.isEmpty()) {
									
									for (TodoVO todo : todoListCateGory) {
								%>
										<tr>
											<td><a href="detail.jsp?detailNo=<%=todo.getNo() %>"><%=todo.getTitle() %></a></td><td><%=todo.getDate() %></td><td><%=todo.getCompleted() %></td>
											<td>
											<%
												if ("NO".equals(todo.getCompleted())){
											%>
												<a href="success.jsp?sno=<%=todo.getNo() %>" class="btn btn-success btn-xs">완료</a>
												
											<%
												}
											%>
												<a href="delete.jsp?dno=<%=todo.getNo() %>" class="btn btn-danger btn-xs">삭제</a>
											</td>
										</tr>
								<%
									}
								}else {
									%>
									<tr>
										<td style="column-span: 4">일정이 등록되어있지 않습니다.</td>
									</tr>
									
									<%
								}
							}
								%>
								
								
							</tbody>
						</table>
						<div class="text-center">
							<ul class="pagination pagination-xs">
							<%for (int index=1; index<=totalPages; index++){ %>
								
								<%
								if (index == pageNo) {
								
								%>
								<li class="active"><a href="main.jsp?pno=<%=index%>"><%=index %></a></li>
								
								
								<%
								}else {
								%>
								<li><a href="main.jsp?pno=<%=index%>"><%=index %></a></li>								
								<%
								} 
								%>
									
							<%}%>
							</ul>
						</div>
					</div>
					<div class="panel-footer text-right">
							<a href="form.jsp" class="btn btn-default">새 일정 등록</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>