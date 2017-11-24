<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>뷰 페이지</title>
</head>
<body>
<form role="form">
<h1 align="center">게시판 글 하나만 읽습니다.</h1>
	<div class="responsive-table" align="center">
		<table>
			<tr>
				<th>BNO</th>
				<th>TITLE</th>
				<th>CONTENT</th>
				<th>MEMBER_NAME</th>
				<th>REGDATE</th>
				<th>MODIDATE</th>
			</tr>
			<tr>
				<th>${read.bno}</th>
				<th>${read.title}</th>
				<th>${read.content}</th>
				<th>${read.member_name}</th>
				<th>${read.regdate}</th>
				<th>${read.modidate}</th>
			</tr>
		</table>
			<div class="box-footer">
				<button class="btn btn-warning" id="mBtn">수정</button>
				<button class="btn btn-danger" id="dBtn">삭제</button>
				<button class="btn btn-primary" id="lBtn">돌아가기</button>
			</div>
		</div>
</form>		
<script src="https://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>
	
<script>
	$(document).ready(function() {
		
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$("#mBtn").on("click", function() {
			formObj.attr("action", "modify");
			formObj.attr("method", "get");
			formObj.submit();
		});
		
		$("#dBtn").on("click", function() {
			formObj.attr("action", "remove");
			formObj.attr("method", "post");
			formObj.submit();
		});
		
		$("#lBtn").on("click", function() {
			self.location = "/board/list";
		});
	
	});


</script>	
</body>
</html>