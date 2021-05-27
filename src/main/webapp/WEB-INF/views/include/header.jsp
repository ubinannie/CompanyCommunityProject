<%@page import="company.blind.dto.Go_MemberDTO"%>
<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="company.blind.web.LoginController" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	
	
	
<head>
<title>BlahBlah &mdash; Community Web </title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="https://fonts.googleapis.com/css?family=B612+Mono|Cabin:400,700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="/resources/all_css/fonts/icomoon/style.css">
  <link rel="stylesheet" href="/resources/all_css/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resources/all_css/css/jquery-ui.css">
  <link rel="stylesheet" href="/resources/all_css/css/owl.carousel.min.css">
  <link rel="stylesheet" href="/resources/all_css/css/owl.theme.default.min.css">
  <link rel="stylesheet" href="/resources/all_css/css/owl.theme.default.min.css">
  <link rel="stylesheet" href="/resources/all_css/css/jquery.fancybox.min.css">
  <link rel="stylesheet" href="/resources/all_css/css/bootstrap-datepicker.css">
  <link rel="stylesheet" href="/resources/all_css/fonts/flaticon/font/flaticon.css">
  <link rel="stylesheet" href="/resources/all_css/css/aos.css">
  <link href="/resources/all_css/css/jquery.mb.YTPlayer.min.css" media="all" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="/resources/all_css/css/style.css">
  <link rel="stylesheet" href="/resources/all_css/css/main.css">
  <link rel="stylesheet" href="/resources/all_css/css/grid-container.css">
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
<script src="/resources/all_css/js/search.js" ></script>

<!-- 헤더에 추가된거 -->
<script src="/resources/all_css/js/main.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- 푸터에 있던거 -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
  <script src="/resources/all_css/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="/resources/all_css/js/jquery-ui.js"></script>
  <script src="/resources/all_css/js/popper.min.js"></script>
  <script src="/resources/all_css/js/bootstrap.min.js"></script>
  <script src="/resources/all_css/js/owl.carousel.min.js"></script>
  <script src="/resources/all_css/js/jquery.stellar.min.js"></script>
  <script src="/resources/all_css/js/jquery.countdown.min.js"></script>
  <script src="/resources/all_css/js/bootstrap-datepicker.min.js"></script>
  <script src="/resources/all_css/js/jquery.easing.1.3.js"></script>
  <script src="/resources/all_css/js/aos.js"></script>
  <script src="/resources/all_css/js/jquery.fancybox.min.js"></script>
  <script src="/resources/all_css/js/jquery.sticky.js"></script>
  <script src="/resources/all_css/js/jquery.mb.YTPlayer.min.js"></script>
  
<%
	String userid = null;
	String socketIdGet="";
	if(session.getAttribute("mem_id") != null){
		userid = (String) session.getAttribute("mem_id");
		socketIdGet = (String) session.getAttribute("socketId");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@헤더에서 받는 "+userid);
	}
%>

<!-- 페이지 이동 script -->
<script type="text/javaScript">
function move() {
     location.href = "<c:url value="../board/writePage" />";
}

/* function login() {
     location.href = "<c:url value="../member/login" />";
} */

function logout() {
    location.href = "<c:url value="../member/logout" />";
}

function mypage() {
    location.href = "<c:url value="../member/mypage" />";
}


/////웹소켓 송수신
var ws = new WebSocket("ws://localhost:9090/websocket/echo.do"); // 전역 변수로 선언

$(document).ready(function(){
	connectWS();
	
	$("#search").click(function(){
		var findType = 'findType=' +$("#select option:selected").val() + '&';	
		var word = 'word=' + $("#searchBox").val();
		var origin = '/fboard/search?';
		var q = origin + findType + word; 
		$(location).attr('href', q);
	});
});

function connectWS(){
	ws.onmessage = onMessage;		//메세지 동작할 때
	ws.onclose = onClose;
	ws.onerror = onError;
	ws.onopen = function(event){
		console.log("커넥션 생성");
	};
}

var clickCheck = 0;	//누름 확인용 변수
var data;

function onMessage(event){
		console.log("메세지 작동");
		data = event.data;
		console.log(data);
		
		console.log(<%=socketIdGet%>);
		console.log(<%=userid%>);
			
		// 메세지를 받아서 알람 처리하는 동작
		if(data==<%=userid%> ){
			console.log("true");
			$('#notice_img').attr("src", "/resources/images/notice.png");
		}else{
			$('#notice_img').attr("src", "/resources/images/nonotice.png");
		}
		
}
		
