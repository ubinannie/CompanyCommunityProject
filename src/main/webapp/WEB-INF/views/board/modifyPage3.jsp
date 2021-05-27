<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!-- header 영역 start -->      
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<!-- header 영역 end -->  
 <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	

      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"> 게시글 수정 페이지</i></h3>
          	
          	<form id="modifyForm" action="/board/modifyPage2" method="POST" >
          	<!-- BASIC FORM ELELEMNTS -->
          	<div class="row mt">
          		<div class="col-lg-12">
                  <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"> 수정 내용</i></h4>
                      <!-- <form class="form-horizontal style-form" method="post" name="frm"> -->
                      	<input type="hidden" name="page" value="${pbsc.page }" />
                      	<input type="hidden" name="numPag" value="${pbsc.numPage }" />                     
                      
                      	  <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">글번호</label>
                              <div class="col-sm-8">
                                  <input type="text" class="form-control" name="bid"
                                  	value="${gdto.brd_num }" readonly="readonly">
                              </div>
                          </div>                     
                      
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">제목</label>
                              <div class="col-sm-8">
                                  <input type="text" class="form-control" name="title" id="title" 
                                  	value="${gdto.brd_title }">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">내용</label>
                              <div class="col-sm-8">                                  
                                  <textarea name="content" rows="4" class="form-control" >${gdto.brd_cont }</textarea>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">작성자</label>
                              <div class="col-sm-8">
                                  <input type="text" class="form-control" name="writer"
                                  	value="${gdto.mem_id }" readonly="readonly"
                                  >
                              </div>
                          </div>
                          <div class="form-group">
                              <div class="col-sm-12" align="center" >
                                  <button type="button" class="btn btn-success" onclick="modify_submit()">저장하기</button>&nbsp;
                                  <button type="button" class="btn btn-warning">취소하기</button>&nbsp;                                  
                              </div>
                          </div>
                        <input type="hidden" name="brd_num" value="${gdto.brd_num}">
          <!--             </form>  form end -->
                  </div> <!-- form-panel end -->
                 </div> <!-- col-lg-12 end -->
            </div>  <!-- row-mt end -->
            </form>
          </section>  <!-- wrapper end -->
      </section> <!-- main content end -->
                     
<script type="text/javascript">

              
  function modify_submit(){
       var chk=true;
       //유효성검사 실패 
       
       
       
       if($('#title').val()==''){
          alert('제목을 입력하세요.');
        
          chk=false;
       }
             
       //유효성 검사 모두 통과했을 때
       // submit
       if(chk==true){
    	 
          $('#modifyForm').submit();
       }
    }
                     
  </script>          
<!-- footer 영역 start -->    
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<!-- footer 영역 end -->




