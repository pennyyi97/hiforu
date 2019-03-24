<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
   content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
   <center>
      <div class="wrapper">
      <div class="box1-content">
         <div class="header">
            <img src="images/hiforyou.png">
         </div>
         <form method="post" action="hiroad?cmd=findpwAction">
            <div class="box1">
               <input type="text" placeholder="학번" class="id" name="snum" />
               <input class="email" type="text" value="" name="email" placeholder="이메일" />
            <input type="submit" value="비밀번호 찾기" class="fibt" />
            </div>
         </form>
      </div>
   </div>
   </center>
</body>
</html>
