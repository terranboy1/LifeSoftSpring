<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
게시물수 : ${map.count}건
<c:forEach var="dto" items="${map.list}">
<form method="post" action="${path}/gbEdit.do">
	<input type="hidden" name="_id" value="${dto._id}">
	<table border="1" style="width:600px;">
		<tr align="center">
			<td width="20%">이름</td>
			<td width="30%">${dto.name}</td>
			<td width="20%">날짜</td>
			<td width="30%">
				<fmt:formatDate value="${dto.post_date}"
					pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
		<tr>
			<td align="center">이메일</td>
			<td colspan="3">${dto.email}</td>
		</tr>
		<tr>
			<td colspan="4">${dto.content}</td>
		</tr>
		<tr>
			<td colspan="4" align="center">	
				비밀번호 <input type="password" name="passwd">
				<input type="submit" value="편집">
			</td>
		</tr>
	</table>
</form>
</c:forEach>



















