
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

	<form role="form" method="post" id="f1">
		<div class="col-md-12">
			<input type="hidden" name="bno" value="${param.bno}">

			<table class="table-view">
				<tr align="center">
					<th>번호</th>
					<th>타이틀</th>
					<th>글내용</th>
					<th>작성자</th>
					<th>등록시간</th>
					<th>수정시간</th>
				</tr>

				<tr align="center">
					<td>${read.bno}</td>
					<td>${read.title}</td>
					<td>${read.content}</td>
					<td>${read.member_id}</td>
					<td>${read.regdate}</td>
					<td>${read.modidate}</td>
				</tr>
			</table>
		</div>
		<div class="btn-group" align="center">
			<button type="button" id="uBtn" class="btn btn-primary">수정</button>
			<button type="button" id="dBtn" class="btn btn-warning">삭제</button>
			<button type="button" id="listBtn" class="btn btn-info">전체목록</button>
		</div>
	</form>



	<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>

	<script>
	
	
	$(document).ready(function(){

		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$("#listBtn").on("click", function(){
			
			formObj.attr("method", "get");
			formObj.attr("action", "list");
			formObj.submit();
			
		}); //전체목록가기(멤버)
		
		$("#uBtn").on("click", function(){ 
			
			formObj.attr("action", "update");
			formObj.attr("method", "get");
			formObj.submit();
			
		}); //멤버수정처리
		
		$("#dBtn").on("click", function(){ 
			
			formObj.attr("method", "post");
			formObj.attr("action", "delete");
			formObj.submit();
			
		}); //멤버삭제처리
		 
   			
   		
    });

	
</script>
</body>
</html>