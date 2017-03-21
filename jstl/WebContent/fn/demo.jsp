<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>sample</title>
</head>
<body>
	<c:set var="files" value="메모.txt,자기소개.ppt,이력서.doc"></c:set>
	<c:set var="productName" value="GalAXy 7"></c:set>
	<c:set var="email" value="was0413@naver.com"></c:set>
	
	<p>상품명 : ${fn:toUpperCase(productName) }</p>
	<p>상품명 : ${fn:toLowerCase(productName) }</p>
	
	
	<p>계정명 : ${fn:substring(email, 0,7) }</p>
	<p>계정명 : ${fn:substring(email, 0,fn:indexOf(email, '@')) }</p>
	
	<p>@의 위치 : ${fn:indexOf(email, '@') }</p>
	<p>@의 앞위치 : ${fn:substringBefore(email, '@') }</p>
	<p>@의 뒤 : ${fn:substringAfter(email, '@') }</p>
	
	<c:forEach var="filename" items="${fn:split(files, ',') }">
		<p>
			<c:choose>
				<c:when test="${fn:endsWith(filename, 'txt') }">
					${filename } <i class="fa fa-file-text-o"></i>
				</c:when>
				<c:when test="${fn:endsWith(filename, 'ppt') }">
					${filename } <i class="fa fa-file-powerpoint-o"></i>
				</c:when>
				<c:when test="${fn:endsWith(filename, 'doc') }">
					${filename } <i class="fa fa-file-word-o"></i>
				</c:when>
			</c:choose>
		</p>
	</c:forEach>
	
	
</body>
</html>