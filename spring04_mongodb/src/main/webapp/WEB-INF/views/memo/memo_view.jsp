<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
$(function(){
	$("#btnUpdate").click(function(){
		document.form1.action="${path}/memo_update.do";
		document.form1.submit();
	});
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="${path}/memo_delete.do";
			document.form1.submit();
		}
	});
});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>메모장</h2>
<form name="form1" method="post">
<input type="hidden" name="_id" value="${dto._id}">
이름 <input name="writer" value="${dto.writer}"><br>
메모 <input name="memo" value="${dto.memo}" size="50"><br>
<input type="button" value="수정" id="btnUpdate">
<input type="button" value="삭제" id="btnDelete">
<input type="button" value="목록" id="btnList"
	onclick="location.href='${path}/memo.do'">
</form>
</body>
</html>



















