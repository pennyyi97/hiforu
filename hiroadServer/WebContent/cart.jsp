<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/cart.css">
<link rel="stylesheet" type="text/css" href="css/paging.css">
</head>
<body>
   <jsp:include page="cartHeader.jsp" />
   <div>
      <p class="title">식권 구매 내역</p>
      <p class="rr">※클릭하시면 QR코드 화면으로 이동됩니다.</p>
      <ul class="list">
            <c:forEach items="${list}" var="ProductVO">
              <a href="qrcode.jsp">
            	<li class="box">
         			<img class="img" src="upload${ProductVO.file}" width="100%" height="100%">
               		<ul class="listbox">
	                  <li>메뉴 | ${ProductVO.ticketName}</li>
	                  <li>날짜 | ${ProductVO.date}</li>
	                  <li>가격 | ${ProductVO.price}</li>
               		</ul>
               	</li>
            </a>
            </c:forEach>
      </ul>
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
            location.href = "hiroad?cmd=cart&page="+page;
          }
    </script>
</body>
</html>