<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>로그인하세요</h2>
<form method="post" name="form1"
	action="${path}/member/login_check.do">
<span style="color:red;">${map.message}</span>	
<table>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="_id"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">	
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" 
				onclick="location.href='${path}/member/join.do';">
		</td>
	</tr>
</table>
</form>
</body>
</html>



















