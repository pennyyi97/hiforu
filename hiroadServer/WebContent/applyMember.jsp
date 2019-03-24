<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>게시판</title>
<meta name="viewport"
	content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/memberList.css">
<link rel="stylesheet" type="text/css" href="css/acSearch.css">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/loginpopup.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/deletepopup.js"></script>
<script>

function setCheckedValue(e) {
	var snums = "";
	var checkedCnt = 0;
	$("[name='receiveId']").each(function(idx, ele) {
		if(ele.checked == true) {
			snums += $(ele).val()+ " ";
			checkedCnt++;
		}
	});
	$("[name='snums']").val(snums);
}
function goBack() {
	window.history.back();
}
</script>
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
.mm {
    top: 25px !important;
}
.msg_list {
margin-top:0!important;
padding:0!important;
}
.sList {
border-top:0 !important;
border-bottom: 1px solid #d0d0d0 !important;
}
</style>
</head>
<body>
<div id="header">
			<div class="header_h">
				<div class="header_logo">
					<a href="#" onclick=" goBack()"><img class="back"
						src="images/back2.png"></a>
				</div>
			</div>
			<div class="header_t">
				<p>동승자 계좌전송</p>
			</div>
			
		</div>
 <div id="wrap1">
                  <div id="container1">
                     <div id="mask1"></div>
                     <div class="window1">
                        <p class="popup1">
                          	 계좌정보를 입력해주세요
                        </p>
                        <div>
                          <input class=" yes" type=button value="YES" onclick="window.location='hiroad?cmd=mypage'">
                           <button class="no">NO</button>
                        </div>
                     </div>
                     </div>
                     </div>
                     
	<div class="msg_list">
	

		
		 <form  action="hiroad?cmd=msg" method="POST" name="msgForm">
		 <c:forEach items="${list}" var="TaxiVO">
		 
					<div class="sList">
						<label for="${MembersVO.snum}" class="mm">${TaxiVO.snum}</label>
						<c:choose>
						<c:when test="${TaxiVO.snum eq login}">
						<input class="aa" type="hidden">
						</c:when>
						<c:otherwise>
							<input class="aa" name="receiveId" type="checkbox" value="${TaxiVO.snum}"
								id="${TaxiVO.snum}" onclick="setCheckedValue(event);">
								</c:otherwise>
								</c:choose>
					</div>
				</c:forEach>
				</form>
				
	</div>
	
	<div class="footer">
		<div class="cart">
			<h3 class="ss">선택한 학번</h3>
			<input type="text" class="text" value="" name="snums" readonly>
		</div>
		<c:if test="${sessionScope.accountBank eq null}">
		
                     <input class=" submit openMask1" type=button value="전송" >
                  
		
		</c:if>
		<c:if test="${sessionScope.accountBank ne null}">
		<input class=" submit" type=button value="전송"onclick="document.msgForm.submit();" >
		</c:if>
	</div>
		
</body>
