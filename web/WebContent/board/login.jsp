<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isEmpty = false;
	String id = request.getParameter("userId");
	String pwd = request.getParameter("userPwd");
	
	if ("hong".equals(id)&&"zxcv1234".equals(pwd)) {
		isEmpty=true;
		session = request.getSession(true);
		request.setAttribute("userID", id);
		request.setAttribute("userPwd", pwd);
		System.out.println(request.getAttribute("userID"));
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if (!isEmpty){ // 로그인 실패시 %>
	<form method="post" action='Board.jsp'>
	아이디:<input type="text" name="userId"/><br/>
	비밀번호:<input type="password" name="userPwd"/><br/>
	<a href='Board.jsp'><button>로그인</button></a>
	</form>
	<%
	}else{ // 로그인 성공시
		response.sendRedirect("Board.jsp");
		System.out.println("로그인성공");
	}
	%>
</body>
</html>