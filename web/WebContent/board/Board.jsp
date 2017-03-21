<%@page import="java.util.Date"%>
<%@page import="board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDAO boardDAO = new BoardDAO();
	ArrayList<BoardVO> boardList = boardDAO.getBoardList();
	String id = (String)request.getAttribute("userID");
	String pwd = (String)request.getAttribute("userPwd");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
        table {
            width: 98.5%;
            position: absolute;
            margin-top:70px;
            border-collapse: collapse;
            border-top: 3px solid #1D1F21;
            border-bottom: 3px solid #1D1F21;
            
        }
        .line{
            border-bottom: 3px solid #1D1F21;
            border-right: 3px solid #1D1F21;
        }
        th{
            background-color: cornflowerblue;
            border-bottom: 3px solid #1D1F21;
        }
        td {
       		border-bottom: 3px solid #1D1F21;
            color: #1D1F21;
            font-weight: bold;
            text-align: center;
        }
        h1{
            margin-top: 27px;
            margin-left: 43%;
            position: absolute;
        }
    </style>
</head>
<body>
	<h1>게시판입니다.</h1>
	<table>
	<tr>
		<th class="line">번호</th>
		<th class="line">제목</th>
		<th class="line">작성일</th>
		<th>삭제</th>
	</tr>
	<%
	session = request.getSession(false);
	if("hong".equals(id) && "zxcv1234".equals(pwd)){
	for (BoardVO board :boardList){
		int no = board.getNo();
		String title = board.getTitle();
		Date date = board.getDate();
	%>
	<tr>
		<td class="line"><%=no %></td>
		<td class="line"><a href='detail.jsp?bno=<%=no%>'><%=title %></a></td>
		<td class="line"><%=date %></td>
		<td><a href='del.jsp?bno=<%=no%>'><button>삭제</button></a></td>
	</tr>
	<%
	}
	}else {
		response.sendRedirect("login.jsp");
	}
	%>
	</table>
	<p><a href='form.hta'></a></p>
</body>
</html>