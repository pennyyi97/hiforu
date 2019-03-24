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
<link rel="stylesheet" type="text/css" href="css/detail.css">
<script src="js/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
	function doValidate() {
		var form = document.comment;

		if (!form.commentContents.value || " " == form.commentContents.value) {
			form.commentContents.focus();
			return;
		}
		form.submit();
	}

	function captureReturnKey(e) {
		if (e.keyCode == 13 && e.srcElement.type != 'textarea')
			return false;
	}
</script>
<style>
.window2 {
	bottom: 40% !important;
}

.window3 {
	bottom: 240px !important;
}
</style>
</head>
<body>
	<jsp:include page="backHeader.jsp" />

	<div class="header">

		<div class="categorytitle">[${list.categoryName}]&nbsp;
			${list.title}</div>
		<br>
		<div class="n">${list.name}<span class="txt_bar">|</span>조회
			${list.hits}
		</div>
		<!-- 여기는 로그인/관리자일 때 수정/삭제 가능하게~!~!하는 부분 -->
		<c:if
			test="${sessionScope.login == list.snum || sessionScope.login == 'hiforu'}">
			<div id="wrap">
				<div id="container2">
					<div id="mask2"></div>
					<div class="window2">
						<p class="popup2">수정 하시겠습니까?</p>
						<div>
							<input type="button" value="YES" class="yes"
								onclick="window.location='hiroad?cmd=update&num=${list.boardNum}'">
							<button class="no">NO</button>
						</div>
					</div>
					<input type="button" value="수정" class="update openMask2">

				</div>
			</div>

			<div id="wrap">
				<div id="container1">
					<div id="mask1"></div>
					<div class="window1">
						<p class="popup1">삭제 하시겠습니까?</p>
						<div>
							<input type="button" value="YES" class="yes"
								onclick="window.location='hiroad?cmd=delete&num=${list.boardNum}'">
							<button class="no">NO</button>
						</div>
					</div>

					<input type="button" value="삭제" class="delete openMask1">
				</div>
			</div>

		</c:if>
		<!-- 여기까지 -->
		<!-- 댓글 삭제 부분 팝업마스크 -->
		<c:forEach items="${clist}" var="commentsVO">
			<div id="container3">
				<div id="mask3"></div>
				<div class="window3">
					<p class="popup3">댓글을 삭제 하시겠습니까?</p>
					<div>
						<input type="button" value="YES" class="yes"
							onclick="window.location='hiroad?cmd=commentDelete&num=${list.boardNum}&cnum=${commentsVO.commentNum}'">
						<button class="no">NO</button>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<br>
	<hr>
	<%
		pageContext.setAttribute("contents", "\n");
	%>
	<div class="contents">
		<p>${fn:replace(list.contents , contents, "</br>")}</p>
		<br>
		<!--  사진  -->
		<c:if test="${list.file ne '/null'}">
			<div class="imgBox">
				<img src="upload${list.file}" width="100%" height="100%">
			</div>
		</c:if>
		<!-- 여기까지 contents랑 같은 위치 -->
	</div>
	

	<c:if test="${sessionScope.login ne null}">
		<div class="comments">

			<!-- 여기도 로그인 안 하면 댓글 쓸 수 없게 했는데 이것도 글쓰기처럼 바꿀 수 있으니 추후수정!  -->

			<div>
				<form class="ej" action="hiroad?cmd=commentAction" method="POST"
					name="comment" onkeydown="return captureReturnKey(event)">
					<input type="hidden" name="num" value="${list.boardNum}"> <input
						type="hidden" class="input" id="c_name" name="commentName"
						value="익명">


					<div class="content_line">
						<textarea id="c_contents" class="text" name="commentContents"></textarea>
					</div>

					<input type="button" value="등록" class="c_submit"
						onclick="javascript:doValidate();">
				</form>
			</div>

			<!-- 여기까지 -->

		</div>
	</c:if>
	<c:choose>
		<c:when test="${!empty clist }">
			<div class="comm">

				<c:forEach items="${clist}" var="commentsVO">
					<ul class="commm">
						<li class="comm2">
							<div class="comm3">${commentsVO.commentName}
								<span class="txt2_bar">|</span> ${commentsVO.date}
							</div>
							<div class="comm4">
								<c:if
									test="${sessionScope.login == commentsVO.snum || sessionScope.login == 'hiforu'}">
									<div id="wrap">
										<!-- <div id="container3">
											<div id="mask3"></div> -->
										<%-- <div class="window3">
											<p class="popup3">댓글을 삭제 하시겠습니까?</p>
											<div>
												<input type="button" value="YES" class="yes"
													onclick="window.location='hiroad?cmd=commentDelete&num=${list.boardNum}&cnum=${commentsVO.commentNum}'">
												<button class="no">NO</button>
											</div>
										</div> --%>
										<input type="button" value="삭제" class="c_delete openMask3">
										<!-- </div> -->
									</div>
								</c:if>
							</div> <!-- 여기부터  --> <!-- 여기까지  -->

						</li>
						<li class="tr_comm5">
							<div class="comm5">${commentsVO.commentContents}</div>

						</li>

					</ul>


				</c:forEach>
			</div>
		</c:when>
		<c:otherwise>
			<div></div>
		</c:otherwise>
	</c:choose>

</body>
</html>