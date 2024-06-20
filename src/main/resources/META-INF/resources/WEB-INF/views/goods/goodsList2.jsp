<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
  <div class="row">
    <c:forEach var="dto" items="${bookAll}">
        <div class="col border border-dark m-4 w-80">
            <a href="booksRetrieve?book_id=${dto.book_id}"> 
                <img src="images/items/${dto.bImage}.jpg" width="350" height="550">
            </a>
            <div class="mt-4 fs-6">${dto.book_name}</div>
            <div class="mt-2 fs-6">${dto.book_session}</div>
            <div class="mt-2 fs-6">${dto.book_price}</div>
            <div class="mt-2 fs-6">${dto.book_author}</div>
            <div class="mt-2 fs-6">${dto.book_publisher}</div>
            <div class="mt-2 fs-6">${dto.book_num}</div>
        </div>
    </c:forEach>
  </div>
  
  <!-- <div class="row"> 
    <nav aria-label="Page navigation example">
      <ul class="pagination">
        <c:if test="${currentPage > 1}">
          <li class="page-item">
            <a class="page-link" href="main?page=${currentPage - 1}&size=${pageSize}" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
        </c:if>

        <c:forEach var="i" begin="1" end="${totalPages}">
          <li class="page-item ${i == currentPage ? 'active' : ''}">
            <a class="page-link" href="main?page=${i}&size=${pageSize}">${i}</a>
          </li>
        </c:forEach>

        <c:if test="${currentPage < totalPages}">
          <li class="page-item">
            <a class="page-link" href="main?page=${currentPage + 1}&size=${pageSize}" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
        </c:if>
      </ul>
    </nav>
  </div>
  -->
  
</div>