<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
function gb_edit(){
	document.form1.action="${path}/gbUpdate.do";
	document.form1.submit();
}
function gb_del(){
	if(confirm("삭제하시겠습니까?")){
		document.form1.action="${path}/gbDelete.do";
		document.form1.submit();
	}
}
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<form method="post" name="form1">
<table border="1" width="500px">
	<tr>
		<td>이름</td>
		<td><input name="name" value="${map.dto.name}"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input name="email" value="${map.dto.email}"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd"></td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea rows="5" cols="55" 
			name="content">${map.dto.content}</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="hidden" name="_id" value="${map.dto._id}">
			<input type="button" value="수정" onclick="gb_edit()">
			<input type="button" value="삭제" onclick="gb_del()">
			<input type="button" value="목록"
				onclick="location.href='${path}/guestbook.do';">
		</td>
	</tr>
</table>
</form>
</body>
</html>



















