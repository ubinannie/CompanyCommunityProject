<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- header 영역 start -->      
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<!-- header 영역 end -->  

 <script type="text/javaScript">

 <script type="text/javaScript">

function like_func(){
	var frm_read = $('#frm_read');
	var brd_num = #('brd_num', frm_read).val();
	var mem_id = #('mem_id', frm_read).val();
	// 잘 넘어왔는지 확인하기
	console.log(brd_num + frm_read)
	
	// ajax 사용
	$.ajax({
		url : "/liketo/like/do",		//  주소 바꿔야함 - 컨트롤러랑 맞춰서 
		type : "GET",
		cache : false,
		dataType : "json",
		data : 'brd_num=' +brd_num+ '&mem_id=' +mem_id,
		success: function(data){
			var mag = '';
			var like_img = '';
			msg += data.msg;
			alert(msg);
			
		if(data.like_check == 0){
			like_img = "./images/dislike.png";
		}else{
			like_img = "./images/like.png";
		} // if end 
		$('#like_img', frm_read).attr('src', like_img);
		$('#like_cnt', frm_read).html(data.like_cnt);
		$('#like_check', frm_read).html(data.like_check);
		
		},
		
		error: function(request, status, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
		
		
	});	// ajax 사용 end
	
}	// like_func() end

</script>





</script>


	<!-- 유빈이가 추가한 곳 : 좋아요 하기위해 히든으로 정보 보내기 -->
	<form name="frm_read" id="frm_read" method="get">
		<!-- 게시글 번호 불러오기 -->
		<input type="hidden" id="mem_id" name="mem_id" value=""/>
		<!-- 회원 고유 번호 불러오기 -->
		<input type="hidden" id="brd_num" name="brd_num" value=""/>
	</form>
    

    

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 single-content">
            
           
            <h1 class="mb-4">
              ${list.brd_title }
            </h1>
            <div class="post-meta d-flex mb-5">
            
              <div class="vcard">
                <span class="d-block"><a href="#">${list.brd_cont }</a></span>
                <span class="date-read">${list.brd_regdate }<span class="icon-star2"></span></span>
<!--                 <span class="date-read">Jun 14 <span class="mx-1">&bullet;</span> 3 min read <span class="icon-star2"></span></span> -->              </div>
	
            </div>


            <div class="pt-5">
                    <p>Company : ${list.com_name } </p>
                    <p>Writer : ${list.mem_id } </p>
<%--                     <p>Categories: ${list.com_name } <a href="#">Design</a>, <a href="#">Events</a>  Tags: <a href="#">#html</a>, <a href="#">#trends</a></p> --%>
                	<div>
						<span class="date-read"> <!-- 좋아요 추가 -->
						<c:choose>
							<c:when test="${mem_id ne null}">
								<a href='javascript: like_func();'>
									<i class="far fa-thumbs-up" id="like_img"> ${list.Like_cnt}</i></a>&nbsp; 
							</c:when>
							<c:otherwise>
								<!-- 여기 바꿔야할 수 도있음 -->
								<a href='javascript: like_func();'>
									<i class="fas fa-thumbs-up" ></i></a>
							</c:otherwise>
						</c:choose>
						<!-- 좋아요 끝 --> 
						<i class="far fa-eye"><c:out value="${list.brd_viewed}"></c:out></i>&nbsp; 
						<i class="far fa-comment"><c:out value="${fn:length(commentList)}"></c:out></i>&nbsp;
						</span>
					</div>

                  </div>
      
      			  <!-- start comment-list -->
    
                  <div class="pt-5">
                    <div class="section-title">
                      <h2 class="mb-5"><c:out value="${fn:length(commentList)}"></c:out> Comments</h2>
                    </div>

                    <ul class="comment-list">
					<c:forEach var="comment" items="${commentList}">

                      <c:choose>
                      
                      <c:when test="${comment.com_lev == 2}">
                      <ul class="children">
                          <li class="comment">
	                        <div class="comment-body">
	                          <h3><c:out value="${comment.mem_id}"></c:out></h3>
	                          <div class="meta"><c:out value="${comment.com_regdate}"></c:out></div>
	                          <p><c:out value="${comment.com_cont}"></c:out></p>
	<!--                           <p><a href="#" class="reply">Reply</a></p> -->
	                        </div>
                          </li>
                        </ul>
                       </c:when>
                       
                      <c:when test="${comment.com_lev >= 3}">
                      <ul class="children">
	                      <li class="comment">
		                      <ul class="children">
		                          <li class="comment">
			                        <div class="comment-body">
			                          <h3><c:out value="${comment.mem_id}"></c:out></h3>
			                          <div class="meta"><c:out value="${comment.com_regdate}"></c:out></div>
			                          <p><c:out value="${comment.com_cont}"></c:out></p>
			<!--                           <p><a href="#" class="reply">Reply</a></p> -->
			                        </div>
		                          </li>
		                        </ul>
	                        </li>
                        </ul>
                       </c:when>
                       
                       <c:otherwise>
	                      <li class="comment">
	                        <div class="comment-body">
	                          <h3><c:out value="${comment.mem_id}"></c:out></h3>
	                          <div class="meta"><c:out value="${comment.com_regdate}"></c:out></div>
	                          <p><c:out value="${comment.com_cont}"></c:out></p>
	<!--                           <p><a href="#" class="reply">Reply</a></p> -->
	                        </div>
	                      </li>
                       </c:otherwise>
                       
                      </c:choose> 
                      </c:forEach>
                    </ul>
                  </div>
                  <!-- END comment-list -->

          </div>


          


        </div>
        
      </div>
    </div>

   <div class="site-section subscribe bg-light">
      <div class="container">
        <form action="#" class="row align-items-center">
          <div class="col-md-5 mr-auto">
            <h2>BlahBlah Introduce</h2>
            <p>회사 관리자의 인증을 통해 사용하는 블라블라 앱 서비스는
				동료 직원끼리 소통하는 회사 채널,
				익명으로 제공되는 서비스를 통해 다양한 주제로 이야기 할 수 있는
				소통 채널을 제공합니다.
				</br>
				</br>
				누구나 사용가능한 블라블라 웹 서비스는
				직장내에서 민감할 수 있는 부분을 보호하기 위해
				일부 익명으로 서비스를 제공합니다.
				</br>	
				</br>
				이 점 숙지 부탁드리며, 블라블라 앱을 사용해주셔서 감사합니다.</p>
          </div>
			<div class="col-md-7 mr-auto">
				<img alt="인간" src="/resources/images/ppl.jpg" style="max-width: 100%;">
			</div>
        </form>
      </div>
    </div>



    

  </div>
 <!-- footer 영역 start -->    
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<!-- footer 영역 end -->
  <!-- .site-wrap -->


  <!-- loader -->
  <!-- <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#ff5e15"/></svg></div> -->

</body>

</html>