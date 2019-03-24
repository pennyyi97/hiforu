<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.xml.sax.InputSource"%>
<%@ page import="java.io.File"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.xml.parsers.DocumentBuilder"%>
<%@ page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@ page import="org.w3c.dom.Document"%>
<%@ page import="org.w3c.dom.Element"%>
<%@ page import="org.w3c.dom.Node"%>
<%@ page import="org.w3c.dom.NodeList"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.net.URLConnection"%>
<%@ page import="java.net.MalformedURLException"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.io.InputStreamReader"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.IOException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/hanma.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css">

<meta name="viewport"
	content="width=device-width, height=device-height, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script>
function wtime(depart_time){
	var result="";
	if(depart_time=="23:59:59"){
		  result="운행종료";
		  return result;
	}
	
	var today = new Date();
	
	var parse_depart_array = depart_time.split(':');
	var depart_time_second = 3600 * parse_depart_array[0] + 60 * parse_depart_array[1] + 1* parse_depart_array[2];
	var current_time_second = 3600 * today.getHours() + 60 * today.getMinutes() + 1* today.getSeconds();
	var differ = depart_time_second - current_time_second;
	var hour = parseInt(differ / 3600);
	 differ = differ - hour*3600;
	var minute = parseInt(differ/60);
	 differ = differ - minute*60;
	var second = differ;
	
		if(hour > 0){
	       result = result + hour.toString() + "시간 ";
	    }
	    if(!(hour>0 && minute==0)){
	       result = result + minute.toString() + "분 ";
	    }

	    if(hour <= 0 && minute <= 0 && second < 30){
	       result = "곧 도착";
	    }
	    else{
	       result = result + second.toString() + "초 후";
	    }
	 
	 return result;
}
</script>

</head>
<body>

<!-- 	<form class="header">
<div class="lod" >
		새로 고침 <img class="loading" src="images/loading2.png">
	</div>
	</form> -->
<script>
   function wautoRefresh_sample_div()
   {
   var currentLocation = window.location;
   $("#list2").load(currentLocation + ' #list2');
   }
  /*  setInterval('wautoRefresh_sample_div()', 8000); */ 
</script>
	<div id="list2">
		<ul class="name1">
			<c:forEach items="${list4}" var="BusVO">
				<script>
					
					function time_differ_second(){
					      var depart_time = '${BusVO.depart_time}';
					      var result = wtime(depart_time);
					      document.getElementById("station4").innerHTML = result;
					   }
					setInterval(time_differ_second,3000);
					</script>
				<li>한양여대 정문</li>
				<li>
				<li><h1 id="station4">
						<script>time_differ_second();</script>
					</h1>
					<div>
						<hr>
					</div></li>
			</c:forEach>




			<c:forEach items="${list5}" var="BusVO">
				<script>
					
					function time_differ_second(){
					      var depart_time = '${BusVO.depart_time}';
					      var result = wtime(depart_time);
					      document.getElementById("station5").innerHTML = result;
					}
					setInterval(time_differ_second,3000);
					</script>
				<li>왕십리역</li>
				<li>
					<h1 id="station5">
						<script>time_differ_second();</script>
					</h1>
					<div>
						<hr>
					</div>
				</li>
			</c:forEach>
		</ul>
		
               <button class=" lod2"
                  OnClick="window.location.reload()"><img class="refresh" src="images/refresh.png"></button>
	</div>
</body>
</html>