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
<%
String server = "http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll?serviceKey=y725sSs8lFYfBhMSsUaql%2BQ2GJxA%2FTJd%2BpOlAkXvOoESOkU1Gd0icfocGz8FAsyvWaEeElJ6Wkp2m67%2BRPWv2g%3D%3D&busRouteId=100100604";
URL url;
   URLConnection connection;
   InputStream is;
   InputStreamReader isr;
   BufferedReader br;
   String strXML = new String(); //xml내용 저장하기 위한 변수
   try {
      url = new URL(server); //url 세팅
      connection = url.openConnection(); //접속
      is = connection.getInputStream(); //inputStream이용
      isr = new InputStreamReader(is);
      br = new BufferedReader(isr);
      String buf = null;
      
      while (true) {//무한반복
         buf = br.readLine(); //화면에 있는 내용을 \n단위로 읽어온다
         if (buf == null) { //null일 경우 화면이 끝난 경우
            break; //반복문 끝
         } else {
            strXML += buf + "\n"; //strXML에 화면에 출력된 내용을 기억시킨다.
         }
      }
   } catch (MalformedURLException mue) {
      
   } catch(IOException ioe) {
      ioe.printStackTrace();
   }
   DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
   Document document = docBuilder.parse(new InputSource(new java.io.StringReader(strXML)));
   //strXML을 StringReader에 담고 inputSource클래스를 이용 DocumentBuilder.parse 메소드를 이용하여 document문서로 만듬
   document.setDocumentURI(server);
   
   Element root = document.getDocumentElement();
   NodeList nodelist = root.getElementsByTagName("itemList");//1. NodeList에 추출할 태그를 입력한다.
   Element el = null;
    NodeList sub_n_list = null;
    Element sub_el = null;
         
    Node v_txt = null;
    String value="";
    String[] tagList = {"stNm", "arrmsg1", "arrmsg2"};
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>Insert title here</title>
<script>

	
	function autoRefresh_div() {
		var currentLocation = window.location;
		$(".d").load(currentLocation + ' .d');
	}
	
	   setInterval('autoRefresh_div()', 10000); 
</script>
<link rel="stylesheet" type="text/css" href="css/bus.css">
<style>
</style>
<link rel="stylesheet" type="text/css" href="css/bus.css">
</head>
<body>  
	<div class="d">
		<ul class="name3">
			<% 
   for(int i=35; i<44; i++) {
    el = (Element) nodelist.item(i);
    for(int k=0; k<1; k++) {
      sub_n_list = el.getElementsByTagName("stNm");
      sub_el = (Element)sub_n_list.item(0);
      Node txt = sub_el.getFirstChild();
      value=txt.getNodeValue();

      out.println("<li>"+value+"</li>");
%>
		
			<%       
      el = (Element)nodelist.item(i);
      sub_n_list = el.getElementsByTagName("arrmsg1");
      sub_el = (Element)sub_n_list.item(0);
      txt = sub_el.getFirstChild();    
      out.println( "<li>"+ "<h1>"+txt.getNodeValue()+ "</h1>"+"<li>"+"<div>" +"<hr>"+ "</div>");
    }    
   }
   
%>
		</ul>
	</div>
</body>
</html>