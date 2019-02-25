<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 
uri="http://java.sun.com/jsp/jstl/fmt" %>

<table border="1" width="700px">
	<tr>
		<th>No</th>
		<th>이름</th>
		<th>메모</th>
		<th>날짜</th>
	</tr>
<c:forEach var="row" items="${map.items}" varStatus="status">
	<tr>
		<td>${status.count}</td> <!-- index 0부터, count 1부터 -->
		<td>${row.writer}</td>
		<td>
			<a href="#" onclick="memo_view('${row._id}')">
			${row.memo}</a>
		</td>
		<td><fmt:formatDate value="${row.post_date}" 
				pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
</c:forEach>	
</table>



















