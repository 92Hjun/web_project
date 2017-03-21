<%@page import="dao.BlogDAO"%>
<%@page import="vo.BlogVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%
	request.setCharacterEncoding("utf-8");
	
	//새글인지 댓글인지 알려주는값.
	String type = request.getParameter("type");
	
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String contents = request.getParameter("contents");
	
	BlogVO blog = new BlogVO();
	blog.setTitle(title);
	blog.setWriter(writer);
	blog.setContents(contents);
	
	// 새글인 경우
	BlogDAO dao = new BlogDAO();
	
	if ("new".equals(type)){
		
		int seq = dao.getSeq();
		blog.setNo(seq);
		blog.setGroupNo(seq);
		dao.setBoard(blog);
		
	}else if ("re".equals(type)){
		
		int seq = dao.getSeq();
		int groupNo = Integer.parseInt(request.getParameter("gno"));
		blog.setNo(seq);
		blog.setGroupNo(groupNo);
		dao.setBoard(blog);
		
	}
	
	response.sendRedirect("list.jsp");
%>