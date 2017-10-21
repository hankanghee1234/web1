<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>뷰 페이지</title>
</head>
<body>
<h1>게시판 글 하나만 읽습니다.</h1>
<form role="form" method="post">
	<input type="hidden" name="bno" value="${BoardVO.bno}">
</form>
	<div class="box-body">
			<div class="form-group">
				<label for="exampleInputTitle">Title</label>
				<input type="text" name="title" class="form-control" value="${BoardVO.title}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputContent">Content</label>
				<textarea class="form-control" name="content" rows="3" readonly="readonly">${BoardVO.content}</textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputName">Member_name</label>
				<input type="text" name="member_name" class="form-control" value="${BoardVO.member_name}" readonly="readonly">
			</div>
			
			<div class="box-footer">
				<button type="submit" class="btn btn-warning" id="mBtn">Modify</button>
				<button type="submit" class="btn btn-danger" id="dBtn">Remove</button>
				<button type="submit" class="btn btn-primary" id="lBtn">List All</button>
			</div>
		</div>
<script src="https://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>
	
<script>
	$(document).ready(function() {
		
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$("#mBtn").on("click", function() {
			formObj.attr("action", "/board/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});
		
		$("#dBtn").on("click", function() {
			formObj.attr("action", "/board/remove");
			formObj.submit();
		});
		
		$("#lBtn").on("click", function() {
			self.location = "/board/list";
		});
	
	});


</script>	
</body>
</html>