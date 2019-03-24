<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>게시판</title>
<meta name="viewport"
	content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/memberList.css">
<link rel="stylesheet" type="text/css" href="css/paging.css">
<script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<jsp:include page="mlHeader.jsp" />

	<div class="msg_list">

		<table class="et">
			<thead>
				<tr>

					<th scope="col">아이디</th>
					<th scope="col">비밀번호</th>
					<th scope="col">이메일</th>
					<th scope="col">탈퇴</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="MembersVO">
					<tr class="list">
						<td class="name" name="snum">${MembersVO.snum}</td>
						<td>${MembersVO.passwd}</td>
						<td>${MembersVO.email}</td>
						<c:choose>
							<c:when test="${MembersVO.snum ne 'hiforu'}">
								<td>
								<input class="delete" type="button" value="탈퇴"
														onclick="window.location='hiroad?cmd=releaseMember&snum=${MembersVO.snum}'">
									<%-- <div id="wrap">
										<div id="container1">
											<div id="mask1"></div>
											<div class="window1">
												<p class="popup1">삭제 하시겠습니까?</p>
												<div>
													<input class="yes" type="button" value="YES"
														onclick="window.location='hiroad?cmd=releaseMember&snum=${MembersVO.snum}'">
													<button class="no">NO</button>
												</div>
											</div>
											<input type="button" value="탈퇴" class="delete openMask1">
										</div>
									</div> --%>
								</td>
							</c:when>
							<c:otherwise>
								<td class="admin">관리자</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="paging">
		<ul class="pagination">
			<li><a href="javascript:PageMove(${paging.firstPageNo})">&lt;&lt;</a></li>
			<li><a href="javascript:PageMove(${paging.prevPageNo})">&lt;</a></li>
			<c:forEach var="i" begin="${paging.startPageNo}"
				end="${paging.endPageNo}" step="1">
				<c:choose>
					<c:when test="${i eq paging.pageNo}">
						<li class="active"><a href="javascript:PageMove(${i})">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="javascript:PageMove(${i})">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<li><a href="javascript:PageMove(${paging.nextPageNo})">&gt;</a></li>
			<li><a href="javascript:PageMove(${paging.finalPageNo})">&gt;&gt;</a></li>
		</ul>
	</div>

	<script type="text/javascript">
        function PageMove(page){
            location.href = "hiroad?cmd=memberList&page="+page;
          }
    </script>
</body>
