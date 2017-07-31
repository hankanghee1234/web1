<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>

<body>
<form class="membership" action="register" method="post">
<div class="form-group" align="center">
<h1>회원가입 페이지</h1>

		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputTitle">타이틀</label> 
				<input type="text" name="title" class="form-control" placeholder="Enter Title">
			</div>
			<div class="form-group">
				<label for="exampleInputContent">글내용</label>
				<input type="text" name="content" class="form-control" placeholder="Enter Content">
			</div>
			<div class="form-group">
				<label for="exampleInputMember_id">작성자</label>
				<input type="text" name="member_id" class="form-control" placeholder="Enter Member_id">
			</div>
		</div>
		<!-- /.box-body -->
		<p><input type="hidden" name="uimg" id="imgsrc"></p>
		
		<div class='fileDrop'>
		<div class="uploadedList"></div>
		</div>
	</div>
		<div class="box-footer" align="center">
		<button class="btn btn-primary" type="submit">등록</button>
		</div>
</form>		
</body>
<%@include file="../include/footer.jsp" %>
