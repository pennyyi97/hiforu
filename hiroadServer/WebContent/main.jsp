<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/tab.js"></script>
    <script src="js/tab2.js"></script>
    <script>
      //여기다가 코드 작성
      $(document).ready( function(){
         $("#hide").click(function(){
          $("#tab2_con").hide();
         })
         $("#hide2").click(function(){
          $("#tab2_con").hide();
         })
          $("#show").click(function(){
             $("#tab2_con").show();
         })
      })
    </script>
</head>
<body>
	<jsp:include page="menubar.jsp" />
	<div class="tab_box">
      <ul class="tab" id="tab">
        <li id="hide">한양대/마장</li>
        <li id="hide2">왕십리</li>
        <li id="show">4211</li>
      </ul>  
    </div>
    <div class="tab_con" id="tab_con">
        <div><jsp:include page ="hanma1.jsp" /></div>
        <div class="ww"><jsp:include page ="wang1.jsp" /></div>
        <div class="tt">
          <ul class="tab2" id="tab2">
            <li>상행</li>
            <li>하행</li>
          </ul>
        </div>
    </div>
      <div class="tab2_con" id="tab2_con">
      <div class="ww"><jsp:include page ="busup.jsp" /></div>
      <div class="ww"><jsp:include page ="busdown.jsp" /></div>
    </div>  
</body>
</html>