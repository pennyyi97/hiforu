<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
<title>게시판</title>
<meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/board.css">
<link rel="stylesheet" type="text/css" href="css/paging.css">
<link rel="stylesheet" type="text/css" href="css/loginpopup.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" >
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/loginpopup.js"></script>
<script>
   if (self.name != 'reload') {
      self.name = 'reload';
      self.location.reload(true);
   } else
      self.name = '';
/**이부분이 로그인 안 했을 때 뜨는 팝업창*/   
function warning(){
   alert("로그인이 필요한 서비스입니다.");
   location.href="hiroad?cmd=login";
   return;
}

</script>

</head>
<body>
	<jsp:include page="menubar.jsp" />
	<div class="wrap">
		<div class="header">
			
			<form class="srch" action="hiroad?cmd=search" method="POST">
			<select class="select" name="cat" onchange="location.href=this.value">
               <option value="hiroad?cmd=boardList">전체</option>
               <option value="hiroad?cmd=lostBoardList">분실</option>
               <option value="hiroad?cmd=getBoardList">습득</option>
            </select>
			
				<input type="search" class="srch_put" name="search" placeholder=" 검색" />
				<input type="submit" class="srch_btn" value="검색">
			</form>
		</div>
		<div class="board_list">
			<table>
				<tbody>		
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
        	 location.href = "hiroad?cmd=boardList&page="+page;
          }
    </script>
		
       <div >
      <c:choose>
         <c:when test="${sessionScope.login ne null}">
            <div>
               <button class=" write"
                  OnClick="window.location='hiroad?cmd=lost'"><i class="fas fa-pencil-alt"></i></button>
            </div>
         </c:when>
         <c:when test="${sessionScope.login eq null}">
               <div id="wrap3">
                  <div id="container3">
                     <div id="mask3"></div>
                     <div class="window3">
                        <p class="popup1">
                           로그인 하시겠습니까?
                        </p>
                        <div>
                           <button class="yes">YES</button>
                           <button class="no">NO</button>
                        </div>
                     </div>
                     <button class="write openMask3"><i class="fas fa-pencil-alt"></i></button>
                  </div>
               </div>
         </c:when>
      </c:choose>
      </div>
   
</body>
