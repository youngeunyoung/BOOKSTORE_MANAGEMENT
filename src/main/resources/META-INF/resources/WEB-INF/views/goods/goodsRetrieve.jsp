<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jQuery 설치 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
	
	
		$("#up").on("click", function(){


		    var gAmount = Number.parseInt($("#quantity").val());
		    var currentStock = Number.parseInt($("#currentStock").val());
		    if (gAmount < currentStock) {
		        $("#quantity").val(gAmount+1);
		    } else {
		        $("#quantity").val(currentStock);
		        alert("현재 재고 수량을 초과하여 더 이상 증가할 수 없습니다.");
		    }

		});

		$("#down").on("click", function(){
			var gAmount = Number.parseInt($("#gAmount").val());
		    var currentStock = Number.parseInt($("#currentStock").val());
			if(gAmount==1){
				$("#gAmount").val(1)
				alert("최소 1개 이상의 수량을 선택하셔야 합니다.");
			}else{
				$("#gAmount").val(gAmount-1);
			}
		});
		
		$("form").on("submit", function(){
			alert("cartForm submit");
			this.action="/shop/cart/add";  //CartController의 맵핑값
			this.method="post";
		});
		// 장바구니 버튼 클릭 시 폼 서브밋 > 버튼 클릭시에만 이벤트 발생
       /* $("#cartButton").on("click", function(e){
            e.preventDefault(); // 기본 동작 방지
            $("form").submit(); // 폼 서브밋
        });*/
		
	});// ready()
</script>
<div class="container">
	<form class="row g-3 m-4">
	<input type="hidden" name="book_id" value="${booksRetrieve.book_id}">
	<input type="hidden" name="member_id" value="${login.member_id}">
 	  <div class="row">    
		<div class="card" style="width:25rem;">
		  <img src="images/items/${booksRetrieve.bImage}.jpg" class="card-img-top" alt="...">
		  <div class="card-body">
		    <h6 class="card-title">
		        <span class="fw-bold">장르:</span>  
		        ${booksRetrieve.book_session}</h6>
		    <h6 class="card-text">
		      <span class="fw-bold ">상품명:</span>
		       ${booksRetrieve.book_name}</h6>
		       <h6 class="card-text">
		      <span class="fw-bold ">작가:</span>
		       ${booksRetrieve.book_author}</h6>
		       <h6 class="card-text">
		      <span class="fw-bold ">출판사:</span>
		       ${booksRetrieve.book_publisher}</h6>
		    <h6 class="card-text">
		      <span class="fw-bold ">가격:</span>
		       ${booksRetrieve.book_price}</h6>
		       <h6 class="card-text">
		      <span class="fw-bold ">재고수량:</span>
		       ${booksRetrieve.book_num}</h6>

		<!-- 카트 테이블 만들고 수정하기 -->		     
			 <h6 class="card-text">
			 
			      <span class="fw-bold ">주문수량:</span>
			      <input type="text" name="quantity" value="1" id="quantity">
			      <input type="hidden" name="currentStock" value="${booksRetrieve.book_num}" id="currentStock">
			      <img src="images/up.PNG" id="up"> 
			      <img src="images/down.PNG" id="down">
		     
		      </h6>
		    <!-- <a href="#" class="btn btn-primary mt-3">구매</a> -->
		    <button type="submit" id="cartButton" class="btn btn-primary mt-3">장바구니</a>
		  </div>
		  
		</div>
	   
	  </div>
	</form>
</div>