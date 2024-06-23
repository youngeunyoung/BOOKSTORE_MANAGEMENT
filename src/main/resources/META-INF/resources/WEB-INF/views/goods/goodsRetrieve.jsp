<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jQuery 설치 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	
    	$("#up").on("click", function(){
    	    var quantity = Number.parseInt($("#quantity").val());
    	    var currentStock = Number.parseInt($("#currentStock").val());
    	    
    	    if (quantity < currentStock) {
    	        $("#quantity").val(quantity + 1);
    	    } else {
    	        $("#quantity").val(currentStock);
    	        alert("현재 재고 수량을 초과하여 더 이상 증가할 수 없습니다.");
    	    }
    	});

    	$("#down").on("click", function(){
    	    var quantity = Number.parseInt($("#quantity").val());
    	    
    	    if (quantity == 1) {
    	        alert("최소 1개 이상의 상품을 선택하셔야 합니다.");
    	    } else {
    	        $("#quantity").val(quantity - 1);
    	    }
    	});

        $("form").on("submit", function(e){
            e.preventDefault(); // 기본 폼 제출 동작을 막습니다.
            var gAmount = parseInt($("#gAmount").val());
            var currentStock = parseInt($("#currentStock").val());
            if (gAmount > currentStock) {
                alert("선택한 수량이 재고를 초과하였습니다.");
                return false; // 폼 제출을 중지합니다.
            }
            alert("장바구니에 추가됩니다."); // 장바구니에 추가되었음을 알립니다.
            this.submit(); // 폼을 제출합니다.
        });
    });
</script>

<div class="container">
    <form class="row g-3 m-4" action="/shop/cart/add" method="post">
        <input type="hidden" name="book_id" value="${booksRetrieve.book_id}">
        <input type="hidden" name="member_id" value="${login.member_id}">
        <div class="row">
            <div class="card" style="width:25rem;">
                <img src="images/items/${booksRetrieve.bImage}.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h6 class="card-title">
                        <span class="fw-bold">장르:</span>
                        ${booksRetrieve.book_session}
                    </h6>
                    <h6 class="card-text">
                        <span class="fw-bold ">상품명:</span>
                        ${booksRetrieve.book_name}
                    </h6>
                    <h6 class="card-text">
                        <span class="fw-bold ">작가:</span>
                        ${booksRetrieve.book_author}
                    </h6>
                    <h6 class="card-text">
                        <span class="fw-bold ">출판사:</span>
                        ${booksRetrieve.book_publisher}
                    </h6>
                    <h6 class="card-text">
                        <span class="fw-bold ">가격:</span>
                        ${booksRetrieve.book_price}
                    </h6>
                    <h6 class="card-text">
                        <span class="fw-bold ">재고수량:</span>
                        ${booksRetrieve.book_num}
                    </h6>
                    <h6 class="card-text">
                        <span class="fw-bold ">주문수량:</span>
                        <input type="text" name="quantity" value="1" id="quantity">
                        <input type="hidden" name="currentStock" value="${booksRetrieve.book_num}" id="currentStock">
                        <img src="images/up.PNG" id="up">
                        <img src="images/down.PNG" id="down">
                    </h6>
                    <button type="submit" class="btn btn-primary mt-3">장바구니</button>
                </div>
            </div>
        </div>
    </form>
</div>
