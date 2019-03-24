<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="org.json.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
JSONArray list = (JSONArray)request.getAttribute("list");
JSONArray list2 = (JSONArray)request.getAttribute("list2");
JSONArray list3 = (JSONArray)request.getAttribute("list3");
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
	data.addColumn('string','name');
	data.addColumn('number','amount');
	data.addRows(<%=list%>);
	
	var options = {'width':'33%',
					'height':150};
	var chart = new google.visualization.PieChart(document.getElementById('chart2'));
	chart.draw(data, options);
}

google.charts.load('current', {'packages':['corechart']});//차트 로딩
google.charts.setOnLoadCallback(drawChart2);//drawChart가 준비되면 실행

function drawChart2(){
	var data = new google.visualization.DataTable();
	data.addColumn('string','name');
	data.addColumn('number','amount');
	data.addRows(<%=list2%>);
	
	var options = {'width':'33%',
					'height':150};
	var chart = new google.visualization.PieChart(document.getElementById('chart3'));
	chart.draw(data, options);
}

google.charts.load('current', {'packages':['corechart']});//차트 로딩
google.charts.setOnLoadCallback(drawChart3);//drawChart가 준비되면 실행

function drawChart3(){
	var data = new google.visualization.DataTable();
	data.addColumn('string','name');
	data.addColumn('number','amount');
	data.addRows(<%=list3%>);
	
	var options = {'width':'33%',
					'height':150};
	var chart = new google.visualization.PieChart(document.getElementById('chart4'));
	chart.draw(data, options);
}

</script>

</head>
<body>
   <jsp:include page="tscHeader.jsp" />
   <div>
      <p class="title">각 식당별 식권 구매 통계</p>
      <div id="chart2"></div><div class="tick">교직원 </div><div id="chart3"></div><div class="tick">학생식당 </div><div id="chart4"></div><div class="tick">행원파크</div>
   </div>
</body>
</html>