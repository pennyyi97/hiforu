<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="css/form.css">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/popup.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/swiper.min.js"></script>
<script src="js/popup.js"></script>

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
.filebox label {
	display: inline-block;
	padding: .5em .75em;
	color: #999;
	font-size: inherit;
	line-height: normal;
	vertical-align: middle;
	background: url(images/image.png) no-repeat !important; 
	width: 32px;
	height: 32px;
	cursor: pointer;
	border-radius: .25em;
}
</style>
<script type="text/javascript">
var doubleCheck = false;
function check(){
   if(doubleCheck){
      return doubleCheck;
   }else{
      doubleCheck = true;
      return false;
   }
}
function doValidate() {
   var form = document.lostForm;
   
   if(!form.name.value || " " == form.name.value){
      alert("작성자를 입력해주세요");
      form.name.focus();
      return;
      
   }
   if(!form.title.value || " " == form.title.value){
      alert("제목을 입력해주세요");
      form.title.focus();
      return;
   }
   if(!form.contents.value || " " == form.contents.value){
      alert("내용을 입력해주세요");
      form.contents.focus();
      return;
   }
   if(check())return;
   
   form.submit();
}
	function goBack() {
		window.history.back();
	}
	$(document).ready(function(){ 
		var fileTarget = $('.filebox .upload-hidden');
		
		fileTarget.on('change', function(){
		 if(window.FileReader){ 
			 var filename = $(this)[0].files[0].name; 
			 }
		 else {
			 var filename = $(this).val().split('/').pop().split('\\').pop(); 
			 }
		 $(this).siblings('.upload-name').val(filename); 
		 }); 
		}); 
</script>

</head>
<body>

	<form class="ej" action="hiroad?cmd=lostForm" method="POST"
		name="lostForm" enctype="multipart/form-data">
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
			<input type="button" value="등록" class="submit"
				onclick="javascript:doValidate();">
		</div>
		<div>
			<div class="category">
				<label for="boardSelectList" class="sr_only">게시판 카테고리</label>
				 <select
					id="boardSelectList" name="" class="opt_select opt_on" onchange="location.href=this.value">
					<option value="hiroad?cmd=lost">분실</option>
					<option value="hiroad?cmd=get">습득</option>
					
				</select> <span><img src="images/arrow.png" class="arrow"></span>
			</div>


			<div class="title">
				<input type="text" class="t_input" id="inputUserName" name="name"
					tabindex="1" maxlength="170" value="" placeholder="작성자"
					autocomplete="on">
			</div>

			<div class="title">
				<input type="text" class="t_input" id="subject" name="title"
					title="제목" tabindex="1" maxlength="170" value="" placeholder="제목"
					autocomplete="on">
			</div>
			<div class="write_part">
				<span class="box_write"> <textarea id="content" class="tx"
						name="contents" title="내용" tabindex="2" placeholder="내용"></textarea>
				</span>
			</div>

			<div class="write_set">
				<!-- <span class="header">파일첨부 </span>  -->
				<div class="btn_img" title="이미지 첨부">
					<div class="mg filebox">
						<!-- 	<i class="far fa-image"></i> -->
						<label for="ex_filename"></label> <input type="file" name="file"
							id="ex_filename" class="upload-hidden"> <input
							class="upload-name" disabled="disabled">
					</div>
				</div>
			</div>
		</div>

	</form>
</body>
</html>



