<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!-- header 영역 start -->      
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%
	String userid = "";
	if(session.getAttribute("mem_id") != ""){
		userid = (String) session.getAttribute("mem_id");
		
	}
%>
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<!-- header 영역 end -->  
 <script type="text/javaScript">
function move(){
     location.href = "writePage.html";
}


	$('#commentList').on('click', function(){
		console.log("ㅎㅎ");
		$('#commentListForm').submit()

   });   
	
	function up(){
		   $('#zz').on('click', function(){
		      
		      location.href = "/board/up?brd_num="+${list.brd_num};
		      alert("추천 !");
		      
		      
		   });   
	}

</script> 
	<!-- 수정/삭제/목록 -->
 <script type="text/javascript">
		$(document).ready(function(){
			var frmObj = $('form[role="form"]');
			var user=${list.mem_id };
			//console.log(frmObj);
			
			var userid = '<%= userid %>';
			
	

		 	$('.btn-danger').on('click', function(){
				//alert('delete btn click');
				console.log(user);
				if(userid == user){
				 	location.href="/board/del?brd_num="+${list.brd_num}; 
				} else{
					alert('권한이 없습니다.');
				}
			});	 
		
		 	
		 	
			$('.btn-info').on('click', function(){
				self.location = "/board/hot_board";
			/* 	frmObj.attr("method", "get");
				frmObj.attr("action", "/board/unknown_board");
				frmObj.submit(); */
			});
			
			$('.btn-primary').on('click', function(){
				//self.location = "/board/modifyPage";
				//alert('modify btn click');
				location.href="/board/modifyPage?brd_num="+${list.brd_num};
	 			/* frmObj.attr('action', '/board/modifyPage');
				frmObj.attr('method', 'get');
				frmObj.submit(); */ 
				
			});
			
			
			var frm = $("form[name='mainCommentForm']");
			
			///////////////웹소켓 버튼 송신
 			$("#mainComment").on("click", function(evt){
				evt.preventDefault();
				
				//console.log($('#mem_number').val());
				//console.log($('#com_cont').val());
				
				//mainCommentForm
				
				
				if(ws.readyState != 1) return;
				
				//let msg = $("#test_mem_num").val()+","+$("#test_brd_num").val()+",true";
				if($('#com_cont').val() != null){
					let msg = $('#mem_number').val();
					
					ws.send(msg);	//소켓 메세징
				}
				
				frm.submit();
				
				
				
			}); 
			
		});	 
	</script>
	 
	 

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
                <span class="date-read"><fmt:formatDate value="${list.brd_regdate }" pattern="yyyy/MM/dd HH:mm"/><span class="icon-star2"></span></span>
              </div>
	
            </div>

		<div class="pt-5">
                    <%--  <p>Categories: ${list.com_name } <a href="#">Design</a>, <a href="#">Events</a>  Tags: <a href="#">#html</a>, <a href="#">#trends</a></p>  --%>
              <p>Company : ${list.com_name }</p>
              <p>Writer : ${list.mem_id }</p>
              <div>
					<span class="date-read"> <i class="far fa-thumbs-up"   > <c:out value="${list.like_cnt}"></c:out></i>&nbsp; 
					<i class="far fa-eye"><c:out value="${list.brd_viewed}"></c:out></i>&nbsp; 
					<i class="far fa-comment"><c:out value="${fn:length(commentList)}"></c:out></i>&nbsp;
				</span>
			</div>




            <div class="pt-5">  <div>
				<span class="date-read"> <i class="far fa-thumbs-up"> 없는 데이터 (좋아요 개수) DTO에 없는 데이터</i>&nbsp; 
					<i class="far fa-eye"><c:out value="${list.brd_viewed}"></c:out></i>&nbsp; 
					<i class="far fa-comment"><c:out value="${fn:length(commentList)}"></c:out></i>&nbsp;
				</span>
			</div>
 
      
      
      
      
      			  <!-- start comment-list -->
			  <!-- 수정/버튼/목록으로 -->
		    <button type="button" class="btn btn-primary" style="background:#495464; border-color: white" >수정하기</button>&nbsp;
		            <button type="button" class="btn btn-danger" style="background:#495464; border-color: white">삭제하기</button>&nbsp;
		   	         <button type="button" class="btn btn-info" style="background:#495464; border-color: white">목록으로</button>
    
    
    	
            
    
    
             <div class="pt-5">
		                    <div class="section-title">
		                      <h2 class="mb-5"><c:out value="${fn:length(commentList)}"></c:out> Comments</h2>
		                    </div>
                    
                    
			       			<label for="content">댓글을 남겨주세요.</label>
					       <form action="anony" method="GET" name="mainCommentForm">
							      <!-- <input type="text" id="comment" size="50"/> -->
							     <input type="hidden" name="brd_num" value="${list.brd_num }" />
							     <input type="hidden" name="com_group" id="com_group" value="0" />
							     <textarea id="com_cont"  name="com_cont" class="rep_text" cols="100" rows="5"></textarea>
							     <input type="submit" value="등록"  class="btn btn-comment" id="mainComment" /> 
							     
							     <input type="hidden" id="mem_number" value="${list.mem_id }" />
							     <input type="button" value="등록"  class="btn btn-comment" id="mainComment" /> 
							     
					  		</form>
  					
                    <ul class="comment-list">
					<c:forEach var="comment" items="${commentList}">
					    <div class="form-group">

                      <c:choose>
                      
                      <c:when test="${comment.com_lev == 2}">
                      <ul class="children">
                          <li class="comment">
	                        <div class="comment-body">
	                          <h3 class="anony">익명 댓글입니다</h3>
