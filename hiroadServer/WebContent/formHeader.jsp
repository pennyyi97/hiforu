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
	
	function goBack() {
		window.history.back();
	}
</script>
<style>
/* 헤더 높이와 배경색*/
#header {
	height: 60px;
	background: rgb(23, 87, 155);
}

.back {
	margin-top: 20px;
}

.header_t {
	font-weight: bold;
	text-align: center;
	color: white;
	margin-top: -22px;
}
</style>
</head>
<body>
	<div id="header">
		<div class="header_h">
			<div class="header_logo">
				<a href="#" onclick=" goBack()"><img class="back"
					src="images/back2.png"></a>
			</div>
		</div>
		<div class="header_t">
			<p>글쓰기</p>
		</div>

	</div>
</body>
</html>