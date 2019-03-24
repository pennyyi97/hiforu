<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/productlist_detail.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" >
<script src="js/jquery-3.2.1.min.js"></script>
</head>
<body onload="init();">
<script language="JavaScript">
var sell_price;
var amount;

function init () {
	sell_price = document.form.sell_price.value;
	amount = document.form.amount.value;
	document.form.sum.value = sell_price;
	change();
}

function add () {
	hm = document.form.amount;
	sum = document.form.sum;
	hm.value ++ ;

	sum.value = parseInt(hm.value) * sell_price;
}

function del () {
	hm = document.form.amount;
	sum = document.form.sum;
		if (hm.value > 1) {
			hm.value -- ;
			sum.value = parseInt(hm.value) * sell_price;
		}
}

function change () {
	hm = document.form.amount;
	sum = document.form.sum;

		if (hm.value < 0) {
			hm.value = 0;
		}
	sum.value = parseInt(hm.value) * sell_price;
}
</script>
	<jsp:include page="proHeader.jsp" />
	<p class="title">[${list.tcategoryName}] ${list.ticketName}</p>
    <div class="pro pro1">
    	<img class="productimg" src="upload${list.file}" />
    </div>
    <form name="form" action="hiroad?cmd=productBuy" method="POST">
    	<div class="content">
    		<p>메뉴 : <input class="name" value="${list.ticketName}" name="ticketName" readonly></p>
    		<p class="price">가격 : <input class="price" value="${list.price}" name="sell_price" readonly></p>
    		<input type="hidden" value="${list.ticketNum}" name="num">
    		<p>수량 : <input class="i1" type="text" name="amount" value="1" size="3" onchange="change();">
    				<input class="bt" type="button" value=" + " onclick="add();">
    				<input class="bt" type="button" value=" - " onclick="del();">
    		</p>
    		<input type="hidden" name="sum">
    		<p class="con">
    			※ 식권은 구매 후 한양여대 행원파크점에서 사용가능 합니다.<br>
    			 &nbsp&nbsp&nbsp⏰운영시간11:30~19시(18:50주문마감)<br>
				 &nbsp&nbsp&nbsp➡방학중 ~18:00까지(17:50주문마감)
			</p>
   		</div>
   		<div class="footer">
    		<input class="buybutton" type="submit" value="구매">
	         
		</div>
    	
    </form>
    
</body>
</html>