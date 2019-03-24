<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>게시판</title>
<meta name="viewport"
	content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/sendMessage.css">
<link rel="stylesheet" type="text/css" href="css/paging.css">
<style>
table th {
	font-style: bold;
	height: 26px;
	padding: 0;
	padding-top: 2px;
	vertical-align: middle;
	text-align: center;
	font-size: 12px;
	color: #000;
	background: none;
	
	background-color: #fff;
}
</style>
<script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div class="msg_list">
		<table class="et">
			<thead>
				<tr>
					<th scope="col">보낸사람</th>
					<th scope="col">제목</th> 
					<th scope="col">날짜</th>	
				</tr>
			</thead> 
			<tbody>
				 <c:forEach items="${list}" var="MessageVO">	 
					<tr>		
						<td class="cn">${MessageVO.sendId}</td>
						<td class="tt"><a href= "hiroad?cmd=msgReceiveDetail&num=${MessageVO.msgNum}">${MessageVO.msgTitle}</a></td>
						<td class="date">${MessageVO.sendDate}</td>
					</tr>		
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
