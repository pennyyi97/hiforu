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

</head>
<body>
	<jsp:include page="backHeader.jsp" />
	<form class="ej" action="hiroad?cmd=updateNoticeAction" method="POST" name="noticeForm">
		<input type="hidden" name="num" value="${list.noticeNum}">
		<div >
			<div class="title">
				<input type="text" class="t_input" id="subject" name="title"
					title="제목" tabindex="1" maxlength="170" value="${list.title}" placeholder="제목"
					autocomplete="on">
			</div>
			<div class="write_part">
				<span class="box_write"> <textarea id="content" class="tx"
						name="contents" title="내용" tabindex="2" placeholder="내용">${list.contents}</textarea>
				</span>
			</div>	
				<button class="submit1" >등록</button>

		</div>
	</form>
</html>
