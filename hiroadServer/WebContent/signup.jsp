<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="viewport"
	content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/signup.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<center>
		<div class="wrapper">
			<div class="box1-content">
				<div class="header">
					<img src="images/hiforyou.png">
				</div>
				<form method="post" action="hiroad?cmd=joinAction">
					<div class="box1">
						<input id="snum" class="snum" type="text" name="snum"
							placeholder="학번" /> <input type="button" id="tt" value="중복확인"
							required>
						<div class="idchecktext"></div>
						<input class="pw" type="password" name="passwd" placeholder="패스워드" />
						<input class="email" type="email" value="" name="email"
							placeholder="이메일" /> <input type="submit" value="Sign Up"
							class="subt" />
						<div class="res">
							<input class="reset" type="reset" value=" 다시 입력" />
						</div>
						<div class="col-xs-12 col-sm-6 col">
							<hr class="omb_hrOr">
							<span class="spanOr">or</span>
						</div>
						<input type="button" value="Log in" class="logbt"
							onclick="window.location='login.jsp'" />
					</div>
				</form>
			</div>
		</div>
	</center>
	<script>

   $('#tt').click(function() {
      var inputId=$('.snum').val();
      /* location.href="hiroad?cmd=hasconfirmId&snum="+inputId; */
       $.ajax({      
         url:"hiroad?cmd=hasconfirmId&snum="+inputId,
         success : function(result) {
            $(".idchecktext").html(result);
         }
      }); 
   }); 
</script>
</body>
</html>