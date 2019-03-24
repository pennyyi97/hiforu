<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>walking</title>
<meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<script src="js/jquery-2.1.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/navi.css">
<script type="text/javascript">
	$(document).ready(function(){
		$(".nav .sub").hide();
		$(".nav .menu").click(function(){
			$(".nav .sub").slideToggle("fast");
		});
	});
</script>
</head>
<body>
<jsp:include page="menubar.jsp" />
 <div class="nav">
    <button class="menu">출발지와 도착지를 선택하시오 ▽</button>
    <ul class="sub" id="walkingul">
      <li><a href="exit2bon.jsp">한양대역 2번 출구 ~ 본관</a></li>
      <li><a href="exit3bon.jsp">한양대역 3번 출구 ~ 본관</a></li>
      <li><a href="wang6bon.jsp">왕십리역 6번 출구 ~ 본관</a></li>
      <li><a href="mj3bon.jsp">마장역 3번 출구 ~ 본관</a></li>
      <li><a href="exit2sik.jsp">한양대역 2번 출구 ~ 식영관</a></li>
      <li><a href="exit3sik.jsp">한양대역 3번 출구 ~ 식영관</a></li>
      <li><a href="wang6sik.jsp">왕십리역 6번 출구 ~ 식영관</a></li>
      <li><a href="mj3sik.jsp">마장역 3번 출구 ~ 식영관</a></li>
      <li><a href="exit2jung.jsp">한양대역 2번 출구 ~ 정보관</a></li>
      <li><a href="exit3jung.jsp">한양대역 3번 출구 ~ 정보관</a></li>
      <li><a href="wang6jung.jsp">왕십리역 6번 출구 ~ 정보관</a></li>
      <li><a href="mj3jung.jsp">마장역 3번 출구 ~ 정보관</a></li>
    </ul>
</div>
</body>
</html>