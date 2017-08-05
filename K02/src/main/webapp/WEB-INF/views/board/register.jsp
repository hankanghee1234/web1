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
	<form action="register" method="post">
		<input type="hidden" name="member_id" value="${param.member_id}">
		<div class="form-group" align="center">
			<h1>회원가입 페이지</h1>
			<div class="box-body">
				<div class="form-group">
					<label for="exampleInputTitle">타이틀</label> <input type="text"
						name="title" class="form-control" placeholder="Enter Title">
				</div>
				<div class="form-group">
					<label for="exampleInputContent">글내용</label> <input type="text"
						name="content" class="form-control" placeholder="Enter Content">
				</div>
				<div class="form-group">
					<label for="exampleInputMember_id">작성자</label> <input type="text"
						name="member_id" class="form-control"
						placeholder="Enter Member_id">
				</div>
			</div>
			<!-- /.box-body -->
		</div>
		<div class="box-footer" align="center">
			<button class="btn btn-primary" type="submit">등록</button>
		</div>
	</form>
</body>
</html>
