<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- header 영역 start -->      
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<!-- header 영역 end -->  

		<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-lg-9">
						<div class="section-title">
							<span class="caption d-block small">BlahBlah</span>
							<h2>인기글</h2>
						</div>
					</div>
					<div class="container">

						<div class="row">
							<c:forEach var="Go_boardDTO" items="${popList}" 
								varStatus="status">
								<div class="col-sm-5 col-md-6">
									<div class="p-3 border bg-light">
										<div class="post-entry-2 d-flex">
											<div class="contents order-md-1 pl-0">
												<p class="mb-3">
													<c:out value="${Go_boardDTO.com_name}"></c:out>
												</p>

												<h2>
													<a href="pop_board_view?brd_num=${Go_boardDTO.brd_num}">
														<c:out value="${Go_boardDTO.brd_title}"></c:out>
													</a>
												</h2>
												<p class="mb-3" id="content_txt"></p>
												<!-- summernote에 html이 그대로 들어가므로, html로 보여주기 위함. -->
												<div class="post-meta">
													<span class="d-block"> <c:out
															value="${Go_boardDTO.mem_id}"></c:out>
													</span> <span class="date-read"> <i
														class="far fa-thumbs-up">  <c:out value="${Go_boardDTO.like_cnt}"></c:out>
													</i>&nbsp; <i class="far fa-eye"> <c:out
																value="${Go_boardDTO.brd_viewed}"></c:out>
													</i>&nbsp;<!--  <i class="far fa-comment"> 없는 데이터 (코멘트 개수) </i>&nbsp; -->
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
								<li><a href="/board/pop_board?page=${paging.start-1}"><i
										class="fas fa-angle-left"></i></a></li>
							</c:if>
							<c:forEach var="i" begin="${paging.start}" end="${paging.end}">
								<c:if test="">
								</c:if>
								<c:choose>
									<c:when test="${paging.ct.page == i}">
										<li><a style="color: black;"
											href="/board/pop_board?page=${i}"><c:out value="${i}"></c:out></a></li>
									</c:when>
									<c:otherwise>
										<li><a href="/board/pop_board?page=${i}"><c:out
													value="${i}"></c:out></a></li>
									</c:otherwise>
								</c:choose>

							</c:forEach>
							<c:if test="${paging.next}">
								<li><a href="/board/pop_board?page=${paging.end+1}"><i
										class="fas fa-angle-right"></i></a></li>
							</c:if>
						</ul>
					</div>
				</div>

			</div>
		</div>




	</div>
<!-- footer 영역 start -->    
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<!-- footer 영역 end -->
	<!-- .site-wrap -->


	<!-- loader -->
	<!--   <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#ff5e15"/></svg></div> -->

	<script>
	/* summerNote html 태그로 db에 저장돼서 html태그 안 보이게 해주는 함수 */	
	$(document).ready(function(){
		$('#context.txt').html(${Go_boardDTO.brd_cont});
	});
	</script>

</body>

</html>