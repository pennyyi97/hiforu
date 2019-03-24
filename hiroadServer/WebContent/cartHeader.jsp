<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
   content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title></title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/popup.css">

<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/swiper.min.js"></script>
<script src="js/popup.js"></script>
<script>
       $(document).ready( function(){
           $(".back").click(function(){
              location.replace('hiroad?cmd=mypage');
           });
        });
</script>
<style>
/* 헤더 높이와 배경색*/
#header {
   height: 60px;
   background: rgb(23, 87, 155);
}
.back {
   padding: 0 5px;
   margin-top: 20px;
}
.pp {
   text-align: center;
   color: white;
   font-weight: bold;
   margin-top: -20px;
}


</style>
</head>
<body>
   <div id="header">
      <div class="header_h">
         <div class="header_logo">
            <a><img class="back" src="images/back2.png"></a>
            <div class="pp">식권 구매 내역</div>
         </div>
      </div>
   </div>
</body>
</html>