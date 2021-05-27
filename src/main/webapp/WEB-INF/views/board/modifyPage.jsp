<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- header 영역 start -->      
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<!-- header 영역 end -->  
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
<body>
<div class="mid">
 	<form id="modifyForm" action="/board/modifyPage2" method="POST" >

    <div id="form-group">
            <label for="title" >제목</label>
      <input type="text" name="title" id="title" class="form-control" value="${gdto.brd_title }" >
    </div>
    <br>

    <div class="form-group">
      <label for="content">내용</label>
      <textarea id="summernote"   style="width:90% height:1000px; margin-bottom:35px; " name="content"  class="form-control" rows="5" onchange="consoleFunction()"
      >${gdto.brd_cont }</textarea>
    </div>

    <button type="button" class="btn btn-register" onclick="modify_submit()"><span class="sp">수정</span></button>
    <button type="button" class="btn btn-cancel">취소</button>
     <input type="hidden" name="brd_num" value="${gdto.brd_num}">
  </form>
</div>

<!-- footer 영역 start -->    
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<!-- footer 영역 end -->

</body>
</html>
