<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
  <div class="row">
    <c:forEach var="dto" items="${booksList}">
        <div class="col border border-dark m-4 w-80">
            <a href="booksRetrieve?book_id=${dto.book_id}"> 
                <img src="images/items/${dto.bImage}.jpg" width="350" height="500">
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
</div>