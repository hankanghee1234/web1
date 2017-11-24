<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<form role="form">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputTitle">Title</label>
				<input type="text" name="title" class="form-control" placeholder="글 제목">
			</div>
			<div class="form-group">
				<label for="exampleInputContent">Content</label>
				<textarea class="form-control" name="content" rows="3" placeholder="게시글 내용"></textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputName">Member_name</label>
				<input type="text" name="member_name" class="form-control" placeholder="작성자">
			</div>
			
			<div class="box-footer">
				<button class="btn btn-primary" id="sBtn">등록</button>
				<button class="btn btn-warning" id="cBtn">취소</button>
			</div>
		</div>
	</form>
	
<script src="https://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>
	
<script>

	var result = '${msg}';
	
	if(result == 'success') {
		alert("등록 완료");
	};
	
	$(document).ready(function() {
		
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$("#sBtn").on("click", function() {
			formObj.attr("action", "/board/register");
			formObj.attr("method", "post");
			formObj.submit();
		}); // 등록 버튼 누르면 게시글 생성
		
		$("#cBtn").on("click", function() {
			self.location = "/board/list";
		}); // 리스트로 돌아가기
	});
</script>
</body>
</html>