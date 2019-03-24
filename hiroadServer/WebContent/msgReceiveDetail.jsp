<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Detail</title>
    <link rel="stylesheet" type="text/css" href="css/menubar.css">
    <link rel="stylesheet" type="text/css" href="css/detail.css">
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<jsp:include page="smHeader.jsp" />
<div class="msg_header">	
    <div class="title">${list.msgTitle}</div><br>
    <div class="n">${list.sendId}<span class="txt_bar">|</span> ${list.sendDate}</div>
 <input  class="delete" type="button" value="삭제" onclick="window.location='hiroad?cmd=receiveMsgDelete&num=${list.msgNum}'">   
</div>
<hr>
   <div class="contents">
      <p>${list.msgContent}</p>
   </div>
</body>
</html>