<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>
<title>회원가입 페이지</title>

</head>
<style>
/*
/* Created by Filipe Pina
 * Specific styles of signin, register, component
 */
/*
 * General styles
 */
body, html {
	height: 100%;
	background-repeat: no-repeat;
	background-color: #d3d3d3;
	font-family: 'Oxygen', sans-serif;
}

.main {
	margin-top: 70px;
}

h1.title {
	font-size: 50px;
	font-family: 'Passion One', cursive;
	font-weight: 400;
}

hr {
	width: 10%;
	color: #fff;
}

.form-group {
	margin-bottom: 15px;
}

label {
	margin-bottom: 15px;
}

input, input::-webkit-input-placeholder {
	font-size: 11px;
	padding-top: 3px;
}

.main-login {
	background-color: #fff;
	/* shadows and rounded borders */
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	-moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	-webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.main-center {
	margin-top: 30px;
	margin: 0 auto;
	max-width: 330px;
	padding: 40px 40px;
}

.login-button {
	margin-top: 5px;
}

.login-register {
	font-size: 11px;
	text-align: center;
}
</style>

<body>
	<div class="container">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title" align="center">회원가입</h1>
				</div>
			</div>
			<div class="main-login main-center">
				 <form class="register-form" method="post" id="f1" action="register" align="center">
					<div class="box-body">
						<div class="form-group">
					<label for="MemberID"></label> 
					<input type="text" name="member_id" class="form-control" placeholder="Enter ID">
				</div>
				<div class="form-group">
					<label for="MemberPassword"></label>
					<input type="password" name="member_pw" class="form-control" placeholder="Enter PW">
				</div>
				<div class="form-group">
					<label for="MemberNAME"></label>
					<input type="text" name="member_name" class="form-control" placeholder="Enter NAME">
				</div>
			</div>
					<button type="button" id="mBtn">등록</button>
					<button type="button" id="cBtn">취소</button>
				</form>
				
			</div>
		</div>
	</div>

	
	<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
		
		var msg = '${msg}';
		
		if (msg == 'registSuccess') {
			alert('회원가입에 성공하셨습니다!');
		} 
		
		$("#mBtn").on("click", function() {
			$("#f1").submit();
		});
		
		$("#cBtn").on("click", function() {
			self.location = "/index";
		});
		
	});


</script>		
</body>
</html>