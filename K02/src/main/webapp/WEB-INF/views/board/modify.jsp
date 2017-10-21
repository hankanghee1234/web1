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
<form role="form" method="post">
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputBNO">BNO</label>
				<input type="text" name="bno" class="form-control" value="${BoardVO.bno}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputTitle">TITLE</label>
				<input type="text" name="title" class="form-control" value="${BoardVO.title}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputContent">CONTENT</label>
				<textarea name="content" class="form-control" rows="3">${BoardVO.content}</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputMemberName">MEMBER_NAME</label>
				<input type="text" name="member_name" class="form-control" value="${BoardVO.member_name}">
		</div>
	</div>
</form>

<div class="box-footer">
	<button type="submit" class="btn btn-primary">SAVE</button>
	<button type="submit" class="btn btn-warning">CANCEL</button>
</div>
</body>
</html>