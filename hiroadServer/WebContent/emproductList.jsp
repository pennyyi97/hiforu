<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" >
<link rel="stylesheet" type="text/css" href="css/productlist.css">
<link rel="stylesheet" type="text/css" href="css/loginpopup.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/tab.js"></script>
<script src="js/loginpopup.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".nav .tab").hide();
		$(".nav .menu").click(function(){
			$(".nav .tab").slideToggle("fast");
		});
	});
</script>
</head>
<body>
   <jsp:include page="menubar.jsp" />
    <div id="wrap4">
		<div id="container4">
		<div id="mask4"></div>
    	<div class="nav">
		    <button class="menu" type="button">교직원식당</button>
		    <div class="tab">
			    <ul class="sub">
			      <li><a href="hiroad?cmd=EmployeeProductList">교직원식당</a></li>
			      <li><a href="hiroad?cmd=productList">학생식당</a></li>
			      <li><a href="hiroad?cmd=ParkProductList">행원파크식당</a></li>
			    </ul>
			     
			</div>
			<a class="chart" href="hiroad?cmd=ticketAmountCat"><i class="fas fa-chart-pie fa-2x"></i></a>
		</div>
	<div class="area">
		<div class="titlev">
	       <div class="head">
	          <dl class="w">
	             <dt>위치</dt>
	             <dd>본관 지하 1층(행원스퀘어 B104)</dd>
	             <dt class="tel">전화</dt>
	             <dd>02-2290-2752</dd>
	             <dt class="time">운영시간</dt>
	             <dd class="indent2">중식 11:30~14:00 / 석식 17:00~18:50 (주문마감)</dd>
	          </dl>
	       </div>
       </div>
      <!--   <div style="margin-bottom:-30px;">
          <a href="https://www.hywoman.ac.kr/ko/cms/CM_ML01_CON/CM_ML01_V01.do?MENU_SN=329">
             <img src="images/link.png" class="link" style="width: 20px; margin: 10px;">
             <p style="float:right; margin-right: 250px; margin-top: 12px;">메뉴보기</p>
          </a>
       </div> -->
       <div class= "plist">
          <ul class="list">
             <c:forEach items="${list}" var="ProductVO">
                <hr>
                <c:choose>
					<c:when test="${sessionScope.login ne null}">
						<a href="hiroad?cmd=productDetail&num=${ProductVO.ticketNum}">
				                   <li class="box">
				                      <img class="img" src="upload${ProductVO.file}" width="100%" height="100%">
				                      <ul class="ticketInfo">
				                         <li class="name">메뉴 : ${ProductVO.ticketName}</li>
				                         <li class="price">가격 : ${ProductVO.price}</li>
				                      </ul>
				                   </li>
				                </a>
					</c:when>
					<c:when test="${sessionScope.login eq null}">
						
									<div class="window4">
										<p class="popup1">로그인 하시겠습니까?
										</p>
										<div>
											<button class="yes">YES</button>
											<button class="no">NO</button>
										</div>
									</div>
									<div class="openMask4">
										<a href="hiroad?cmd=productDetail&num=${ProductVO.ticketNum}">
						                <li class="box">
						                <img class="img" src="upload${ProductVO.file}" width="100%" height="100%">
						                <ul class="ticketInfo">
						                    <li class="name">메뉴 : ${ProductVO.ticketName}</li>
						                    <li class="price">가격 : ${ProductVO.price}</li>
						                </ul>
						                </li>
						                </a>
							</div>
					</c:when>
				</c:choose>

             </c:forEach>
          </ul>
       </div>
       </div>
       </div>
    </div>
</body>
</html>