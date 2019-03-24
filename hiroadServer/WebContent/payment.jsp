<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8" name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/payment.css">
<script type="text/javascript">
function doValidate() {
	   var form = document.payment;
	   
	   if(!form.cardname.value || " " == form.cardname.value){
	      alert("카드사를 입력해주세요");
	      form.cardname.focus();
	      return;
	      
	   }
	   if(!form.cardnum.value || " " == form.cardnum.value){
	      alert("카드번호를 입력해주세요");
	      form.cardnum.focus();
	      return;
	   }
	   
	   form.submit();
	   
	}
</script>
</head>
<body>
	<jsp:include page="payHeader.jsp" />
	<form class="payment" action="hiroad?cmd=payment" method="POST" name="payment" enctype="multipart/form-data">
		<input type="hidden" value="<%= request.getParameter("ticketNum") %>" name="ticketNum">
		<div class="head">
	    	<dl class="w">
	    		<dt>식권메뉴</dt>
	    		<dd><%= request.getParameter("ticketName") %></dd>
	    		<dt>식권수량</dt>
	    		<dd><%= request.getParameter("amount") %></dd>
	    		<dt>전체금액</dt>
	    		<dd><%= request.getParameter("sum") %></dd>
	    	</dl>
		</div>
		<hr>
		<div class="con">
			<div class="payco">
				<span>PAYCO 간편결제</span>
				<div class="checkbox-container">
					<input type="checkbox" id="is-subscription">
				</div>
			</div>
			<div class="naverpay">
				<span>네이버페이 간편결제</span>
				<div class="checkbox-container">
					<input type="checkbox" id="is-subscription">
				</div>
			</div>
			<div class="card">
					<span>신용카드 결제</span>
					<div class="content_line1">
				        <span class="t">카드사 </span> <span><input type="text"
				               class="input" id="cardinfo1" name="cardName"></span>
				    </div>
				    <div class="content_line2">
				        <span class="t">카드번호 </span> <span><input type="text"
				               class="input" id="cardinfo2" name="cardNum"></span>
				    </div>
				 </div>
				 <div class="footer">
			        <input type="submit" value="결제" class="submit1" onclick="javascript:doValidate();">
				 </div>
		</div>
		</form>
</body>
</html>