<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
.box-body{
	font-style: italic;
	font-family: "고딕";
	margin: 100px;
	position: relative; 
	margin-left: auto;
   	margin-right: auto;
	} 
.pagination li{
	margin-left:auto;
   	margin-right:auto;
   	list-style: none;
	float: left;
	margin-left: 100px;
	position : relative;
	left : 30%;
	
	}
.f1{
	color : lime;
	background-color : teal;
	font-family: "맑은 고딕";
	border : 2px solid black;
	}
.table-bordered{
	margin : 100px;
	position: relative;
	text-align: center;
	}		
</style>
<body>

<form class="f1" name="membership">
<div class='box-body' align="center">
<h1>회원정보 목록게시판</h1>
	<select name="searchType">
		<option value="n"<c:out value="${cri.searchType == null?'selected':''}"/>>---</option>
		<option value="i"<c:out value="${cri.searchType eq 'i'?'selected':''}"/>>USERID</option>
		<option value="e"<c:out value="${cri.searchType eq 'e'?'selected':''}"/>>USEREMAIL</option>
		<option value="n"<c:out value="${cri.searchType eq 'n'?'selected':''}"/>>USERNAME</option>
	</select>
	<input type="text" name="keyword" id="keywordInput" value="${cri.keyword}">
	<button id="searchBtn" class="btn btn-warning">검색</button>
	<button id="cBtn" class="btn btn-primary">회원목록생성</button>
</div>
<table class="table-bordered">
		<tr>
			<th>번호</th><th>아이디</th><th>패스워드</th><th>이메일</th><th>이름</th><th>이미지</th>
			<th>등록시간</th><th>수정시간</th><th>댓글조회수</th><th>댓글카운트</th>
		</tr>

<c:forEach items="${list}" var="MemberVO">
<ul class="list">
		<tr align="center">
	<td><a href='/member/view${pageMaker.makeSearch(pageMaker.cri.page)}&uno=${MemberVO.uno}'>
		${MemberVO.uno}</a></td><td>${MemberVO.uid}</td><td>${MemberVO.upw}</td>
		<td>${MemberVO.email}</td><td>${MemberVO.uname}</td>
		<td><c:if test="${MemberVO.uimg ne null}">
			<img src="show?name=${MemberVO.uimg}">
		</c:if></td>
		<td>${MemberVO.regdate}</td><td>${MemberVO.updatedate}</td>
		<td>${MemberVO.viewcnt}</td><td>${MemberVO.replycnt}</td>
	</tr>
</ul>
</c:forEach>
</table>
	<ul class="pagination pagination-lg ">
		<c:if test="${pageMaker.prev}">
			<li><p><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}" >이전</a></p></li>
		</c:if>
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<li class="active" <c:out value="${pageMaker.cri.page == idx?'class = active':''}"/>>
				<p><a href="list${pageMaker.makeSearch(idx)}">${idx}</a></p></li>
		</c:forEach>
		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><p><a href="list${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></p></li>
		</c:if>
	</ul>
</form>
 
<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
		
		$("#searchBtn").on("click", function(event){
			self.location = "list" + '${pageMaker.makeQuery(1)}' + "&searchType=" +
						$("select option:selected").val() + "&keyword=" + $('#keywordInput').val();
		});
		
		$("#cBtn").on("click", function(){
			$(".f1").attr("action", "register").submit();
		});	
	});
</script>		
</body>
</html>