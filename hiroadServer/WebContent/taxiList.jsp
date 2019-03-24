<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>게시판</title>
<meta name="viewport"
	content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/taxiList.css">
<link rel="stylesheet" type="text/css" href="css/paging.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" >
<script src="js/jquery-3.2.1.min.js"></script>
<script>
function warning(){
	   alert("로그인이 필요한 서비스입니다.");
	   window.location='hiroad?cmd=login';
	}
</script>
</head>
<body>
	<jsp:include page="menubar.jsp" />

	<div class="taxi_list">

		<table class="et">
			<thead>
				<tr>

					<th scope="col">작성자</th>
					<th scope="col">제목</th>
					<th scope="col">인원수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="TaxiVO">
					<tr>
						<td class="cn">${TaxiVO.snum}</td>
						<td class="tt">${TaxiVO.title }</td>
						<td class="date"><input type="button" class="hit1"
							value="${TaxiVO.wantPeople}/${TaxiVO.people}" class="update"
							onclick="window.location='hiroad?cmd=taxiDetail&num=${TaxiVO.taxiNum}'"></td>
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
            location.href = "hiroad?cmd=taxiList&page="+page;
          }
    </script>
	<div class="footer">
		<c:choose>
			<c:when test="${sessionScope.login ne null}">
				<div>
               <button class=" write"
                  OnClick="window.location='hiroad?cmd=taxi'"><i class="fas fa-pencil-alt"></i></button>
            </div>
			</c:when>
			<c:when test="${sessionScope.login eq null}">
				<button class=" write"
                  OnClick="javascript:warning();"><i class="fas fa-pencil-alt"></i></button>
			</c:when>
		</c:choose>
	</div>
</body>