<!-- 댓글 버튼 -->	
<div>
	<button type="button" class="btn btn-comment rep_btn" onclick="$(this).next().show();"><span class="sp">등록</span></button>
    <div class="rep_div"style="display: none;">
        <form action="" class="rep_box">
            <p class="sizing">
                <textarea id="rep_text"  class="rep_text" cols="30" rows="5"></textarea>
            </p>
            <div class="txt_count">(0 / 100)</div>
            <button type="button" id="sendBtn" class="btn btn-comment rep_btn">보내기</button>
            <button type="button" class="btn btn-comment rep_btn" onclick="$(this).parent().parent().hide();" >취소</button>
        </form>
    </div>
</div>
<!-- 댓글 버튼 -->
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
			                          <h3 class="anony">익명 댓글입니다</h3>
<!-- 댓글 버튼 -->	
<div>
    <button class="btn btn-comment rep_btn" onclick="$(this).next().show();">대댓글쓰기</button>
    <div class="rep_div"style="display: none;">
        <form action="" class="rep_box">
            <p class="sizing">
                <textarea  class="rep_text" cols="30" rows="5"></textarea>
            </p>
            <div class="txt_count">(0 / 100)</div>
            <button type="submit" class="btn btn-comment rep_btn">보내기</button>
            <button type="button" class="btn btn-comment rep_btn" onclick="$(this).parent().parent().hide();" >취소</button>
        </form>
    </div>
</div>
<!-- 댓글 버튼 -->
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
	                          <h3 class="anony">익명 댓글입니다</h3>
<!-- 댓글 버튼 -->	
<div>
    <button class="btn btn-comment rep_btn" onclick="$(this).next().show();">대댓글쓰기</button>
    <div class="rep_div"style="display: none;">
        <form action="" class="rep_box">
            <p class="sizing">
                <textarea  class="rep_text" cols="30" rows="5"></textarea>
            </p>
            <div class="txt_count">(0 / 100)</div>
            <button type="submit" class="btn btn-comment rep_btn">보내기</button>
            <button type="button" class="btn btn-comment rep_btn" onclick="$(this).parent().parent().hide();" >취소</button>
        </form>
    </div>
</div>
<!-- 댓글 버튼 -->
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

  <script type="text/javascript">
  $(function() {
      $('.rep_text').on('keyup', function() {
          $('.txt_count').html("("+$(this).val().length+" / 100)");
          if($(this).val().length > 100) {
              $(this).val($(this).val().substring(0, 100));
              $('.txt_count').html("(100 / 100)");
          }
      });
      var frmObj = $('form[id="commentListForm"]');
      $('#commentList()').on('click', function() {
    	  frmObj.attr('action', "/board/anony_board_view");
          frmObj.submit();
          
	});
  });
  
  </script>
</body>
</html>