<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
	<!-- '네이버 아이디로 로그인하기' 버튼 -->
 	<!-- 원하는 곳에 넣습니다. -->
	<div id="naver_id_login"></div>
	
	<!-- 네이버아이디로로그인 버튼 노출 영역 -->
	<script type="text/javascript">
 		var naver_id_login = new naver_id_login("luBVyzuZOTHtdB2kp1Dc", "http://localhost:9090/naver/loginNaver");	// Client ID, CallBack URL 삽입
											// 단 'localhost'가 포함된 CallBack URL
 		var state = naver_id_login.getUniqState();
		
 		naver_id_login.setButton("green", 3, 50);
 		naver_id_login.setDomain("http://localhost:9090/naver");	//  URL
 		naver_id_login.setState(state);
 		//naver_id_login.setPopup();	//팝업 안되게 함
 		naver_id_login.init_naver_id_login();
	</script>
</body>
</html>