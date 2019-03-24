<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/popup.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
<link rel="stylesheet" type="text/css" href="css/taxiForm.css">

<!-- 여기부터 -->
<script type="text/javascript">
function doValidate() {
   var form = document.taxiForm;
   
   if(!form.title.value || " " == form.title.value){
      alert("제목을 입력해주세요");
      form.title.focus();
      return;
   }
   if(!form.location.value || " " == form.location.value){
       alert("장소를 입력해주세요");
	   form.location.focus();
	   return;
   }
   if(!form.time.value || " " == form.time.value){
	   alert("시간을 입력해주세요");
	   form.time.focus();
	   return;
   }
   if(form.people.value == ''){
	     alert("동승자 인원을 선택해주세요");
	     form.people.focus();
	     return;
	  }

   form.submit();
}
function goBack() {
	window.history.back();
}
</script>
<!--여기까지-->
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
			<p>동승자 모집신청</p>
		</div>
	</div>
	<div>
		<form class="ej" action="hiroad?cmd=taxiForm" method="POST"
			name="taxiForm">
			<div class="title">
				<input type="text" class="t_input" id="subject" name="title"
					title="제목" tabindex="1" maxlength="170" value="" placeholder="제목"
					autocomplete="on">
			</div>
			<div class="title">
				<input type="text" class="t_input" id="subject" name="location"
					title="장소" tabindex="1" maxlength="170" value=""
					placeholder="만남 장소" autocomplete="on">
			</div>
			<div class="title">
				<input type="text" class="t_input" id="inputUserName" name="time"
					tabindex="1" maxlength="170" value="" placeholder="만남 시간"
					autocomplete="on">
			</div>
			<div class="join">
				<label for="joinSelectList" class="sr_only">동승자</label> <select
					id="joinSelectList" name="people" class="opt_select opt_on">

					<option value="" selected="selected">동승자</option>
					<option value=3>3</option>
					<option value=2>2</option>
					<option value=1>1</option>
				</select> <span><img src="images/arrow.png" class="arrow"></span>
			</div>
			<div class="write_part">
				<span class="box_write"> <textarea id="content" class="tx1"
						name="contents" title="내용" tabindex="2" placeholder="추가 내용"></textarea>
				</span>
			</div>
			<input type="button" class="submit1" value="등록"
				onclick="javascript:doValidate();">
		</form>
	</div>
</body>
</html>
