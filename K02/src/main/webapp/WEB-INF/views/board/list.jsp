<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form class="f1" name="membership">
		<table class="table-bordered">
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
						<td><a href='/board/view&bno=${BoardVO.bno}'>${BoardVO.bno}</a></td>
						<td>${BoardVO.title}</td>
						<td>${BoardVO.content}</td>
						<td>${BoardVO.member_id}</td>
						<td>${BoardVO.regdate}</td>
						<td>${BoardVO.modidate}</td>
					</tr>
				</ul>
			</c:forEach>
		</table>
		<button class="btn btn-primary" id="cBtn">생성</button>
	</form>


	<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>

	<script>
		$(document).ready(function() {

			$("#cBtn").on("click", function() {
				console.log("생성 페이지 이동");
				$(".f1").attr("action", "register").submit();
			});
		});
	</script>
</body>
</html>