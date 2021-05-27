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
	<script type="text/javascript">
		var naver_id_login = new naver_id_login("jN3UTPdIfuJWio3NAjMi", "http://localhost:9090/member/loginNaver"); // 역시 마찬가지로 'localhost'가 포함된 CallBack URL
		
		// 접근 토큰 값 출력
		//alert(naver_id_login.oauthParams.access_token);
		
		// 네이버 사용자 프로필 조회
		naver_id_login.get_naver_userprofile("naverSignInCallback()");
		
		// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
		function naverSignInCallback() {
			//alert(naver_id_login.getProfileData('id'));
			//alert(naver_id_login.getProfileData('email'));
			//alert(naver_id_login.getProfileData('name'));
			//alert(naver_id_login.getProfileData('nickname'));
			var mem_id = naver_id_login.getProfileData('id');
			var mem_email = naver_id_login.getProfileData('email');
			var mem_name = naver_id_login.getProfileData('name');
			
			console.log(mem_id);
			console.log(mem_email);
			console.log(mem_name);

			//form을 생성해서 input:hidden을 삽입하고 전송까지
			//참고 주소 : https://here4you.tistory.com/87
			//				  자바스크립트를 이용한 동적 폼(form) 생성 및 post 요청
			 var form = document.createElement("form");
	         form.setAttribute("charset", "UTF-8");
	         form.setAttribute("method", "POST");  //Post 방식, 지금은 get
	         form.setAttribute("action", "loginMem"); //요청 보낼 주소

	         var hiddenField = document.createElement("input");
	         hiddenField.setAttribute("type", "hidden");
	         hiddenField.setAttribute("name", "mem_id");
	         hiddenField.setAttribute("value", mem_id);
	         form.appendChild(hiddenField);

	         hiddenField = document.createElement("input");
	         hiddenField.setAttribute("type", "hidden");
	         hiddenField.setAttribute("name", "mem_email");
	         hiddenField.setAttribute("value", mem_email);
	         form.appendChild(hiddenField);
	         
	         hiddenField = document.createElement("input");
	         hiddenField.setAttribute("type", "hidden");
	         hiddenField.setAttribute("name", "mem_name");
	         hiddenField.setAttribute("value", mem_name);
	         form.appendChild(hiddenField);

	         document.body.appendChild(form);
	         form.submit();
		}
	</script>
	
</body>
</html>