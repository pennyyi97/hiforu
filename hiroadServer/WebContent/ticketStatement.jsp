<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="org.json.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
JSONArray list = (JSONArray)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<title>식권 통계내역</title>
<meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/cart.css">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
google.charts.load('current', {'packages':['corechart']});//차트 로딩
google.charts.setOnLoadCallback(drawChart);//drawChart가 준비되면 실행

function drawChart(){
	var data = new google.visualization.DataTable();
	var list = '${list}'
	data.addColumn('string','name');
	data.addColumn('number','amount');
	data.addRows(<%=list%>);
	
	var options = {'title':'식권별 구매량',
					'width':'100%',
					'height':400, 'padding':0};
	var chart = new google.visualization.PieChart(document.getElementById('chart'));
	chart.draw(data, options);
}

</script>

</head>
<body>
   <jsp:include page="cartHeader.jsp" />
   <div>
      <p class="title">[식권 구매 통계]</p>
      <div id="chart"></div>
      <input type="button" value="나의 구매통계보기" OnClick="window.location='hiroad?cmd=ticketAmoutPersonal'">
   </div>
</body>
</html>