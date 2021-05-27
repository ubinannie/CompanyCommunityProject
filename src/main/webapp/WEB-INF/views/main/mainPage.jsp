<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- header 영역 start -->    
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<!-- header 영역 end -->



    <div class="grid-container">
      <div class="grid1"><table class="table">
        <thead>
          <tr>
            <th>인기글</th>
            <th></th>
         <th></th>
            <th><a href="./board/pop_board" class="more-view" >more</a></th> 
          </tr>
        </thead>
        <tbody>
           <tr>
                <td>팝잘알 팝송제목 알려주세요!!</td>
               <td><i class="far fa-thumbs-up">100</i></td>
              <td><i class="far fa-comment">52</i></td>
              <td><i class="far fa-eye">7</i></td>
          </tr>
          <tr>
                <td>10년 전 기타 치던 선임이 있었는데...</td>
               <td><i class="far fa-thumbs-up">98</i></td>
              <td><i class="far fa-comment">82</i></td>
              <td><i class="far fa-eye">7</i></td>
          </tr>
          <tr>
                <td>생각난김에 간단하게 쓰는 일본 it 시장 썰</td>
               <td><i class="far fa-thumbs-up">83</i></td>
              <td><i class="far fa-comment">50</i></td>
              <td><i class="far fa-eye">7</i></td>
          </tr>
            <tr>
                <td>급이 다른 제주도 맛집 소개</td>
               <td><i class="far fa-thumbs-up">77</i></td>
              <td><i class="far fa-comment">23</i></td>
              <td><i class="far fa-eye">7</i></td>
          </tr>
             <tr>
                <td>저분자 콜라겐 효과 어떤 것 같아?</td>
               <td><i class="far fa-thumbs-up">63</i></td>
              <td><i class="far fa-comment">38</i></td>
              <td><i class="far fa-eye">7</i></td>
          </tr>  
          
        
        
        
<%--         <c:forEach var="row" items="${row}" >
          <tr>
             <td>${row.brd_title}</td>
             <td>${row.brd_cont}</td>
            <td><i class="far fa-thumbs-up">1</i></td>
            <td><i class="far fa-comment"></i></td>
            <td><i class="far fa-eye">${row.brd_viewed}</i></td>
          </tr>
         </c:forEach> --%>
         
        </tbody>
      </table></div>
      <div class="grid2"><table class="table">
        <thead>
          <tr>
            <th>HOT게시판</th>
            <th></th>
         <th></th>
            <th><a href="./board/hot_board" class="more-view" >more</a></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>치즈버거 덕후들 환장할 소식</td>
            <td><i class="far fa-thumbs-up">3</i></td>
            <td><i class="far fa-comment">37</i></td>
            <td><i class="far fa-eye">27</i></td>
          </tr>
          <tr>
            <td>오늘 나 예뿐거 입고 출근해따</td>
            <td><i class="far fa-thumbs-up">3</i></td>
            <td><i class="far fa-comment">37</i></td>
            <td><i class="far fa-eye">27</i></td>
          </tr>
          <tr>
            <td>복치 오랜만에 요리해따</td>
            <td><i class="far fa-thumbs-up">3</i></td>
            <td><i class="far fa-comment">37</i></td>
            <td><i class="far fa-eye">27</i></td>
          </tr>
         <tr>
            <td>해외출장에 뭐 챙겨가지.</td>
            <td><i class="far fa-thumbs-up">3</i></td>
            <td><i class="far fa-comment">37</i></td>
            <td><i class="far fa-eye">27</i></td>
          </tr>
          
          
          
         
          
          
          
        </tbody>
      </table></div>
      <div class="grid3"><table class="table">
        <thead>
          <tr>
            <th>익명게시판</th>
            <th></th>
         <th></th>
            <th><a href="./board/anony_board" class="more-view" >more</a></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>회사동료가 말은 안걸어</td>
            <td><i class="far fa-thumbs-up">100</i></td>
            <td><i class="far fa-comment">37</i></td>
            <td><i class="far fa-eye">7</i></td>
          </tr>
          <tr>
            <td>오늘 나 예뿐거 입고 출근해따</td>
            <td><i class="far fa-thumbs-up">100</i></td>
            <td><i class="far fa-comment">37</i></td>
            <td><i class="far fa-eye">7</i></td>
          </tr>
          <tr>
            <td>20억 현금으로 있으면 일 그만둬?</td>
            <td><i class="far fa-thumbs-up">100</i></td>
            <td><i class="far fa-comment">37</i></td>
            <td><i class="far fa-eye">7</i></td>
          </tr>
        </tbody>
      </table></div>
      <div class="grid4">
        <table class="table">
          <thead>
            <tr>
              <th>회사소식</th>
              <th><a href="./board/news_board" class="more-view" >more</a></th>
            </tr>
          </thead>
          <tbody>
          <tr>
            <td>치즈버거 덕후들 환장할 소식</td>
            <td><i class="far fa-eye">72</i></td>
          </tr>
       <tr>
            <td>해외출장에 뭐 챙겨가지.</td>
            <td><i class="far fa-eye">52</i></td>
          </tr>
          <tr>
            <td>복치 오랜만에 요리해따</td>
            <td><i class="far fa-eye">53</i></td>
          </tr>
            <tr>
              <td>제주 렌트카 5월 </td>
            <td><i class="far fa-eye">42</i></td>
          </tr>
       <tr>
            <td>치즈버거 덕후들 환장할 소식</td>
            <td><i class="far fa-eye">72</i></td>
          </tr>
       <tr>
            <td>해외출장에 뭐 챙겨가지.</td>
            <td><i class="far fa-eye">52</i></td>
          </tr>
          <tr>
            <td>복치 오랜만에 요리해따</td>
            <td><i class="far fa-eye">53</i></td>
          </tr>
            <tr>
              <td>제주 렌트카 5월 </td>
            <td><i class="far fa-eye">42</i></td>
          </tr>
                    <tr>
            <td>치즈버거 덕후들 환장할 소식</td>
            <td><i class="far fa-eye">72</i></td>
          </tr>
       <tr>
            <td>해외출장에 뭐 챙겨가지.</td>
            <td><i class="far fa-eye">52</i></td>
          </tr>


          </tbody>
        </table>
      </div>  
    </div>


  </div>
  





	<!-- footer 영역 start -->    
	<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
	<!-- footer 영역 end -->
</body>

</html>