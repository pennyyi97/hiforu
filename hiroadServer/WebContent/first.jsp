<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/first.css">
 <script src="js/jquery-3.2.1.min.js"></script>
  <script>
    	$(document).ready( function(){
    		  $(".nologin").click(function(){
    	             location.replace('hiroad?cmd=main');
    	         })
    	})
        </script>
</head>
<body>
   <div class="loginback">
      <div class="loginlogo">
         <img class="logo" src="images/hiforyou.png" />
      </div>
      <div class="loginbox">
         <button class="yeslogin" onclick="window.location='login.jsp'">로그인</button>
         <br>
         <a class="nologin"><p class="nologintext">아니요, 넘어갈래요.</p></a>
      </div>
   </div>
</body>
</html>