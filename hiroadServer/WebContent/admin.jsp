<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/admin.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script>
   $(document).ready( function(){
      // 공지사항 등록
       $(".set_notice").click(function(){
             location.replace('hiroad?cmd=noticeForm');
         })
         // 공지사항 수정,삭제
          $(".set_notice2").click(function(){
             location.replace('hiroad?cmd=udNotice');
         })
         // 게시판 수정,삭제
          $(".board").click(function(){
             location.replace('hiroad?cmd=boardList');
         })
         // 공지사항 수정,삭제
          $(".memberList").click(function(){
             location.replace('hiroad?cmd=memberList');
         })
         
   })
</script>
</head>
<body>
	<jsp:include page="menubar.jsp" />
	<div class="admin_all">
		<div class="set_text">공지사항</div>


		<div class="set_notice">
			<div class="c_notice">공지사항 등록</div>

		</div>
		<div class="set_notice2">
			<div class="ud_notice">공지사항 수정/삭제</div>

		</div>
		
	
		<div class="set_text">게시판</div>
		<div class="board">
			<div class="ud_board">게시물 삭제</div>
		</div>
		<div class="set_text">회원관리</div>
		<div class="member">
			<div class="memberList">회원 목록</div>
		</div>
		<div class="logout">
		<div class="logout_txt"> 
<a href="hiroad?cmd=logout">로그아웃</a>	
		</div>
	</div>
	</div>
</body>
</html>