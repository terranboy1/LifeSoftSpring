<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
$(function(){ //페이지 로딩 완료
	gbList();
});
function gbList(){
	$.ajax({
		url: "${path}/gbList.do",
		success: function(result){
			$("#gbList").html(result);
		}
	});
}
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>방명록</h2>
<input type="button" value="글쓰기" 
	onclick="location.href='${path}/gbWrite.do'">
<div id="gbList"></div>	
</body>
</html>



















