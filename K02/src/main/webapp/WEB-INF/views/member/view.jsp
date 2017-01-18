 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%> 
<%@include file="../include/header2.jsp"%>

<style>
 
.table-view{
	background-color : silver;
	color : purple;
	font-size: 15px;
	font-style: italic;
	font-family: "맑은 고딕";
	border : 2px solid blue;
	margin : 30px;
	top : 50%;
	margin-left : 20%;
	margin-right : 20%; 
	}

#f2{
	margin : 20px;
	margin-left : 10%;
	margin-right : 10%;
	}
	
.replyMember{
	margin: 20px;
	top: 30%;
	left: 20%;
	font-style: oblique;
	font-family: "고딕"; 
	}

</style>


<h1 align="center">회원정보 보여주기</h1>
<form role="form" method="post" id="f1">
<div class="col-md-12">
	<input type="hidden" name="uno" value="${param.uno}">
	<input type="hidden" name="page" value="${cri.page}">
	<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
	<input type="hidden" name="searchType" value="${cri.searchType}">
	<input type="hidden" name="keyword" value="${cri.keyword}">

<table class="table-view" >
		<tr align="center">
			<th>번호</th><th>아이디</th><th>패스워드</th><th>이메일</th><th>이름</th>
			<th>이미지</th><th>등록시간</th><th>수정시간</th><th>댓글카운트</th><th>댓글조회수</th>
		</tr>

<tr align="center">
	<td>${read.uno}</td><td>${read.uid}</td><td>${read.upw}</td>
	<td>${read.email}</td><td>${read.uname}</td>
	<td><c:if test="${read.uimg ne null}"><img src="show?name=${read.uimg}">
	</c:if></td>
	<td>${read.regdate}</td><td>${read.updatedate}</td>
	<td>${read.viewcnt}</td><td>${read.replycnt}</td>
</tr>
</table>
</div>
	<div class="btn-group"  align="center">
	 	<button type="button" id="uBtn" class="btn btn-primary">수정</button>
	  	<button type="button" id="dBtn" class="btn btn-warning">삭제</button>
		<button type="button" id="listBtn" class="btn btn-info">전체목록</button>
	</div>
</form>

<div class="box-header">
	<div class="replytest" align="center">							
	</div>
</div>	

<form action="reply" method="post" id="f2">
<div class="row">
	<div class="col-md-12">
		<h3>댓글작성</h3>
		<div class="box box-success">	
			<div class="box-body">
				<input type="hidden" name="uno" value="${param.uno}">
				<label for="newReplyer">작성자</label>
				<input class="form-control" type="text" placeholder="replyer" id="replyer">
				<label for="newReplyText">댓글내용</label>
				<input class="form-control" type="text" placeholder="replytext" id="replytext">			
			</div>
		</div>
	</div>
</div>
<button type="submit" class="btn btn-primary" id="replyAddBtn">댓글등록</button>
</form>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel"></h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="control-label">작성자</label>
            <input type="text" class="form-control" id="replyer">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">댓글수정내용</label>
            <textarea class="form-control" id="replytext"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        <button type="button" class="btn btn-primary">수정완료</button>
      </div>
    </div>
  </div>
</div>
     

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
		 
		  var printReply = function(){
			
			event.preventDefault();
			var uno = ${param.uno};
			
			 $.getJSON(
				 "/reply/view/"+uno, 
	              function(data){
	                     
	             $('.reply').empty();
	             $.each(data, function(index, obj){ 
	                     
	                  rno = obj.rno;
	                  console.log(rno);

	                  $('.replytest').append(	  
	                	   '<div class="replyMember"><p><label for="newRno">' + "글번호: " + obj.rno + '</label></p>'
	                	 +  '<p><label for="newReplyer">' + "작성자: " + obj.replyer + '</label></p>'
	                     + '<p><label for="newReplyText">'+ "댓글내용: " + obj.replytext +'</label></p>'
	                     + '<button type="button" class="btn btn-warning" id="replyUpdateBtn" value="'
	                     + obj.rno +'">댓글수정</button>'
	                     + '<button type="button" class="btn btn-cancel" id="replyCencelBtn" value="'
	                     + obj.rno +'">댓글삭제</button></div>'
	                 );
	                      
	                 console.log(obj); 
	              }); 
	         });
		};
		
		console.log("댓글 달기를 시작합니다.");
        printReply(); 
        
        $('#replyAddBtn').on('click', function(event) {           
           console.log("add버튼 1단계");
           event.preventDefault();
           
           var data = { uno : ${param.uno},
                      replytext : $('#replytext').val(),
                      replyer : $('#replyer').val()
                      };  
           
           $.post("../reply/addReply", data, function(result) {   
        	   console.log("add버튼 2단계");
        	   console.log(data);
        	   console.log(result);
               alert("성공했습니다."); 
              printReply();  
              $('#replytext').val("");
              $('#replyer').val("");
           });
           
        }); // 댓글 등록 하기 위한 ajax 호출
        
      	$('.replytest').on('click', "#replyCencelBtn",function(event) {
        	 
            event.preventDefault();  
            
            var classVal = $(this).val(); 
            
               $.ajax({      
                   
                    type:"POST",  
                    url: "/reply/delReply",      
                    data : {"rno" : classVal},
                    
                     success:function(args){  
                       $('.replytest').empty();
                       printReply();       
                    },
              
                    error:function(e){                     
                       printReply();
   
                    }  
              });  
         });  // 댓글 삭제 하기 위한 ajax 호출
         
   		$('.replytest').on("click", "#replyUpdateBtn", function(event){
   			
   			event.preventDefault();
   			
   			var data = {rno : ${param.rno},
	   			replyer = $("#replyer").val(),
	   			replytest = $("#replytext").val()
   			};
   			
   			
   		});
    });

	
</script>
<%@include file="../include/footer2.jsp"%> 