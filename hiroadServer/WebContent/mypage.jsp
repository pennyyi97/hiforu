<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/mypage.css">
<link rel="stylesheet" type="text/css" href="css/loginpopup.css">

<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/loginpopup.js"></script>
<script>
	$(document).ready(function() {
		$(".bookmark").click(function() {
			location.replace('hiroad?cmd=bookmark');
		})

		$(".cart").click(function() {
			location.replace('hiroad?cmd=cart');
		})
		$(".cart2").click(function() {
			location.replace('hiroad?cmd=ticketAmoutPersonal');
		})

	})
</script>
</head>
<body>
	<jsp:include page="menubar.jsp" />
	<div class="set_all">
		<div class="set_text">계좌</div>
		<div class="set_info">
			<img class="user" src="images/user126.png">
			<c:choose>
				<c:when test="${!empty login && !empty accountBank}">
					<div class="set_info_detail">
						<div class="set_info_snum">학번 : ${login}</div>
						<div class="set_info_bank">은행 : ${accountBank}</div>
						<div class="set_info_bnum">계좌 : ${accountNum}</div>
					</div>
				</c:when>
				<c:when test="${!empty login && empty accountBank}">
					<div class="content_line">
						<div class="num">
							${login}&nbsp;님
							<button class="infobutton"
								onclick="window.location='hiroad?cmd=accountInfo'">
								계좌<br />입력하기
							</button>
						</div>
					</div>

				</c:when>
				<c:otherwise>
					<div class="content_line">
						<div class="num2">
							<h1 class="nct">로그인이 필요한 서비스 입니다.</h1>
						</div>
					</div>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
	<c:choose>
		<c:when test="${!empty login}">
			<div class="set_text">식권</div>
			<div class="cart">
				<div class="cart_txt">식권 구매 내역</div>
			</div>
			<div class="cart2">
				<div class="cart_txt">식권 구매 통계</div>
			</div>
			<div class="set_text">회원정보</div>
			<div class="member">

				<div class="member_txt">
					<a href="hiroad?cmd=updateMemberInfo">회원 정보 수정</a>
				</div>
			</div>
			<div class="set_text2"></div>
			<div class="logout">

				<div class="logout_txt">


					<a href="hiroad?cmd=logout">로그아웃</a>
				</div>
			</div>
			<div class="set_text2"></div>
			<div class="logout">
				<div class="logout_txt">
					<a href="hiroad?cmd=deleteMember">회원 탈퇴</a>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="set_text2"></div>
			<div class="logout">
				<div class="logout_txt">
					<a href="hiroad?cmd=signup">회원가입</a>
				</div>
			</div>
			<div class="set_text2"></div>
			<div class="logout">
				<div class="logout_txt">
					<a href="hiroad?cmd=login">로그인</a>
				</div>
			</div>
			<!-- 광고문의 -->
				<div class="set_text2"></div>
			<div class="logout">
				<div class="logout_txt">
				<div id="wrap">
				<div id="container">
					<div id="mask5"></div>
					<div class="window5">
						<div class="pheader">
							<p class="popup5">
								광고 문의<a href="#" class="close">X</a>
							</p>

						</div>
						<hr>
						<p class="popupcontents2">hywmforu@gmail.com</p>
					</div>
					<a href=""class="depth01 openMask5">광고 문의</a>
					</div>
					</div>
				</div>
			</div>
		</c:otherwise>
		

	</c:choose>
</body>
</html>