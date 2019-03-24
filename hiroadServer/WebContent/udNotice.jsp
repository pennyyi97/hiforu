<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link rel="stylesheet" type="text/css" href="css/ud_notice.css">
<link rel="stylesheet" type="text/css" href="css/paging.css">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, height=device-height, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>게시판</title>
</head>
<body>
<jsp:include page="udnHeader.jsp" />
		<div class="board_list">
			<table>
				<c:forEach items="${list}" var="NoticeVO">
					<tr>
						<td class="cn">[공지사항]</td>
						<td class="tt">${NoticeVO.title}</td>
						<td class="hit">
						<!--  <input type="button" value="수정" class="hit1 update openMask2">
						<input type="button" value="삭제" class="hit2 delete openMask1">  -->
						 <input type="button" class="hit1" value="수정" class="update" onclick="window.location='hiroad?cmd=updateNotice&num=${NoticeVO.noticeNum}'"> 
						 <input  class="hit2" type="button" value="삭제" onclick="window.location='hiroad?cmd=noticeDelete&num=${NoticeVO.noticeNum}'">  
						</td>
					</tr>
					</c:forEach>
			</table>
			<%-- 		<div id="wrap">
				<div id="container1">
					<div id="mask1"></div>
					<div class="window1">
						<p class="popup1">삭제 하시겠습니까?</p>
						<div>
							<input type="button" value="YES" class="yes"
								onclick="window.location='hiroad?cmd=noticeDelete&num=${NoticeVO.noticeNum}'">
							<button class="no">NO</button>
						</div>
					</div>

					
				</div>
			</div> 
				</c:forEach>
			</table>
			
		 <div id="wrap">
				<div id="container2">
					<div id="mask2"></div>
					<div class="window2">
						<p class="popup2">수정 하시겠습니까?</p>
						<div>
							<input type="button" value="YES" class="yes"
								onclick="window.location='hiroad?cmd=updateNotice&num=${NoticeVO.noticeNum}'">
							<button class="no">NO</button>
						</div>
					</div>
					

				</div>
			</div>  --%>
		
		</div>
		<div class="paging">      
	        <ul class="pagination">
	          <li><a href="javascript:PageMove(${paging.firstPageNo})">&lt;&lt;</a></li>
	          <li><a href="javascript:PageMove(${paging.prevPageNo})">&lt;</a></li>
	                <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
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
            location.href = "hiroad?cmd=udNotice&page="+page;
          }
    </script>
</body>