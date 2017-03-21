<%@page import="board.BoardVO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDAO boardDAO = new BoardDAO();
	BoardVO board = boardDAO.getBoardDetailByNo(Integer.parseInt(request.getParameter("bno")));
	String title = board.getTitle();
	String writer = board.getWriter();
	String content = board.getContents();
	
%>
<!DOCTYPE html>
<html>
<head lang="ko">
<meta charset="UTF-8">
<title>게시글 목록</title>
<style type="text/css">
        table, th, td {
            margin-top: 50px;
            margin-left: 60px;
            border-top: 3px solid #1D1F21;
            border-bottom: 3px solid #1D1F21;
            border-collapse: collapse;
            color: #1D1F21;
        }
        th{
            
            text-align: center;
            background-color: crimson;
            border-right: 3px solid #1D1F21;
        }
        #text{
            width: 200px;
            height: 200px

        }
        .a{
            text-align: center;
        }
        #btn{
            margin-left: 268px
        }
</style>
</head>
<body>
	<table>
       
        <tr>
            <th width = "70px">글 제목</th>
            <td class="a"><%=title %></td>
        </tr>
        
        <tr>
            <th>작성자</th>
            <td class="a"><%=writer %></td>
        </tr>
        
        <tr>
            <th>글내용</th>
            <td id="text"><%=content %></td>
        </tr>
    </table>
    <a href='Board.jsp'><button id="btn">돌아가기</button></a>
</body>
</html>