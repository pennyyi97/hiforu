<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   <%
String template = "안녕하세요.\n 제 계좌는 {bank} {account_num} 입니다. \n 빠른 송금 부탁드립니다.";

util.MessageNameFormat format = new util.MessageNameFormat(template);
hiroad.members.MembersVO vo = (hiroad.members.MembersVO)request.getAttribute("vo");
java.util.HashMap param = new java.util.HashMap();
param.put("bank", vo.getAccountBank());
param.put("account_num", vo.getAccountNum());
String msg = format.format(param);
%>     
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="css/form.css">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/popup.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/swiper.min.js"></script>
<script src="js/popup.js"></script>
<style>
/* 헤더 높이와 배경색*/
#header {
	height: 60px;
	background: rgb(23, 87, 155);
}

.back {
	padding: 0 5px;
	margin-top: 20px;
}

.header_t {
	font-weight: bold;
	text-align: center;
	color: white;
	margin-top: -22px;
}
</style>
<script type="text/javascript">
$(document).ready( function(){
    
    //로고 링크
     $(".back").click(function(){
    	 location.replace('hiroad?cmd=account');
     })
 	})
</script>
</head>
<body>
	<form class="ej" action="hiroad?cmd=msgForm" method="POST"
		name="msgForm">
		<div id="header">
			<div class="header_h">
				<div class="header_logo">
					<img class="back"
						src="images/back2.png">
				</div>
			</div>
			<div class="header_t">
				<p>계좌 전송</p>
			</div>
		</div>
		<div class="wrap">
			<div class="title">
			
				<input class="receiver" type="button" value="받는사람"
					onclick="window.location='hiroad?cmd=acSearch'">
				<c:choose>
					<c:when test="${empty receiveId}">
						<input type="text" class="tt" value="${rId}" name="receiveId"
							readonly>
					</c:when>
					<c:otherwise>
						<div class="ridbox">
							<c:forEach items="${receiveId}" var="rId">
								<input type="text" class="receiveId" value="${rId}"
									name="receiveId" readonly>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<input type="hidden"
					class="input" id="subject" value ="계좌가 도착했습니다!" name="msgTitle">
 			<div class="write_part">
				<span class="box_write"> <textarea id="content" class="tx"
						name="msgContent" title="내용" tabindex="2" placeholder="내용"> <%= msg %></textarea>
				</span>
			</div>
			<input class="submit1" type="submit" value="전송">
		</div>
	</form>
</body>
</html>



