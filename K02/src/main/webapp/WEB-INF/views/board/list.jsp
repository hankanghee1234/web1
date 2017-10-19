<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 페이지</title>
</head>
<body>
	<div class="responsive-table" align="center">
		<table class="table table-bordered table-hover" width="50%" cellspacing="0">
			<tr>
				<th style="width: 10px">BNO</th>
				<th>TITLE</th>
				<th>CONTENT</th>
				<th>MEMBER_NAME</th>
				<th>REGDATE</th>
				<th>MODIDATE</th>
			</tr>
			<c:forEach items="${list}" var="BoardVO">
				<tr>
					<td><a herf="/board/read?bno=${BoardVO.bno}">${BoardVO.bno}</a></td>
					<td>${BoardVO.title}</td>
					<td>${BoardVO.content}</td>
					<td>${BoardVO.member_name}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${BoardVO.regdate}"></fmt:formatDate></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${BoardVO.modidate}"></fmt:formatDate></td>
				</tr>
			
			</c:forEach>
		</table>
	</div>
</body>
</html>