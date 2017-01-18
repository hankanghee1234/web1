<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%> 
<%@include file="../include/header2.jsp"%>
<style>
.fileDrop {
	width: 300px;
	height: 300px;
	border: 2px groove blue;
	}

.box-body {
	background-color: aqua;
	margin: 30px;
	font-style: italic;
	font-size: 20px;
	font-family: monospace;
	border : 2px solid yellow;
	}	
</style>

<form class="membership" action="register" method="post">
<div class="form-group" align="center">
<h1>회원가입 페이지</h1>

		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputUserID">아이디</label> 
				<input type="text" name="uid" class="form-control" placeholder="Enter UserID">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword">패스워드</label>
				<input type="text" name="upw" class="form-control" placeholder="Enter UserPW">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail">이메일</label>
				<input type="text" name="email" class="form-control" placeholder="Enter Email">
			</div>
			<div class="form-group">
				<label for="exampleInputUserName">이름</label>
				<input type="text" name="uname" class="form-control" placeholder="Enter UserName">
			</div>	
		</div>
		<!-- /.box-body -->
		<p><input type="hidden" name="uimg" id="imgsrc"></p>
		
		<div class='fileDrop'></div>
		<div class="uploadedList"></div>
		
	</div>
		<div class="box-footer" align="center">
		<button class="btn btn-primary">등록</button>
		</div>
</form>
	
<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>
		
<script>
	
	$(document).ready(function() {
		
		var uploadedList = $(".uploadedList");
		
		$(".fileDrop").on("dragenter dragover", function(event) {
			event.preventDefault();
		});
		
		$(".fileDrop").on("drop", function(event) {
			event.preventDefault();
			
			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];
			
			var formData = new FormData();
			
			$('.uploadedList').empty();
			formData.append("file", file);
			
			console.log(formData);
			
			$.ajax({
				url : "uploadFile",
				data : formData,
				dataType : 'text',
				type : "post",
				contentType : false,
				processData : false,
				success : function(data) {
					uploadedList.html("<img src=show?name=" + data + ">");
					$("#imgsrc").val(data);
					alert("이미지 등록 완료");
				}
			});
		});

	});
</script>		
<%@include file="../include/footer2.jsp"%>