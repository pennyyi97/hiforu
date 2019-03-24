<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<center>
<div class="wrapper">
      <div class="box1-content">
         <div class="header">
            <img src="images/hiforyou.png">
         </div>
         <form method="post" action="hiroad?cmd=loginAction">
            <div class="box1">
               <input type="text" placeholder="학번" class="id" name="number" />
               <div class="overlap-text">
                  <input type="password" placeholder="비밀번호" class="pw" name="pw" /> 
               </div>
            <input type="submit" value="Log in" class="logbt" />
            <div class="fpwd">
               <a href="findpw.jsp">비밀번호를 잊으셨나요?</a>
            </div>
            <div class="col-xs-12 col-sm-6">
               <hr class="omb_hrOr">
               <span class="spanOr">or</span>
            </div>
            <input type="button" value="Sign up" class="subt" onclick="window.location='hiroad?cmd=signup'"  />
            </div>
         </form>
      </div>
   </div>
</center>
</body>
</html> 

 