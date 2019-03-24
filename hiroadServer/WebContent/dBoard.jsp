<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>게시판</title>
<meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/d_board.css">


<script src="js/jquery-3.2.1.min.js"></script>
<script>
</script>
</head>
<body>
	<jsp:include page="adHeader.jsp" />
	<div class="wrap">
		<div class="header">
			<span class="category"> <select
				onchange="location.href=this.value">
					<option value="hiroad?cmd=boardList">전체</option>
					<option value="hiroad?cmd=lostBoardList">분실물</option>
					<option value="hiroad?cmd=taxiBoardList">택시</option>
			</select>
			</span>

			<form class="srch" action="hiroad?cmd=search" method="POST">
				<input type="search" class="srch_put" name="search" placeholder=" 검색" />
				<input type="submit" class="srch_btn" value="검색">
			</form>
		</div>


		<div class="board_list">

			<table>
				<tbody>


					<!-- <td><a href="detail.html">왕십리 셔틀에서 지갑을 주웠습니닿</a></td> -->
					<c:forEach items="${list}" var="BoardVO">
						<tr>
							<td class="cn">[${BoardVO.categoryName}]</td>
							<td class="tt"><a href= "hiroad?cmd=detail&num=${BoardVO.boardNum}">${BoardVO.title}</a></td>
							
							<td class="hit">(${BoardVO.hits})</td>
						</tr>
					</c:forEach>



				</tbody>
			</table>
		</div>
		
		
	</div>
</body>
