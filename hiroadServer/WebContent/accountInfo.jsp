<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title></title>
<link rel="stylesheet" type="text/css" href="css/account_info.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css">

<style>
.nct {
	letter-spacing: -2px;
}
</style>
<script>
function doValidate() {
	   var form = document.accountInfo;
	   
	   if(!form.accountBank.value || " " == form.accountBank.value){
	      alert("은행을 입력해주세요");
	      form.accountBank.focus();
	      return;
	      
	   }
	   if(!form.accountNum.value || " " == form.accountNum.value){
	      alert("계좌를 입력해주세요");
	      form.accountNum.focus();
	      return;
	   }
	  
	   
	   form.submit();
	   
	}	
</script>
</head>
<body>

	<jsp:include page="mpHeader.jsp" />


	 <div class="all"> 
		<div class="imgbox">
			<img src="images/user126.png">
		</div>
		
		<div class="wrap">
<form action="hiroad?cmd=updateAccount" method="post" name="accountInfo">
			<div class="content_line ">
				<span class="header  ">학번 </span>
				<div class="num ">
					<%-- ${login} --%>
					<c:choose>
						<c:when test="${!empty login}">
		 					${login}
		
						</c:when>
						<c:otherwise>
							<h1 class="nct">로그인이 필요한 서비스 입니다.</h1>

						</c:otherwise>
					</c:choose>
				</div>
				<!-- <span><input type="text" class="input" id="snum" placeholder="학번을 입력해주세요"></span> -->
			</div>
			
				<div class="content_line">
					<span class="header bank">은행 </span> <span><input
						type="text" class="input" placeholder="은행을 입력해주세요"
						name="accountBank"></span>
					<!-- <select id="accountBank"  name="accountBank" onchange="alert(this.options[this.selectedIndex].text)">


					<option value="우리은행" >우리은행</option>
					<option value="국민은행" >국민은행</option>
					<option value="카카오뱅크" >카카오뱅크</option>
					<option value="신한은행" >신한은행</option>
					<option value="하나은행" >하나은행</option>
					<option value="농협" >농협</option>
				</select> -->
				</div>
				<div class="content_line account">
					<span class="header gg">계좌 </span> <span><input type="text"
						class="input " id="account" placeholder="계좌번호를 입력해주세요"
						name="accountNum" ></span>
				</div>
				<h6 class="h6">
					<i class="fas fa-exclamation-circle"></i> 택시 계좌 정보 전송 서비스 이용시
					사용됩니다.
				</h6>
				<div class="btn">
				<input class="submit" type="button" value="등록" onclick="javascript:doValidate();" />
			</div>
			</form>
		</div>

		
	 </div>
</body>
</html>