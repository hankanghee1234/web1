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
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
    padding: 10px;
  }
</style>
<body>
<form id="f1">
<h1 align="center">Member 게시판 입니다.</h1>
	<div class="responsive-table" align="center">
		<table class="table table-bordered table-hover" width="50%" cellspacing="0">
			<tr>
				<th style="width: 20px">BNO</th>
				<th>TITLE</th>
				<th>CONTENT</th>
				<th>MEMBER_NAME</th>
				<th>REGDATE</th>
				<th>MODIDATE</th>
			</tr>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td><a href="/board/view?bno=${vo.bno}">${vo.bno}</a></td>
					<td>${vo.title}</td>
					<td>${vo.content}</td>
					<td>${vo.member_name}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${vo.regdate}"></fmt:formatDate></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${vo.modidate}"></fmt:formatDate></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="box-footer">
		<button class="btn btn-primary" id="rBtn">생성</button>
	</div>
</form>	
<script src="https://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>	
	
<script>
	$(document).ready(function (){
		
		$("#rBtn").on("click", function() {
			$("#f1").attr("action", "register").attr("method", "get").submit();
		}); // 게시판 생성 버튼 누르기
	});
</script>
</body>
</html>