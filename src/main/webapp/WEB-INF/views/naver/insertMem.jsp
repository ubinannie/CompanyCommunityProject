<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var frmObj = $('form[name="frmInsert"]');			//클래스 없이 속성으로 누군지 인식
	console.log(frmObj.val());
	
	$('#insert').on('click', function(){
		//alert('insert btn click');
		
		frmObj.attr("action", "/naver/insertMem");
		frmObj.attr("method", "post");		//post로 보내기
		frmObj.submit();
		
		
	});
	
	
});
	
</script>

</head>
<body>
	<!-- 뷰쪽에서 값받기 -->
	<h1>가입페이지</h1>
	
	<form name="frmInsert">
		<input type="text" name="mem_id" value="${mem_id }" readonly="readonly"/>
		<input type="text" name="mem_name" value="${mem_name }" readonly="readonly"/>
		<input type="text" name="mem_email" value="${mem_email }" readonly="readonly"/>
		<input type="text" name="com_name" placeholder="회사명 입력"/>
		
		<input type="button" value="가입" id="insert" />
	</form>
	
</body>
</html>