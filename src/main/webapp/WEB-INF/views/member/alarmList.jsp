<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- header 영역 start -->    
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<!-- header 영역 end -->   

    <div class="site-section bg-light">
      <div class="container">
        <div class="row">

          <div class="col-lg-12">
            <div class="section-title mb-5">
              <h2>알림함</h2>
            </div>
			<!-- 목록 작성: start -->
			
			<!-- 목록 작성: end -->
          </div>
          
        </div>
      </div>
    </div>

	<!-- footer 영역 start -->    
	<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
	<!-- footer 영역 end -->
  <!-- .site-wrap -->
<script type="text/javascript">
	$(document).ready(function() {
		$('#modifyBtn').on('click', function check() {
			//alert('click');
			var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
			var getCheck= RegExp(/^[a-zA-Z0-9]{4,12}$/);
			var getName= RegExp(/^[가-힣]+$/);
			var fmt = RegExp(/^\d{6}[1234]\d{6}$/); //형식 설정
			
			//비밀번호 공백 확인
			if($("#memPwd").val() == "") {
				alert("비밀번호를 입력해주세요");
				$("#memPwd").focus();
				return false;
			}
			
			//비밀번호 확인 공백 확인
			if($("#memPwdChk").val() == "") {
				alert("비밀번호 확인을 입력해주세요");
				$("#memPwdChk").focus();
				return false;
			}
		      
/* 		 	
		    //비밀번호
		    if(!getCheck.test($("#memPwd").val())) {
			    alert("비밀번호를 입력해주세요");
			    $("#memPwd").val("");
			    $("#memPwd").focus();
			    return false;
		    }
 */	 
/* 
		    //아이디랑 비밀번호랑 같은지
		    if ($("#memId").val()==($("#memPwd").val())) {
			    alert("비밀번호와 아이디가 똑같습니다.다시 입력해주세요.");
			    $("#memPwd").val("");
			    $("#memPwd").focus();
		    }
 */		 
		    //비밀번호 똑같은지
		    if($("#memPwd").val() != ($("#memPwdChk").val())){ 
			    alert("비밀번호가 다릅니다.다시 입력해주세요.");
			    $("#memPwdChk").val("");
			    $("#memPwdChk").focus();
			    return false;
		    }
		 
		    //이메일 공백 확인
		    if($("#memEmail").val() == ""){
			    alert("이메일을 입력해주세요");
			    $("#memEmail").focus();
			    return false;
		    }
		           
		    //이메일 유효성 검사
		    if(!getMail.test($("#memEmail").val())){
			    alert("이메일형식에 맞게 입력해주세요")
			    $("#memEmail").val("");
			    $("#memEmail").focus();
			    return false;
		    }
		 	
		    //회사명 공백 확인
		    if ($("#comName").val() == "") {
			    alert("회사명을 입력해주세요");
			    $("#comName").focus();
			    return false;
		    }		      
		    
		    //회원명 공백 확인
		    if ($("#memName").val() == "") {
			    alert("회원명을 입력해주세요");
			    $("#memName").focus();
			    return false;
		    }
			
		    $("#joinForm").attr("action", "/joinMember");
			
		    $("#joinForm").submit();
		    
		});
	});
</script>
</body>

</html>