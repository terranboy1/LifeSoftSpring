<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
	<h2>Welcome!</h2>
	<h2>${msg}</h2>
	<a href="${path}/admin/">관리자 페이지</a><br>
	<a href="${path}/user/logout.do">로그아웃</a>
</body>
</html>

























