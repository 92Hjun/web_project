<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%
	String userId = request.getParameter("userId");
	System.out.println(userId);
// 중복여부 검사
	String duplicated = "N";
	if ("hong".equals(userId)) {
		duplicated = "Y";
	}
// 중복여부를 전달하기
	out.write(duplicated);

%>