<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>장바구니</title>
    
    <script type="text/javascript">
   		function deleteItem(itemId) {
        const form = document.createElement("form");
        form.method = "post";
        form.action = "/delete";
        const input = document.createElement("input");
        input.type = "hidden";
        input.name = "itemId";
        input.value = itemId;
        form.appendChild(input);
        document.body.appendChild(form);
        alert("삭제된 상품" + itemId);
        form.submit();
      }
   		
   	 document.addEventListener("DOMContentLoaded", () => {
   		 const selectAllCheckbox = document.getElementById("selectAll");
         if (selectAllCheckbox) {
             selectAllCheckbox.onclick = function () {
                 const checkboxes = document.querySelectorAll('input[name="selectedItems"]');
                 for (const checkbox of checkboxes) {
                     checkbox.checked = this.checked;
                 }
             };
         }

         document.getElementById("checkoutButton").onclick = function () {
             const selectedItems = [];
             const checkboxes = document.querySelectorAll(
               'input[name="selectedItems"]:checked'
             );
             for (const checkbox of checkboxes) {
               selectedItems.push(checkbox.value);
             }
             alert(selectedItems);
         }
         });
    </script>
</head>
<body>
    <h1>장바구니</h1>
    <c:choose>
        <c:when test="${not empty cartInfo}">
            <table border="1">
                <tr>
                	<th></th>
                    <th>상품명</th>
                    <th>가격</th>
                    <th>수량</th>
                    <th>삭제</th>
                </tr>
                <c:forEach var="item" items="${cartInfo}">
                    <tr>
                    <td>
                    	<input type="checkbox" name="selectedItems" value="${item.cart_num}"/>
                    	<img src="images/items/${item.bImage}.jpg" width="50" height="50"></td>
                        <td>${item.book_name}</td>
                        <td>${item.book_price}</td>
                        <td>${item.quantity}</td>
                        
                        <td>
                            <form action="cart/delete" method="post">
                                <input type="hidden" name="cart_num" value="${item.cart_num}">
                                <button type="submit">삭제</button>
                            </form>
                            
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <!-- 주문 form -->
			<form action="/order/${member.member_id}" method="get" class="order_form">
				<input type="hidden" name="orders[0].book_id" value="${booksInfo.book_id}">
				<input type="hidden" name="orders[0].qantity" value="">
				<button type="button" id="checkoutButton">결제하기</button>
			</form>
 
        </c:when>
        <c:otherwise>
            <p>장바구니가 비어 있습니다.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
