<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link rel="stylesheet" type="text/css" href="css/board.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" >
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>택시 게시판</title>
</head>
<body>
<jsp:include page="menubar.jsp" />
	<div class="header">
		<span class="category"> <select
			onchange="location.href=this.value">
				<option value="hiroad?cmd=taxiBoardList">택시</option>
				<option value="hiroad?cmd=boardList">전체</option>
				<option value="hiroad?cmd=lostBoardList">분실물</option>
		</select>
		</span>
		<form class="srch" action="hiroad?cmd=search" method="POST">
			<input type="search" class="srch_put" name="search" placeholder="검색" />
			<input type="submit" class="srch_btn" value="검색">
		</form>
	</div>

	<div class="board_list">
		<table>
			<c:forEach items="${list}" var="BoardVO">
				<tr>
					<td class="cn">[${BoardVO.categoryName}]</td>
					<td class="tt"><a href="hiroad?cmd=detail&num=${BoardVO.boardNum}">${BoardVO.title}</a></td>
					<td class="hit">(${BoardVO.hits})</td>

				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>