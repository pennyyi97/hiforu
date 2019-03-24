<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>게시판</title>
<meta name="viewport"
	content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/sendMessage.css">
<link rel="stylesheet" type="text/css" href="css/paging.css">
<script>
 
/**이부분이 로그인 안 했을 때 뜨는 팝업창*/   
function warning(){
   alert("계좌 정보를 입력해주세요.");
   location.href="hiroad?cmd=mypage";
   return;
}

</script>
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
/*글쓰기버튼*/
.write {
	bottom: 10px;
	position: fixed;
	height: 50px;
	width: 55px;
	border-radius: 50%;
	right: 10px;
	top: px;
	padding: 10px;
	outline: none !important;
	border: 0;
	float: right;
	color: white;
	text-align: center;
	background-color: rgb(23, 87, 155);
	text-decoration: none;
	font-size: 1.1em;
}

.sent_mail {
	width: 24px;
	margin-left: -3px;
}
</style>
<script src="js/jquery-3.2.1.min.js"></script>


</head>
<body>
	<div class="msg_list">
		<table class="et">
			<thead>
				<tr>

					<th scope="col">받은사람</th>
					<th scope="col">제목</th>
					<th scope="col">날짜</th>
					<th scope="col" class="last">수신확인</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list1}" var="MessageVO">
					<tr>
						<td class="cn">${MessageVO.receiveId}</td>
						<td class="tt"><a
							href="hiroad?cmd=msgSendDetail&num=${MessageVO.msgNum}">${MessageVO.msgTitle}</a></td>
						<td class="date">${MessageVO.sendDate}</td>
						<td class="readdate"><c:choose>
								<c:when test="${MessageVO.readDate ne null}">
									<p class="read">읽음</p>
								</c:when>
								<c:otherwise>
									<p class="noread">안읽음</p>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<c:choose>
			<c:when test="${sessionScope.accountBank ne null}">
				<div>
					<button class=" write" OnClick="window.location='hiroad?cmd=msg'">
						<img src="images/sent-mail.png" class="sent_mail">
					</button>
				</div>
			</c:when>
			<c:when test="${sessionScope.accountBank eq null}">
				<button class=" write" OnClick="javascript:warning();">
					<img src="images/sent-mail.png" class="sent_mail">
				</button>
			</c:when>
		</c:choose>
	</div>

</body>
