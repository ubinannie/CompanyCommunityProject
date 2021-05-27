<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- header 영역 start -->    
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<!-- header 영역 end -->

    <div class="site-section" id="login_con">
      <div class="container" id="login_con1">
        
        <div class="row" id="login_row">
          <div class="col-lg-12" id="login_con2">
            <div>
              <h1>LOGIN</h1>
            </div> <br />
            <div class="section-title">
              <h6>Naver 계정 사용</h6>
            </div>
            <div id="login_comen">
              <h6 id="login_comen1">내 컴퓨터가 아닌가요? 게스트 모드를 사용하여 <br />비공개로 로그인하세요.</h6>
            </div>
          </div>
        </div>
        <div style="text-align: center;">
		<form method="get" id="loginForm">
            <input type="hidden" id="loginType" name="loginType" value="normal" />
            <div class="row">
                <div class="col-12" id="naver_id_login"></div>
            </div>
        </form>
        </div>
      </div>
    </div>

	<!-- footer 영역 start -->    
	<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
	<!-- footer 영역 end -->
  <!-- .site-wrap -->

<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<!-- 네이버아이디로로그인 버튼 노출 영역 -->
	<script type="text/javascript">
 		var naver_id_login = new naver_id_login("jN3UTPdIfuJWio3NAjMi", "http://localhost:9090/member/loginNaver");	// Client ID, CallBack URL 삽입
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







