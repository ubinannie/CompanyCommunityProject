<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- header 영역 start -->    
<%@include file="../include/header.jsp" %>
<!-- header 영역 end -->
<br /><br /><br />
<div class="mid">
  <form  action="/board/writePage" method="POST" name="categoryForm" id="categoryForm">
    <div>
      <label for="title" >카테고리</label> 
      <select name="category" id="categoryS">
        <option value="0">Category</option>
        <option value="1" selected>회사소식</option>
        <option value="2">익명게시판</option>

      </select>

    </div><br>
    <div id="form-group">
            <label for="title" >제목</label>
      <input type="text" name="title" id="title" class="form-control" >
    </div>
    <br>

    <div class="form-group">
      <label for="content">내용</label>
      <textarea id="summernote"  style="width:90% height:1000px; margin-bottom:35px; " name="content"  class="form-control" rows="5" onchange="consoleFunction()"
      ></textarea>
    </div>

    <button type="button" class="btn btn-register" onclick="write_submit()"><span class="sp">등록</span></button>
    <button type="button" class="btn btn-cancel">취소</button>
  </form>
</div>

  <script>
  function consoleFunction(){
	  console.log('summernote ::: '+$('#summernote').val());
  }
    $('#summernote').summernote({
      toolbar: [
          // [groupName, [list of button]]
          ['fontname', ['fontname']],
          ['fontsize', ['fontsize']],
          ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
          ['color', ['forecolor','color']],
          ['table', ['table']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['height', ['height']],
          ['insert',['picture','link','video']],
          ['view', ['fullscreen', 'help']]
        ],
      fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
      fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],

      placeholder: '작성하세요', 
      tablesize: 2,
      height: 300

      

    });

    function write_submit(){
    	var chk=true;
    	
    	var testSel = $("#categoryS").val();
    	
    	console.log(testSel);
    	
    	//유효성검사 실패 
    	if($('#title').val()==''){
    		alert('제목을 입력하세요.');
    		chk=false;
    	}
    	//서머노트의 default 값은 <p><br></p> 이므로
    	if($('#summernote').val()=='<p><br></p>' || $('#summernote').val()==''){
    		alert('내용을 입력하세요.');
    		chk=false;
    	}
    	
    	//유효성 검사 모두 통과했을 때
    	// submit
    	if(chk==true){
    		//var testSel = $("select[name=category]").val();

    		if(testSel == 1){
    			//회사 소식
    			
    			$('#categoryForm').attr("action", "/board/writePage?boardSel=1");
    			$('#categoryForm').submit();
    			
    		}else if(testSel == 2){
    			//회사 소식
    			$('#categoryForm').attr("action", "/board/writePage?boardSel=2");
    			$('#categoryForm').submit();
    		}else {
    			alert("글이 입력될 곳이 존재하지 않습니다.");
    			location.href = "/main/mainPage";
    		}
	    	
    	}
    	
    	
    	
    	
    }
    
    
    
    
    

  </script>
<!-- footer 영역 start -->    
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<!-- footer 영역 end -->
</body>
</html>
