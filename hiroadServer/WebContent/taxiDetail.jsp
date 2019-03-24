<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Detail</title>
<link rel="stylesheet" type="text/css" href="css/menubar.css">
<link rel="stylesheet" type="text/css" href="css/taxiDetail.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	var doubleCheck = false;
	function check() {
		if (doubleCheck) {
			return doubleCheck;
		} else {
			doubleCheck = true;
			return false;
		}
	}

	function doValidate() {
		var form = document.tcom;

		if (!form.tContents.value || " " == form.tContents.value) {
			form.tContents.focus();
			return;
		}

		if (check())
			return;

		form.submit();
	}

	function captureReturnKey(e) {
		if (e.keyCode == 13 && e.srcElement.type != 'textarea')
			return false;
	}
</script>
<style>
.window3 {
	bottom: 260px !important;
}
.window2 {
	bottom: 40% !important;
}
</style>
</head>
<body>
	<jsp:include page="backHeader.jsp" />

	<div class="header">

		<div class="categorytitle">${list.title }</div>
		<br>
		<div class="n">${list.snum }

			<c:if
				test="${sessionScope.login == list.snum || sessionScope.login == 'hiforu'}">
				<div id="wrap">
					<div id="container1">
						<div id="mask1"></div>
						<div class="window1">
							<p class="popup1">삭제 하시겠습니까?</p>
							<div>
								<input type="button" value="YES" class="yes"
									onclick="window.location='hiroad?cmd=taxiDelete&num=${list.taxiNum}'">
								<button class="no">NO</button>
							</div>
						</div>
						<input type="button" value="삭제" class="delete openMask1">
					</div>
				</div>
			</c:if>
			<%-- <button class="apply" onclick="window.location='hiroad?cmd=applyMember&num=${list.taxiNum}'">동승자 목록</button> --%>
		</div>
		<hr>


		<span class="txt"><i class="fas fa-check"></i>&nbsp;확인사항</span>
		<div class="info">
			<span class="header1">장소</span>
			<div class="location">${list.location }</div>
			<span class="header1">시간 </span>
			<div class="time location">${list.time }</div>
			<span class="header1">동승자</span>
			<div class="people location">${list.people }명</div>
			<c:if
				test="${sessionScope.login == tvo.snum || sessionScope.login == list.snum}">
				<div class="applybtn">
					<button class="apply"
						onclick="window.location='hiroad?cmd=applyMember&num=${list.taxiNum}'">
						동승자 목록&nbsp;<i class="fas fa-caret-right"></i>
					</button>
				</div>
			</c:if>
		</div>

		<div class="contents">${list.contents }</></div>
	<!--댓글 삭제 팝업 -->
		<c:forEach items="${tcom}" var="TaxiCommentsVO">
		<div id="wrap">
			<div id="container3">
				<div id="mask3"></div>
				<div class="window3">
					<p class="popup3">댓글을 삭제 하시겠습니까?</p>
					<div>
						<input type="button" value="YES" class="yes"
							onclick="window.location='hiroad?cmd=tcomDelete&num=${list.taxiNum}&tcomnum=${TaxiCommentsVO.tcomNum}'">
						<button class="no">NO</button>
					</div>
				</div>
			</div>
			
			</div>
			</c:forEach>
		<!--신청취소 팝업 -->
			<div id="wrap">
			<div id="container2">
				<div id="mask2"></div>
				<div class="window2">
					<p class="popup2">신청 취소하시겠습니까?</p>
					<div>
						<input type="button" class="yes" value="YES"
							onclick="window.location='hiroad?cmd=taxiCancel&num=${list.taxiNum}'">
						<button class="no">NO</button>
					</div>
				</div>
			</div>
			
			</div>
			
				<c:if
					test="${sessionScope.login == tvo.snum || sessionScope.login == list.snum}">
					<div class="comments">
					<div>
						<form action="hiroad?cmd=tcomAction" method="POST" name="tcom"
							onkeydown="return captureReturnKey(event)">
							<input type="hidden" name="num" value="${list.taxiNum}">

							<div class="content_line">
								<textarea id="c_contents" class="text" name="tContents"></textarea>
							</div>

							<input type="button" value="등록" class="c_submit"
								onclick="javascript:doValidate();">
						</form>
					</div>
					</div>
				</c:if>
			

			<c:choose>
				<c:when test="${!empty tcom }">
					<div class="comm">
						<c:if
							test="${sessionScope.login == tvo.snum || sessionScope.login == list.snum}">
							<c:forEach items="${tcom}" var="TaxiCommentsVO">
								<ul class="commm">
									<li class="comm2">
										<div class="comm3">${TaxiCommentsVO.snum}
											<span class="txt2_bar">|</span> ${TaxiCommentsVO.date}
										</div>
										<div class="comm4">
											<c:if
												test="${sessionScope.login == TaxiCommentsVO.snum || sessionScope.login == 'hiforu'}">
												<input type="button" value="삭제" class="c_delete openMask3">
											</c:if>
										</div>

									</li>
									<li class="tr_comm5">
										<div class="comm5">${TaxiCommentsVO.tContents}</div>
									</li>
								</ul>
							</c:forEach>
						</c:if>
					</div>
				</c:when>
				<c:otherwise>
					<div></div>
				</c:otherwise>
			</c:choose>


			<c:choose>
				<c:when test="${list.wantPeople eq list.people}">
					<c:if
						test="${sessionScope.login ne tvo.snum && list.taxiNum ne tvo.taxiNum && sessionScope.login ne list.snum}">
						<input type="button" class="end" value="마감" disabled>
					</c:if>
					<c:if
						test="${sessionScope.login eq tvo.snum && list.taxiNum eq tvo.taxiNum}">
						<input type="button" class="delete1 openMask2" value="신청취소">
					</c:if>

				</c:when>

				<c:when
					test="${sessionScope.login ne list.snum && sessionScope.login ne tvo.snum}">
					<input class="join" type="button" value="신청하기"
						onclick="window.location='hiroad?cmd=taxiSignon&num=${list.taxiNum}'">
				</c:when>
				<c:when
					test="${sessionScope.login eq tvo.snum && list.taxiNum eq tvo.taxiNum}">
					<input type="button" class="delete1 openMask2" value="신청취소">
					<%-- <input type="button" class="delete1" value="신청취소"
						onclick="window.location='hiroad?cmd=taxiCancel&num=${list.taxiNum}'"> --%>
				</c:when>

			</c:choose>
		</div>
</body>
</html>