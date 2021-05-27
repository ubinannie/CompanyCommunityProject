<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- header 영역 start -->    
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<!-- header 영역 end -->

    <div class="site-section bg-light">
      <div class="container">
        <div class="row">

          <div class="col-lg-12">
            <div class="section-title mb-5">
              <h2>회원가입</h2>
            </div>
            <form name="frm" id="frm" method="post">
              
                  <div class="row">
                      <div class="col-md-8 form-group">
                          <label for="mem_name">이름</label>
                          <input type="text" id="mem_name" name="mem_name" class="form-control form-control-lg" value="<c:out value="${mem_name}" />" readonly="readonly">
                      </div>
                      
                      <div class="col-md-8 form-group">
                          <label for="mem_id">아이디</label>
                          <input type="text" id="mem_id" name="mem_id" class="form-control form-control-lg" value="<c:out value="${mem_id}" />" readonly="readonly">
                      </div>
                      
                      <div class="col-md-8 form-group">
                          <label for="mem_email">이메일</label>
                          <input type="text" id="mem_email" name="mem_email" class="form-control form-control-lg" value="<c:out value="${mem_email}" />" readonly="readonly">
                      </div>
                      
                      <div class="col-md-8 form-group">
                          <label for="com_name">회사명</label>
                          <input type="text" id="com_name" name="com_name" class="form-control form-control-lg">
                      </div>
                      
                      
                      <div class="col-12">
                          <input type="button" value="회원가입" class="btn btn-primary py-3 px-5" id="joinBtn">
                      </div>
                  </div>
                  
            </form>
          </div>
          
        </div>

        
      </div>
    </div>

	<!-- footer 영역 start -->    
	<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
	<!-- footer 영역 end -->

  <!-- .site-wrap -->
<script type="text/javascript">
$(document).ready(function(){
	var frmObj = $('form[name="frm"]');			//클래스 없이 속성으로 누군지 인식
	console.log(frmObj.val());
	
	$('#joinBtn').on('click', function(){

		//회사명 공백 확인
	    if ($("#com_name").val() == "") {
		    alert("회사명을 입력해주세요");
		    $("#com_name").focus();
		    return false;
	    }		      
		
	    frmObj.attr("action", "/member/joinForm");
		frmObj.attr("method", "post");		//post로 보내기
		frmObj.submit();
	    
	});
});
</script>
</body>

</html>

















