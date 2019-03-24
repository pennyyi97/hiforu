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
<link rel="stylesheet" type="text/css" href="css/form.css">
<style>
.submit {
	margin-top: 17.66em;
	display: block;
	width: 100%;
	height: 43px;
	background: rgb(23, 87, 155);
	border: 1px solid rgba(0, 0, 0, .1);
	font-size: 15px;
	font-weight: 700;
	color: #fff;
	z-index: 10;
}
</style>
<script type="text/javascript">
function doValidate() {
   var form = document.noticeForm;
   

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
   
   form.submit();
   
}
</script>
</head>
<body>
	<jsp:include page="unHeader.jsp" />
	<form class="ej" action="hiroad?cmd=noticeFormAction" method="POST" name="noticeForm">
		<div >
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
				<input type="button" value="등록" class="submit1" onclick="javascript:doValidate();">
		</div>
	</form>
</html>
</html>