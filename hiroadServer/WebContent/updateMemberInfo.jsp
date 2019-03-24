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
<title>user page</title>
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
	   var form = document.updateMember;
	   
	   if(!form.passwd.value || " " == form.passwd.value){
	      alert("비밀번호를 입력해주세요");
	      form.passwd.focus();
	      return;
	      
	   }
	   if(!form.email.value || " " == form.email.value){
		      alert("이메일을 입력해주세요");
		      form.email.focus();
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
			<img class="user"src="images/user126.png">
		</div>
		
		<div class="wrap">
<form class="ej" action="hiroad?cmd=updateMember" method="post" name="updateMember">
			<div class="content_line">
				<span class="header">학번 </span>
				<div class="num">
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
				
			</div>
			<div class="content_line">
					<span class="header bank">비밀번호</span> <span><input
						type="password" class="input" 
						name="passwd" ></span>
				</div>
			<div class="content_line">
					<span class="header bank">이메일 </span> <span><input
						type="text" class="input" 
						name="email" value="${email}"></span>
				</div>
			
				<div class="content_line">
					<span class="header bank">은행 </span> <span><input
						type="text" class="input" 
						name="accountBank" value="${accountBank}"></span>
				</div>
				<div class="content_line">
					<span class="header">계좌 </span> <span><input type="text"
						class="input" id="account" 
						name="accountNum" value="${accountNum}" ></span>
				</div>
				
				<div class="btn">
				<input class="submit" type="button" value="등록" onclick="javascript:doValidate();" />
			</div>
			</form>
		</div>

		
	 </div>
</body>
</html>