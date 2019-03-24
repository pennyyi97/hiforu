<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<link rel="stylesheet" type="text/css" href="css/account.css">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" >
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/tab.js"></script>
  
</head>

<body>
	<jsp:include page="menubar.jsp" />
	<div class="tab_box">
      <ul class="tab" id="tab">
        <li id="hide"><i class="fas fa-envelope"></i></li>
        
        <li id="show"><i class="far fa-envelope-open"></i></li>
      </ul>  
    </div>
    <div class="tab_con" id="tab_con">
      <div ><jsp:include page ="sendMessage.jsp" /> </div>      
     
        <div class="ww"><jsp:include page ="receiveMessage.jsp" /></div> 
    </div>
  
</body>
</html>