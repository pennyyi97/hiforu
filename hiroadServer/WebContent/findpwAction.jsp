    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<title>임시화면 (모달으로 하고싶지만 -은진-)</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<style>
.findpasswd {
   width: 90%;
    border: 2px solid #17579b;
    margin-top: 100px;
    height: 150px;
    padding: 10px;
    letter-spacing: -1.5px;
}
.logbt1 {
   text-align: center;
    border: 0;
    outline: 0;
    background: white;
    color: rgb(23,87,155);
    margin-top: 15px;
}
</style>
</head>
<body>
   <center>
      <div class="wrapper">
   <div class="box1-content">
      <div class="header">
         <img src="images/hiforyou.png">
      </div>
      <div class="findpasswd"><br>회원가입 시 사용한 비밀번호는 <br><br><h3>  ${passwd}</h3><br>입니다.</div>
      <input class="logbt1" onclick="window.location='hiroad?cmd=login'" value="로그인" />
   </div>
</div>

</center>
</body>