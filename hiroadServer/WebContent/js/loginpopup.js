    //택시 로그인 팝업
	function wrapWindowByMask1(){
        //애니메이션 효과 - 일단 0초동안 까맣게 됐다가 60% 불투명도로 간다.
        $("#mask1").fadeTo("slow",0.6);  
        //윈도우 같은 거 띄운다.
        $(".window1").show();
	}
    $(document).ready(function(){
        //검은 막 띄우기
        $(".openMask1").click(function(e){
            e.preventDefault();
            wrapWindowByMask1();
        });
        //검은 막을 눌렀을 때
        $("#mask1").click(function () {  
            $(this).hide();  
            $(".window1").hide();  
        });
      $(".window1 .yes").click(function() {
         location.href = "hiroad?cmd=login";
      })
      //닫기 버튼을 눌렀을 때
        $(".window1 .no").click(function (e) {  
            //링크 기본동작은 작동하지 않도록 한다.
            e.preventDefault();  
            $("#mask1, .window1").hide();  
        });    
    });
    
    
    //계좌전송 로그인 팝업
    function wrapWindowByMask2(){
        $("#mask2").fadeTo("slow",0.6);  
        //윈도우 같은 거 띄운다.
        $(".window2").show();
    }
    $(document).ready(function(){
        //검은 막 띄우기
        $(".openMask2").click(function(e){
            e.preventDefault();
            wrapWindowByMask2();
        });
        //검은 막을 눌렀을 때
        $("#mask2").click(function () {  
            $(this).hide();  
            $(".window2").hide();  
        });
      $(".window2 .yes").click(function() {
         location.href = "hiroad?cmd=login";
      })
      //닫기 버튼을 눌렀을 때
        $(".window2 .no").click(function (e) {  
            //링크 기본동작은 작동하지 않도록 한다.
            e.preventDefault();  
            $("#mask2, .window2").hide();  
        });    
 
    });
    
    //게시판 로그인 팝업
	function wrapWindowByMask3(){
        //애니메이션 효과 - 일단 0초동안 까맣게 됐다가 60% 불투명도로 간다.
        $("#mask3").fadeTo("slow",0.6);  
        //윈도우 같은 거 띄운다.
        $(".window3").show();
	}
    $(document).ready(function(){
        //검은 막 띄우기
        $(".openMask3").click(function(e){
            e.preventDefault();
            wrapWindowByMask3();
        });
        //검은 막을 눌렀을 때
        $("#mask3").click(function () {  
            $(this).hide();  
            $(".window3").hide();  
        });
      $(".window3 .yes").click(function() {
         location.href = "hiroad?cmd=login";
      })
      //닫기 버튼을 눌렀을 때
        $(".window3 .no").click(function (e) {  
            //링크 기본동작은 작동하지 않도록 한다.
            e.preventDefault();  
            $("#mask3, .window3").hide();  
        });    
    });
    
    
  //식권구매 로그인 팝업
	function wrapWindowByMask4(){
        //애니메이션 효과 - 일단 0초동안 까맣게 됐다가 60% 불투명도로 간다.
        $("#mask4").fadeTo("slow",0.6);  
        //윈도우 같은 거 띄운다.
        $(".window4").show();
	}
    $(document).ready(function(){
        //검은 막 띄우기
        $(".openMask4").click(function(e){
            e.preventDefault();
            wrapWindowByMask4();
        });
        //검은 막을 눌렀을 때
        $("#mask4").click(function () {  
            $(this).hide();  
            $(".window4").hide();  
        });
      $(".window4 .yes").click(function() {
         location.href = "hiroad?cmd=login";
      })
      //닫기 버튼을 눌렀을 때
        $(".window4 .no").click(function (e) {  
            //링크 기본동작은 작동하지 않도록 한다.
            e.preventDefault();  
            $("#mask4, .window4").hide();  
        });    
    });
  //광고문의 팝업
	function wrapWindowByMask5(){
        //애니메이션 효과 - 일단 0초동안 까맣게 됐다가 60% 불투명도로 간다.
        $("#mask5").fadeTo("slow",0.6);  
        //윈도우 같은 거 띄운다.
        $(".window5").show();
	}
    $(document).ready(function(){
        //검은 막 띄우기
        $(".openMask5").click(function(e){
            e.preventDefault();
            wrapWindowByMask5();
        });
        //검은 막을 눌렀을 때
        $("#mask5").click(function () {  
            $(this).hide();  
            $(".window5").hide();  
        });
      //닫기 버튼을 눌렀을 때
        $(".window5 .close").click(function (e) {  
            //링크 기본동작은 작동하지 않도록 한다.
            e.preventDefault();  
            $("#mask5, .window5").hide();  
        });       
    });