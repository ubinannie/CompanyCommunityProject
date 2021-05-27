<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Cassi &mdash; Community Web</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link
	href="https://fonts.googleapis.com/css?family=B612+Mono|Cabin:400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="/resources/all_css/fonts/icomoon/style.css">

<link rel="stylesheet" href="/resources/all_css/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/all_css/css/jquery-ui.css">
<link rel="stylesheet"
	href="/resources/all_css/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="/resources/all_css/css/owl.theme.default.min.css">
<link rel="stylesheet"
	href="/resources/all_css/css/owl.theme.default.min.css">

<link rel="stylesheet"
	href="/resources/all_css/css/jquery.fancybox.min.css">

<link rel="stylesheet"
	href="/resources/all_css/css/bootstrap-datepicker.css">

<link rel="stylesheet"
	href="/resources/all_css/fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="/resources/all_css/css/aos.css">
<link href="/resources/all_css/css/jquery.mb.YTPlayer.min.css"
	media="all" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="/resources/all_css/css/style.css">
<link rel="stylesheet" href="/resources/all_css/css/grid-container.css">

<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />



<script type="text/javaScript">
function move(){
     location.href = "writePage";
}
</script>


</head>

<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">
<%@include file="../include/header.jsp" %>
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
					<div class="col-lg-9">
						<div class="section-title">
							<span class="caption d-block small">Cassi</span>
							<h2>HOT 게시판</h2>
						</div>
					</div>
					<div class="container">

						<div class="row">
							<c:forEach var="Go_boardDTO" items="${hotList}" 
								varStatus="status">
								<div class="col-sm-5 col-md-6">
									<div class="p-3 border bg-light">
										<div class="post-entry-2 d-flex">
											<div class="contents order-md-1 pl-0">
												<p class="mb-3">
													<c:out value="${Go_boardDTO.com_name}"></c:out>
												</p>

												<h2>
													<a href="/board/hot_board_view?brd_num=${Go_boardDTO.brd_num}">
														<c:out value="${Go_boardDTO.brd_title}"></c:out>
													</a>
												</h2>
												<p class="mb-3" id="content_txt"></p>
												<!-- summernote에 html이 그대로 들어가므로, html로 보여주기 위함. -->
												<div class="post-meta">
													<span class="d-block"> <c:out
															value="${Go_boardDTO.mem_id}"></c:out>
													</span> <span class="date-read"> <i
														class="far fa-thumbs-up"> 없는 데이터 (좋아요 개수) DTO에 없는 데이터
													</i>&nbsp; <i class="far fa-eye"> <c:out
																value="${Go_boardDTO.brd_viewed}"></c:out>
													</i>&nbsp; <i class="far fa-comment"> 없는 데이터 (코멘트 개수) </i>&nbsp;
													</span>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>

						</div>




					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<ul class="custom-pagination list-unstyled">
							<c:if test="${paging.pre}">
								<li><a href="/board/hot_board?page=${paging.start-1}"><i
										class="fas fa-angle-left"></i></a></li>
							</c:if>
							<c:forEach var="i" begin="${paging.start}" end="${paging.end}">
								<c:if test="">
								</c:if>
								<c:choose>
									<c:when test="${paging.ct.page == i}">
										<li><a style="color: black;"
											href="/board/hot_board?page=${i}"><c:out value="${i}"></c:out></a></li>
									</c:when>
									<c:otherwise>
										<li><a href="/board/hot_board?page=${i}"><c:out
													value="${i}"></c:out></a></li>
									</c:otherwise>
								</c:choose>

							</c:forEach>
							<c:if test="${paging.next}">
								<li><a href="/board/hot_board?page=${paging.end+1}"><i
										class="fas fa-angle-right"></i></a></li>
							</c:if>
						</ul>
					</div>
				</div>

			</div>
		</div>




	</div>
	<!-- .site-wrap -->


	<!-- loader -->
	<!--   <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#ff5e15"/></svg></div> -->

	<script src="/resources/all_css/js/jquery-3.3.1.min.js"></script>
	<script src="/resources/all_css/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="/resources/all_css/js/jquery-ui.js"></script>
	<script src="/resources/all_css/js/popper.min.js"></script>
	<script src="/resources/all_css/js/bootstrap.min.js"></script>
	<script src="/resources/all_css/js/owl.carousel.min.js"></script>
	<script src="/resources/all_css/js/jquery.stellar.min.js"></script>
	<script src="/resources/all_css/js/jquery.countdown.min.js"></script>
	<script src="/resources/all_css/js/bootstrap-datepicker.min.js"></script>
	<script src="/resources/all_css/js/jquery.easing.1.3.js"></script>
	<script src="/resources/all_css/js/aos.js"></script>
	<script src="/resources/all_css/js/jquery.fancybox.min.js"></script>
	<script src="/resources/all_css/js/jquery.sticky.js"></script>
	<script src="/resources/all_css/js/jquery.mb.YTPlayer.min.js"></script>




	<script src="js/main.js"></script>
	<script>
	/* summerNote html 태그로 db에 저장돼서 html태그 안 보이게 해주는 함수 */	
	$(document).ready(function(){
		$('#context.txt').html(${Go_boardDTO.brd_cont});
	});
	</script>
	
	<%@include file="../include/footer.jsp" %>
	
</body>

</html>