<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<h2>설문조사 결과</h2>
문제 : ${map.dto.question}<br><br>
<table border="1">
	<tr align="center">
		<th>문항</th>
		<th>응답수</th>
		<th>응답비율</th>
	</tr>
<c:forEach var="row" items="${map.list}">
	<tr align="center">
		<td>${row.num}</td>
		<td>${row.sum_num}</td>
		<td>${row.rate}%</td>
	</tr>
</c:forEach>
</table>
<a href="<%=request.getContextPath()%>">Home</a>
</body>
</html>



















