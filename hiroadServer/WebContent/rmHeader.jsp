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
        
        //로고 링크
         $(".back").click(function(){
        	 location.replace('hiroad?cmd=account');
         })
     
         
     	})
    </script>
<style>
/* 헤더 높이와 배경색*/
#header {
	height: 60px;
	background: rgb(23, 87, 155);
}


</style>
</head>
<body>
	<div id="header">
		<div class="header_h">
			
		</div>
	</div>
</body>
</html>