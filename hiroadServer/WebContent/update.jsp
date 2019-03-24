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
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/popup.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/swiper.min.js"></script>
<script src="js/popup.js"></script>
<script>
function goBack() {
	window.history.back();
}
</script>
</head>
<body>
	
	<form class="ej" action="hiroad?cmd=updateAction" method="POST" name="lostForm">
	 <input type="hidden" name="num" value="${list.boardNum}" />
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
			<input type="submit" class="submit" value="수정">
		</div>
	
<div >
        <div class="title">
        <span class="t_input">${list.name}</span>
         </div>
         <div class="title">
           <input type="text"
               class="t_input" id="subject" name="title" placeholder="제목" value="${list.title}">
         </div>
        <div class="write_part">
            <span class="box_write"><textarea id="content"
                  class="tx" placeholder="내용" name="contents">${list.contents}</textarea></span>
         </div>
   </div>
  </form>
</body>

