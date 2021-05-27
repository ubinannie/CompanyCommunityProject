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
              <h2>회원정보변경</h2>
            </div>
            <form method="post" name="frm" id="frm">
              
                  <div class="row">
                      <div class="col-md-10 form-group">
                          <label for="mem_name">이름</label>
                          <input type="text" id="mem_name" name="mem_name" class="form-control form-control-lg" value="<c:out value="${mem_name}" />" readonly="readonly">
                      </div>
                      <div class="col-md-10 form-group">
                          <label for="mem_id">아이디</label>
                          <input type="text" id="mem_id" name="mem_id" class="form-control form-control-lg" value="<c:out value="${mem_id}" />" readonly="readonly">                          
                      </div>
                      
                      <div class="col-md-10 form-group">
                          <label for="mem_email">이메일</label>
                          <input type="text" id="mem_email" name="mem_email" class="form-control form-control-lg" placeholder="ex) id@domain.com" value="<c:out value="${mem_email}" />" >
                      </div>
                      
                      <div class="col-md-10 form-group">
                          <label for="com_name">회사명</label>
                          <input type="text" id="com_name" name="com_name" class="form-control form-control-lg" value="<c:out value="${com_name}" />">
                      </div>
                      
                      
                      <div class="col-4">
                          <input type="button" value="회원정보변경" class="btn btn-danger2"  id="modifyBtn">
                          <input type="button" value="취소" class="btn btn-danger2" id="cancelBtn">
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
$(document).ready(function() {
	
	var frmObj = $('#frm');
	
	$('#modifyBtn').on('click', function check() {
		
	    //회사명 공백 확인
	    if ($("#com_name").val() == "") {
		    alert("회사명을 입력해주세요");
		    $("#com_name").focus();
		    return false;
	    }		      
	    
	    frmObj.attr("action", "/member/modifyForm");
		
	    frmObj.submit();
	    
	});
	
	$('#cancelBtn').on('click', function check() {
		location.href="<c:url value="/member/mypage" />";
	});
});
</script>
</body>

</html>