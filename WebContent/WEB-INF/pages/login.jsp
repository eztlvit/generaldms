<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdminLTE | Log in</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- bootstrap 3.0.2 -->
<link href="css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- font Awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<!-- Theme style -->
<link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript">
			function login(){
				var name = $("#name").val();
				var pwd = $("#pwd").val();
				$.ajax({
					url:"/generaldms/login?name="+name+"&pwd="+pwd,
					dataType:"json",
					type:"post",
					contentType:"appliaction/json;charset=utf-8",
					sucess:function (data){
						var sucess = data.success;
						if(sucess == true){
							window.location.href = "";
						}else{
							$("#msg").html("用户名密码错误！");
						}
					}
				});
			};

			/**$(document).ready(
				function (){
					$("#submit").click(login());
				}
			);**/

			function checkUser(){
				var xmlhttp;
				
				if(window.XMLHttpRequest){
					xmlhttp = new XMLHttpRequest();
				}else{
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}

				xmlhttp.onreadystatechange=function(){
					if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
						var data =  JSON.parse(xmlhttp.responseText);
						//$("msg").html(xmlhttp.responseText);
						var status = data.checkIn;
						if(status == true){
							//$("#form").submit();
							//window.location.href = "/generaldms/login";
						}else{
							$("#msg").html("用戶名或密碼錯誤！");
						}
					}
				};
				
				var pwd = $("#pwd").val();
				var name = $("#name").val();
				xmlhttp.open("post","/generaldms/login?name="+name+"&pwd="+pwd);
				xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				xmlhttp.send();
			}
        </script>
</head>
<body class="bg-black">

	<div class="form-box" id="login-box">
		<div class="header">Sign In</div>
		<form method="post" enctype="application/x-www-form-urlencoded" action="login">
			<div class="body bg-gray">
				<div class="form-group">
					<input name="name" type="text" name="userid" class="form-control"
						placeholder="User ID" />
				</div>
				<div class="form-group">
					<input name="pwd" type="password" name="password" class="form-control"
						placeholder="Password" />
				</div>
				<div class="form-group">
					<input type="checkbox" name="remember_me" /> Remember me
				</div>
			</div>
			<div class="footer">
				<button type="submit" id="submit" class="btn bg-olive btn-block">Sign
					me in</button>

				<p>
					<a href="#">I forgot my password</a>
				</p>
				<p id="msg"></p>
				<a href="register.html" class="text-center">Register a new
					membership</a>
			</div>
		</form>

		<div class="margin text-center">
			<span>Sign in using social networks</span> <br />
			<button class="btn bg-light-blue btn-circle">
				<i class="fa fa-facebook"></i>
			</button>
			<button class="btn bg-aqua btn-circle">
				<i class="fa fa-twitter"></i>
			</button>
			<button class="btn bg-red btn-circle">
				<i class="fa fa-google-plus"></i>
			</button>

		</div>
	</div>


	<!-- jQuery 2.0.2 -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="../../resource/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>