<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
   content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title></title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/popup.css">
<link rel="stylesheet" type="text/css" href="css/loginpopup.css">
<link rel="stylesheet" type="text/css" href="css/menubar.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/swiper.min.js"></script>
<script src="js/popup.js"></script>
<script src="js/loginpopup.js"></script>
<script>
   $(document).ready(function() {
      $(".btnAll").on("click", function(e) {
         $("#header").toggleClass("close");
         return false;
      })
      $("#gnb > li > a").on("click", function() {
         $(this).next("").stop().slideToggle(500);
         $(this).parent().siblings().children(".depth02").slideUp(500);
         return false;
      })
      //로고 링크
      $(".logo").click(function() {
         location.replace('hiroad?cmd=main');
      })
      // 공지사항 링크
      $("#gnb01").click(function() {
         location.replace('hiroad?cmd=notice');
      })
      // 시간표 링크
      $("#gnb02").click(function() {
         location.replace('hiroad?cmd=timetable');
      })
      //도보 링크
      $("#gnb03").click(function() {
         location.replace('hiroad?cmd=walking');
      })
      //택시 링크
      $("#taxi").click(function() {
         location.replace('hiroad?cmd=taxiList');
      })
      // 계좌 링크
      $("#gnb0s4").click(function() {
         location.replace('hiroad?cmd=account');
      })
      // 게시판 링크
      $("#gnb0s5").click(function() {
         location.replace('hiroad?cmd=boardList');
      })
      // 설정 링크
      $("#gnb0s6").click(function() {
         location.replace('hiroad?cmd=mypage');
      })

      $("#gnb0s9").click(function() {
         location.replace('hiroad?cmd=admin');
      })
      // 식권 구매 링크
      $("#gnb0s8").click(function() {
         location.replace('hiroad?cmd=productList');
      })
      $(".btnAll").click(function () { 
            $("body").each(function (i) { 
               if (this.style.overflow != "hidden") { 
                  this.style.overflow = "hidden"; 
               } else { 
                  this.style.overflow = "visible"; 
               }
            }); 
         });

   })
</script>
<style>
.window1 {
    top: 22% !important;
}
</style>
</head>
<body>
   <div id="header">
      <div class="header_h">
         <div class="header_logo">
            <a><img class="logo" src="images/logo1.png"></a>
         </div>
         <div class="header_menu">
            <a href="" class="btnAll"> <span></span> <span></span> <span></span>
            </a>
         </div>
      </div>
   </div>
   <ul id="gnb">
      <li>
         <div class="menubox"></div>
      </li>
      <li><a href="" id="gnb01" class="depth01">공지사항</a></li>
      <li><a href="" id="gnb02" class="depth01">시간표</a></li>
      <li><a href="" id="gnb03" class="depth01">도보</a></li>
      <c:choose>
         <c:when test="${sessionScope.login ne null}">
            <li><a href="" id="taxi" class="depth01">택시</a></li>
         </c:when>
         <c:when test="${sessionScope.login eq null}">
            <li>
               <div id="wrap1">
                  <div id="container1">
                     <div id="mask1"></div>
                     <div class="window1">
                        <p class="popup1">
                           로그인 하시겠습니까?
                        </p>
                        <div>
                           <button class="yes">YES</button>
                           <button class="no">NO</button>
                        </div>
                     </div>
                     <a href="" id="ntaxi" class="depth01 openMask1">택시</a>
                  </div>
               </div>
            </li>
         </c:when>
      </c:choose>

      <c:choose>
         <c:when test="${sessionScope.login ne null}">
            <li><a href="" id="gnb0s4" class="depth01">계좌전송</a></li>
         </c:when>
         <c:when test="${sessionScope.login eq null}">
            <li>
               <div id="wrap2">
                  <div id="container2">
                     <div id="mask2"></div>
                     <div class="window2">
                        <p class="popup1">
                           로그인 하시겠습니까?
                        </p>
                        <div>
                           <button class="yes">YES</button>
                           <button class="no">NO</button>
                        </div>
                     </div>
                     <a href="" id="ngnb0s4" class="depth01 openMask2">계좌전송</a>
                  </div>
               </div>
            </li>
         </c:when>
      </c:choose>



      <li><a href="" id="gnb0s5" class="depth01">게시판</a></li>


      <li><a href="" id="gnb0s8" class="depth01">식권구매</a></li>

      <li><c:choose>

            <c:when test="${login eq 'hiforu'}">
               <a href="" id="gnb0s9" class="depth01">관리자</a>

            </c:when>


            <c:otherwise>

               <a href="" id="gnb0s6" class="depth01">설정</a>

            </c:otherwise>
         </c:choose> <!-- <a href="" id="gnb0s6" class="depth01">설정</a> --></li>
    <li>
			<div id="wrap">
				<div id="container">
					<div id="mask"></div>
					<div class="window">
						<div class="pheader">
							<p class="popup">
								버전<a href="#" class="close">X</a>
							</p>

						</div>
						<hr>
						<p class="popupcontents">V1.0</p>
					</div>
					<a href="" id="gnb0s7" class="depth01 openMask">버전</a>
				</div>
			</div>
		</li>
   </ul>
</body>
</html>