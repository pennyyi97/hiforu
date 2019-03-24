<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>공지사항</title>
	<meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
	<link rel="stylesheet" type="text/css" href="css/notice.css">
	<link rel="stylesheet" type="text/css" href="css/paging.css">
	<script src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready( function(){
			$(".depth02").hide();
			$("#gnb2 > li > a").on("click",function(){
				
				$(".depth02").slideUp();
				$("img").css('transform','none');
				if(!$(this).next().is(":visible"))
					{
						$(this).next().slideDown();
						$(this).find("img:eq(0)").css('transform','rotate(180deg)');
					}			
				return false;
			})
		})
	</script>
</head>
<body>
<jsp:include page="menubar.jsp" />
<ul id="gnb2">
		<li>
			<c:forEach items="${list}" var="NoticeVO">
			<a href="" id="gnb01" class="depth01">[공지] ${NoticeVO.title}<br> <p>${NoticeVO.date}</p>
			 <img src="images/arrow.png"></a>
			<ul class="depth02">
				<h1>${NoticeVO.contents}
				</h1>
			</ul>
			</c:forEach>
		</li>	
	</ul>
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
            location.href = "hiroad?cmd=notice&page="+page;
          }
    </script>
	</body>
</html>