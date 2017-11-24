<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정 페이지</title>
</head>
<body>
<h1>게시글 수정 합니다.</h1>
<form role="form" action="modify" method="post">
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputBNO">BNO</label>
				<input type="text" name="bno" class="form-control" value="${read.bno}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputTitle">TITLE</label>
				<input type="text" name="title" class="form-control" value="${read.title}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputContent">CONTENT</label>
				<input type=text class="form-control" name="content" placeholder="게시글 수정" value="${BoardVO.content}">
				<%-- <textarea name="content" class="form-control" rows="3" placeholder="게시글 수정" value="${BoardVO.content}"></textarea> --%>
		</div>
		<div class="form-group">
			<label for="exampleInputMemberName">MEMBER_NAME</label>
				<input type="text" name="member_name" class="form-control" value="${read.member_name}" readonly="readonly">
		</div>
	</div>
</form>

<div class="box-footer">
	<button class="btn btn-primary" id="uBtn">SAVE</button>
	<button class="btn btn-warning" id="cBtn">CANCEL</button>
</div>

<script src="https://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>
	
<script>
	$(document).ready(function() {
		
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$("#cBtn").on("click", function() {
			self.location = "/board/list";
		});
		
		$("#uBtn").on("click", function() {
			formObj.submit();
		});
	});
</script>
</body>
</html>