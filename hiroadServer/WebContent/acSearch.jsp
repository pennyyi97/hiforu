<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/acSearch.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" >
<script src="js/jquery-3.2.1.min.js"></script>
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
	if(checkedCnt > 3) {
		e.preventDefault();
		alert("\n 전송가능한 인원을 초과하였습니다.\n\n\n* 최대 전송 가능 인원은 3명입니다.");
		return;
	}
	
	$("[name='snums']").val(snums);
}
</script>
<style type="text/css">
</style>
</head>
<body>
<jsp:include page="mfHeader.jsp" />

	<div class="header">
		<form class="srch" action="hiroad?cmd=searchMember" method="POST">
			<input type="search" class="srch_put" name="search" placeholder=" 검색" />
			<span class="icon"><i class="fa fa-search"></i></span>
		</form>
	</div>
	<div class="snum_list">
		<ul>
			<li class="ec">
		    <form  action="hiroad?cmd=msg" method="POST" name="msgForm">
			<c:forEach items="${list}" var="MembersVO">
					<div class="sList">
						<img class="user4" src="images/user4.png">
							<label for="${MembersVO.snum}" class="mm">${MembersVO.snum}</label>
							<input class="aa" name="receiveId" type="checkbox" value="${MembersVO.snum}"
								id="${MembersVO.snum}" onclick="setCheckedValue(event);">
					</div>
				</c:forEach>
				</form>
				</li>
		</ul>
	</div>
	<div class="footer">
		<div class="cart">
			<h3 class="ss">선택한 학번</h3>
			<input type="text" class="text" value="" name="snums" readonly>
		</div>
		<input class=" submit" type=button value="전송" onclick="document.msgForm.submit();" >
	</div>
</body>
</html>