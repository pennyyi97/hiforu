<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
  <meta name="viewport" content="width=device-width,minimum-scale=1, maximum-scale=1,initial-scale=1,user-scalable=no">
  <title>walking</title>
  <script src="js/jquery-2.1.3.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/navi.css">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="https://api2.sktelecom.com/tmap/js?version=1&format=javascript&appKey=16bcd486-9fdb-4679-bc99-461d333473d5"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".nav .sub").hide();
		$(".nav .menu").click(function(){
			$(".nav .sub").slideToggle("fast");
		});
	});
</script>
</head>
<body id="body">
<jsp:include page="menubar.jsp" />
<div>
  <div class="nav">
    <button class="menu">한양대역 2번 출구 ~ 식영관 ▽</button>
    <ul class="sub" id="walkingul">
      <li><a href="exit2bon.jsp">한양대역 2번 출구 ~ 본관</a></li>
      <li><a href="exit3bon.jsp">한양대역 3번 출구 ~ 본관</a></li>
      <li><a href="wang6bon.jsp">왕십리역 6번 출구 ~ 본관</a></li>
      <li><a href="mj3bon.jsp">마장역 3번 출구 ~ 본관</a></li>
      <li><a href="exit3sik.jsp">한양대역 3번 출구 ~ 식영관</a></li>
      <li><a href="wang6sik.jsp">왕십리역 6번 출구 ~ 식영관</a></li>
      <li><a href="mj3sik.jsp">마장역 3번 출구 ~ 식영관</a></li>
      <li><a href="exit2jung.jsp">한양대역 2번 출구 ~ 정보관</a></li>
      <li><a href="exit3jung.jsp">한양대역 3번 출구 ~ 정보관</a></li>
      <li><a href="wang6jung.jsp">왕십리역 6번 출구 ~ 정보관</a></li>
      <li><a href="mj3jung.jsp">마장역 3번 출구 ~ 정보관</a></li>
    </ul>
  </div>

  <div class="map" id="results">
	  <p id="result"></p>
	  <div id="map_div"></div>
	</div>
</div>
<script>            
  map = new Tmap.Map({
          div : 'map_div',
          width : "94%",
          height : "400px",
        });
  map.setCenter(new Tmap.LonLat("127.043744", "37.554496").transform("EPSG:4326", "EPSG:3857"), 15);         


  var markerStartLayer = new Tmap.Layer.Markers("start");
  map.addLayer(markerStartLayer);

  var size = new Tmap.Size(24, 38);
  var offset = new Tmap.Pixel(-(size.w / 2), -size.h);
  var icon = new Tmap.IconHtml('<img src=http://tmapapis.sktelecom.com/upload/tmap/marker/pin_r_m_s.png />', size, offset);
  var marker_s = new Tmap.Marker(new Tmap.LonLat("127.044082", "37.555905").transform("EPSG:4326", "EPSG:3857"), icon);
  markerStartLayer.addMarker(marker_s);


  var markerEndLayer = new Tmap.Layer.Markers("end");
  map.addLayer(markerEndLayer);

  var size = new Tmap.Size(24, 38);
  var offset = new Tmap.Pixel(-(size.w / 1.5), -(size.h / 1));
  var icon = new Tmap.IconHtml('<img src=http://tmapapis.sktelecom.com/upload/tmap/marker/pin_r_m_e.png />', size, offset);
  var marker_e = new Tmap.Marker(new Tmap.LonLat("127.049044", "37.559103").transform("EPSG:4326", "EPSG:3857"), icon);
  markerEndLayer.addMarker(marker_e);

                
  var headers = {}; 
  headers["appKey"]="16bcd486-9fdb-4679-bc99-461d333473d5";
  $.ajax({
    method:"POST",
    headers : headers,
    url:"https://api2.sktelecom.com/tmap/routes/pedestrian?version=1&format=xml",
    async:false,
    data:{
      startX : "127.044082",
      startY : "37.555905",
      endX : "127.049044",
      endY : "37.559103",
      
      reqCoordType : "WGS84GEO",
      resCoordType : "EPSG3857",
      angle : "172",
      startName : "출발지",
      endName : "도착지"
    },
    success:function(response){
      prtcl = response;
      
      var innerHtml ="";
      var prtclString = new XMLSerializer().serializeToString(prtcl);
        xmlDoc = $.parseXML( prtclString ),
        $xml = $( xmlDoc ),
        $intRate = $xml.find("Document");
        
        var tDistance = "총 거리 : "+($intRate[0].getElementsByTagName("tmap:totalDistance")[0].childNodes[0].nodeValue/1000).toFixed(1)+"km,";
        var tTime = " 총 시간 : "+($intRate[0].getElementsByTagName("tmap:totalTime")[0].childNodes[0].nodeValue/60).toFixed(0)+"분"; 

        $("#result").text(tDistance+tTime);
      
      prtcl=new Tmap.Format.KML({extractStyles:true, extractAttributes:true}).read(prtcl);
      var routeLayer = new Tmap.Layer.Vector("route");
      routeLayer.events.register("beforefeatureadded", routeLayer, onBeforeFeatureAdded);
              function onBeforeFeatureAdded(e) {
                  var style = {};
                  switch (e.feature.attributes.styleUrl) {
                  case "#pointStyle":
                    style.externalGraphic = "http://topopen.tmap.co.kr/imgs/point.png"; 
                    style.graphicHeight = 0.1;
                    style.graphicOpacity = 1;
                    style.graphicWidth = 16;
                  break;
                  default:
                    style.strokeColor = "#fe3652";
                    style.strokeOpacity = "0.7";
                    style.strokeWidth = "5";
                  };
                e.feature.style = style;
              }
      
      routeLayer.addFeatures(prtcl);
      map.addLayer(routeLayer);
      
      map.zoomToExtent(routeLayer.getDataExtent());
    },
    error:function(request,status,error){
      console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    }
  });
</script>
</body>
</html>