function onClose(event){
	if (event.wasClean) {
	    console.log('[close] 커넥션이 정상적으로 종료되었습니다(code=${event.code} reason=${event.reason})');
	} else {
	    // 예시: 프로세스가 죽거나 네트워크에 장애가 있는 경우
	    // event.code가 1006이 됩니다.
	    console.log('[close] 커넥션이 죽었습니다.');
	}
}

function onError(event){
	console.log("Server Error");
}







</script>

<style type="text/css">
	#login_con {
	 	padding-top: 160px;
	 	
	 }

	#login_row {
		text-align: center;
		margin-top: 50px;
	 }
	 
	 #login_con1 {
	 	border: 0.5px solid lightgray;
	 	width: 450px;
	 }
	 
	 
	 #login_con2 {
	 	display: inline-block;
	 }
	 
	#naver_id_login {
		display: inline-block;
		align-content: center;
		margin-top: 20px;
		margin-bottom: 90px;
	 }
	 #login_comen {
	 	align-self:auto;
	 }
	 
	 #login_comen1 {
	 	color: gray;
	 }
	 
</style>
</head>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">




 <div class="site-wrap">

   <div class="site-mobile-menu site-navbar-target">
     <div class="site-mobile-menu-header">
       <div class="site-mobile-menu-close mt-3">
         <span class="icon-close2 js-menu-toggle"></span>
       </div>
     </div>
     <div class="site-mobile-menu-body"></div>
   </div>
   
   
  <!-- 헤더 -->
      <div class="header-top">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-12 col-lg-6 d-flex">
              <a href="/main/mainPage" class="site-logo">
                BlahBlah
              </a>
              
              <!-- websocket용 이미지 -->
            <input type="image" src="/resources/images/nonotice.png" alt="알림이미지" id="notice_img" style="float:right" width="48" height="48">
            
            
            
            
            </div>
            <div class="col-12 col-lg-6 ml-auto d-flex">
              <div class="ml-md-auto top-social d-none d-lg-inline-block">
              </div>
              <form action="#" class="search-form d-inline-block">
                <div class="d-flex">
                <div 
                style="
                display: flex; 
                justify-content: center; 
                align-items: center; 
                padding-right:10px; 
                height: auto;
                "
                >
                	<select class="form-select form-select-sm"
                	id="select"
                	style="
                	font-size: 13px; 
                	width: auto; 
                	height:20px;
                	border-style: none;
                	" 
                	aria-label=".form-select-sm example">
					  <option selected value="NAME" name="NAME">제목</option>
					  <option value="TEXT" name="TEXT">내용</option>
					  <option value="WRITER" name="WRITER">닉네임</option>
					  <option value="NAMETEXT" name="NAMETEXT">제목+내용</option>
					</select>
				</div>
                  <input type="text" id="searchBox" class="form-control" placeholder="Search..." >
                  <button type="button" id="search"class="btn btn-secondary" ><span class="icon-search"></span></button>

                </div>
              </form>

              
            </div>
          </div>
        </div>
        
        <div class="site-navbar py-2 js-sticky-header site-navbar-target d-none pl-0 d-lg-block" role="banner">

       <!-- nav -->
       <div class="container">
         <div class="d-flex align-items-center">
           
           <div class="mr-auto">
              <nav class="site-navigation position-relative text-right" role="navigation">
                <ul class="site-menu main-menu js-clone-nav mr-auto d-none pl-0 d-lg-block">
                  <li class="active">
                    <a href="/board/news_board" class="nav-link text-left">회사소식</a>
                  </li>
                  <li>
                    <a href="/board/pop_board" class="nav-link text-left">인기글</a>
                  </li>
                  <li>
                    <a href="/board/hot_board" class="nav-link text-left">hot게시판</a>
                  </li>
                  <li>
                    <a href="/board/anony_board" class="nav-link text-left">익명게시판</a> 
                  </li>
                  <li>
                  	<a href="/board/bulletin_board" class="nav-link text-left">자유게시판</a>
                  </li>
                </ul>                                                                                                                                                                                                                                                                                         
              </nav>
            </div>

           <div class="col sm_container">
             <%
             	if(userid == null){
             %>
             <a href="../member/login"><input type="button" class="btn btn-danger2" value="login"></a>
             <%
             	} else{
             %>
             <button type="button" class="btn btn-warning2" onclick="move()">write</button>
             <button type="button" class="btn btn-danger2" onclick="javascript:logout();">logout</button>
             <button type="button" class="btn btn-danger2" onclick="javascript:mypage();">mypage</button>
           	 <%
             	}
           	 %>
           	            	 
           
           </div>

         </div>
       </div>
       <!-- nav -->
     </div>
   </div>
   <!-- 헤더 -->
</div>


</body>


</html>

