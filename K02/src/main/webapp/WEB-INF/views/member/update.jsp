<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%> 
<%@include file="../include/header2.jsp"%>

<style>
.fileDrop {
	width: 300px;
	height: 300px;
	border: 3px dotted blue;
	margin: 20px;
	}
.table-member{
	background-color: yellow;
	color : black;
	font-style: italic;
	font-family: "맑은 고딕";
	list-style : none;
	border : 2px solid aqua;
}
.box-body{
	background-color: aqua;
	font-family: "궁서";
	margin: 20px;
	position: relative;
	margin-left: 10%;
	margin-right: 10%;
	}
</style>

<form role="form" method="post" action="update">
<div align="center">
	<input type="hidden" name="uno" value="${param.uno}">
	<h1>회원정보 수정</h1>
<table class="table-member">
	<tr>
		<th>번호 </th> <th>아이디</th> <th>패스워드</th><th>이메일</th><th>이름</th>
		<th>이미지</th> <th>등록 시간</th><th>수정 시간</th><th>댓글 카운트</th><th>댓글조회수</th> 
	</tr>
	<tr>
		<td>${read.uno}</td><td>${read.uid}</td><td>${read.upw}</td>
		<td>${read.email}</td><td>${read.uname}</td>
		<td><c:if test="${read.uimg ne null}">
			<img src="show?name=${read.uimg}">
		</c:if></td>
		<td>${read.regdate}</td><td>${read.updatedate}</td><td>${read.viewcnt}</td>
		<td>${read.replycnt}</td>
</table>	

<div class="up-list" align="center">
	<input type="hidden" name="page" value="${cri.page}">
	<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
	<input type="hidden" name="searchType" value="${cri.searchType}">
	<input type="hidden" name="keyword" value="${cri.keyword}">
	
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputUserId">아이디</label> 
			<input type="text" name="uid" class="form-control" value="${MemberVO.uid}" 
			placeholder="Enter UserID">
		</div>
		<div class="form-group">
			<label for="exampleInputUserPw">패스워드</label> 
			<input type="text" name="upw" class="form-control" value="${MemberVO.upw}"
			placeholder="Enter UserPW">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail">이메일</label>
			<input type="text" name="email" class="form-control" value="${MemberVO.email}"
			placeholder="Enter UserEmail">
		</div>
		<div class="form-group">
			<label for="exampleInputUserName">이름</label> 
			<input type="text" name="uname" class="form-control" value="${MemberVO.uname}"
			placeholder="Enter UserName">
		</div>
	</div>
	<p><input type="hidden" name="uimg" id="imgsrc"></p>
	<div class='fileDrop'></div>
	<div class="uploadedList"></div>
	
	<div class="box-footer">
		<button id="uBtn" class="btn btn-primary">수정</button>
		<button id="cBtn" class="btn btn-calcel">취소</button>
	</div>	
</div>
</div>	
</form>	

<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
		
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$("#cBtn").on("click", function(){
			self.location = "/member/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
					+ "&searchType=${cri.searchType}&keyword=${cri.keyword}";	
		});
		
		$("#uBtn").on("click", function(){
			formObj.submit();	
		});
		
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
					alert("이미지 수정 완료");
				}
			});
		});
	});
</script> 	
<%@include file="../include/footer2.jsp"%>