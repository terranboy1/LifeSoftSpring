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
	memo_list();
	$("#btnWrite").click(function(){
		memo_insert();
	});
});
function memo_insert(){
	var writer=$("#writer").val();
	var memo=$("#memo").val();
	$.ajax({
		type: "post",
		data: {"writer":writer, "memo":memo},
		url: "${path}/memo_insert.do",
		success: function(){
			memo_list(); //목록 갱신
			$("#writer").val("");
			$("#memo").val("");
		}
	});
}
function memo_list(){
	$.ajax({
		url: "${path}/memo_list.do",
		success: function(result){
			$("#memoList").html(result);
		}
	});
}
function memo_view(num){
	// memo_view.do?_id=5
	location.href="${path}/memo_view.do?_id="+num;
}
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>한줄메모장</h2>

이름 : <input id="writer">
메모 : <input id="memo" size="50">
<input type="button" value="확인" id="btnWrite">

<div id="memoList"></div>
</body>
</html>



















