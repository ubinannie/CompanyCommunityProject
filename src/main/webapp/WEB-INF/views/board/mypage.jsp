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
              <h2>마이페이지</h2>
            </div>
            <form method="get" name="frm" id="frm">
            
	            <div class="row">
	                <div class="col-md-10 form-group">
	                    <a href="<c:url value='/member/messageList' />">쪽지함</a>                          
	                </div>
	            </div>
	            <div class="row">
	                <div class="col-md-10 form-group">
	                    <a href="<c:url value='/member/alarmList' />">알림함</a>                          
	                </div>
	            </div>
	            <div class="row">
	                <div class="col-md-10 form-group">
	                    <a href="<c:url value='/member/modifyForm' />">회원정보변경</a>                          
	                </div>
	            </div>
	            <div class="row">
	                <div class="col-md-10 form-group">
	                    <a href="<c:url value='/member/agreeList' />">이용약관</a>                          
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
		$('#modifyBtn').on('click', function check() {
			alert('click');
			
	});
</script>
</body>

</html>