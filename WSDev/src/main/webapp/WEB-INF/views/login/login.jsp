<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">


	html, body {
		margin: 0px;
		padding: 0px;
	}

	.layout-background {
		background-color: #dbdbdb;
		width: 100%;
		height: 100%;
		position: absolute;
	}
	.login-title {
		
		width:500px;
		height: 120px;
		
	}
	
	.login-title span {
		width:400px;
		height:60px;
		margin: 30px 50px 30px 50px; 
		border-bottom: 1px solid #9b9b9b;
		display: inline-block;
		font: bold 20px "맑은 고딕";
	}
	
	.layout-login {
		width:500px;
		height: 220px;
		border: 1px solid #bbbbbb;
		box-shadow: 6px 6px 6px 0px #c2c2c2;
		margin:auto;
		position: absolute;
		background-color: #ffffff;
        left: 25%;
        right: 25%;
        top: 25%;
        bottom: 25%;
	}
	
	.layout-login .google {
 		background-image: url("resources/img/btn_google_signin_dark_normal_web.png");
 		width:200px;
        height: 50px;
 		margin:0px 150px 0px 150px;
 		display:inline-block;
		background-position: center;
		background-repeat: no-repeat; 
		background-size: contain;
	}
	
	.layout-login .google:hover {
 		background-image: url("resources/img/btn_google_signin_dark_focus_web.png");
	}

	.layout-login .google:focus {
 		background-image: url("resources/img/btn_google_signin_dark_focus_web.png");
	}
	.layout-login .google:active {
 		background-image: url("resources/img/btn_google_signin_dark_pressed_web.png");
	}
	
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Social Login</title>
</head>
<body>
	<div class="layout-background">
	</div>
	<div class="layout-login">	
		<div class="login-title">
		
			<span>
				Sign in
			</span>
		</div>
		<a href="${pageContext.request.contextPath}/login/google" class="google"></a>
	</div>

</body>
</html>