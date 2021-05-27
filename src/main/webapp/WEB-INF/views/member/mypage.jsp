<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	a{
		font-size: 20px;
	}
</style>
<!-- header 영역 start -->    
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<!-- header 영역 end -->    

   <div class="site-section">
      <div class="container" id="login_con1">
      
        <div class="row" id="login_row">
          <div class="col-lg-12" id="login_con2">
            <div>
              <h2 style="font-size: 30px;, margin-bottom: 20px;">마이페이지</h2>
            </div><br />
            <form method="get" name="frm" id="frm">
              <div class="section-title">
                  <a href="<c:url value='/member/modifyForm' />" style="color: black;">회원정보변경</a>                          
              </div>
              <div class="section-title">
                  <a href="<c:url value='/member/agreeList' />" style="color: black;">이용약관</a>                          
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
});
</script>
</body>

</html>