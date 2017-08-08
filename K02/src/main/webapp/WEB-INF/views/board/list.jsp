<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>

body, html {
	height: 100%;
	background-repeat: no-repeat;
	background-color: #d3d3d3;
	font-family: 'Oxygen', sans-serif;
}

.main {
	margin-top: 70px;
}

h1.title {
	font-size: 50px;
	font-family: 'Passion One', cursive;
	font-weight: 400;
}

hr {
	width: 10%;
	color: #fff;
}

.form-group {
	margin-bottom: 15px;
}

.title {
	margin-bottom: 15px;
}

.table-bordered {
	background-color: #fff;
	/* shadows and rounded borders */
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	-moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	-webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.table-hover {
	margin-top: 30px;
	margin: 0 auto;
	max-width: 330px;
	padding: 40px 40px;
}

</style>
<body>
<h1 class="title">게시글 List</h1>
	<form class="f1">
		<table class="table table-bordered table-hover">
			<tr>
				<th>번호</th>
				<th>타이틀</th>
				<th>글내용</th>
				<th>작성자</th>
				<th>생성일</th>
				<th>수정일</th>
			</tr>

			<c:forEach items="${list}" var="BoardVO">
				<ul class="list">
					<tr>
						<td>${BoardVO.bno}</td>
						<td>${BoardVO.title}</td>
						<td>${BoardVO.content}</td>
						<td>${read.member_id}</td>
						<td>${BoardVO.regdate}</td>
						<td>${BoardVO.modidate}</td>
					</tr>
				</ul>
			</c:forEach>
		</table>
		<button class="btn btn-primary" id="cBtn">생성</button>
		<button class="btn btn-info" id="oBtn">로그아웃</button>
	</form>

	<form method="post" id="logoutForm" action="<c:url value='/member/logout'/>">
		<input id="logoutHidden" type="hidden" name="member_id" value="${member_id}">
	</form> <!-- 로그아웃 처리 -->

	<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>

<script>
	$(document).ready(function() {

		var loginSession = '${member_id}';
			 
		$("#cBtn").on("click", function() {
	
			$(".f1").attr("action", "register").submit();
		
		});
			
		$("#oBtn").on("click", function() {
		    console.log("로그아웃");         
			$('#logoutForm').submit();
			               	
		});
	});
</script>
</body>
</html>