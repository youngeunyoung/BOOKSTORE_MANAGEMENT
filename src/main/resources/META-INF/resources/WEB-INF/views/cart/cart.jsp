<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>장바구니</title>
    
    <style>
        table {
            width: 70%;
            margin: auto;
            border-collapse: collapse;
            text-align: center;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        img {
            width: 100px;
            height: 100px;
        }
    </style>
    
    <script type="text/javascript">
    function deleteItem(cart_num) {
        const form = document.createElement("form");
        form.method = "post";
        form.action = "/cart/delete";
        const input = document.createElement("input");
        input.type = "hidden";
        input.name = "cart_num";
        input.value = cart_num;
        form.appendChild(input);
        document.body.appendChild(form);
        form.submit();
    }
    
    function updateQuantity(cart_num) {
        const quantityInput = document.querySelector('input[name="quantity_' + cart_num + '"]');
        const form = document.createElement("form");
        form.method = "post";
        form.action = "/cart/update";
        const cartNumInput = document.createElement("input");
        cartNumInput.type = "hidden";
        cartNumInput.name = "cart_num";
        cartNumInput.value = cart_num;
        form.appendChild(cartNumInput);
        const quantity = document.createElement("input");
        quantity.type = "hidden";
        quantity.name = "quantity";
        quantity.value = quantityInput.value;
        form.appendChild(quantity);
        document.body.appendChild(form);
        form.submit();
    }
    
    function calculateTotalPrice() {
        const checkboxes = document.querySelectorAll('input[name="selectedItems"]:checked');
        let totalPrice = 0;
        checkboxes.forEach((checkbox) => {
            const cartNum = checkbox.value;
            const quantityInput = document.querySelector('input[name="quantity_' + cart_num + '"]');
            if (quantityInput) {
                const priceText = quantityInput.parentElement.nextElementSibling.textContent.trim();
                const itemPrice = parseInt(priceText.replace(/[^\d]/g, ''), 10) * parseInt(quantityInput.value, 10);
                totalPrice += itemPrice;
            } else {
                console.error(`Quantity input for cartNum ${cart_num} not found.`);
            }
        });
        document.getElementById("totalPrice").textContent = "총 금액: " + totalPrice.toLocaleString() + "원";
    }
    
    document.addEventListener("DOMContentLoaded", () => {
        const selectAllCheckbox = document.getElementById("selectAll");
        if (selectAllCheckbox) {
            selectAllCheckbox.onclick = function () {
                const checkboxes = document.querySelectorAll('input[name="selectedItems"]');
                for (const checkbox of checkboxes) {
                    checkbox.checked = this.checked;
                }
                calculateTotalPrice();
            };
        }

        document.getElementById("checkoutButton").onclick = function () {
            const selectedItems = [];
            const checkboxes = document.querySelectorAll('input[name="selectedItems"]:checked');
            for (const checkbox of checkboxes) {
                selectedItems.push(checkbox.value);
            }
            if (selectedItems.length > 0) {
                const form = document.createElement("form");
                form.method = "post";
                form.action = "/shop/order";

                selectedItems.forEach((itemId, index) => {
                    const inputBookId = document.createElement("input");
                    inputBookId.type = "hidden";
                    inputBookId.name = "orders[" + index + "].book_id";
                    inputBookId.value = itemId;
                    form.appendChild(inputBookId);

                    const quantityInput = document.querySelector('input[name="quantity_' + itemId + '"]');
                    const inputQuantity = document.createElement("input");
                    inputQuantity.type = "hidden";
                    inputQuantity.name = "orders[" + index + "].quantity";
                    inputQuantity.value = quantityInput ? quantityInput.value : "1"; // Default to 1 if quantityInput is not found

                    form.appendChild(inputQuantity);
                });

                document.body.appendChild(form);
                form.submit();
            } else {
                alert("선택된 상품이 없습니다.");
            }
        };

        document.querySelectorAll('input[name="selectedItems"]').forEach((checkbox) => {
            checkbox.addEventListener('change', () => {
                calculateTotalPrice();
            });
        });

        calculateTotalPrice();
    });
</script>


</head>
<body>
    <h1 style="text-align: center;">장바구니</h1>
    <c:choose>
        <c:when test="${not empty cartInfo}">
            <table>
                <thead>
                    <tr>
                        <th></th>
                        <th>상품 이미지</th>
                        <th>상품명</th>
                        <th>가격</th>
                        <th>수량</th>
                        <th>변경</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${cartInfo}">
                        <tr>
                            <td>
                                <input type="checkbox" name="selectedItems" value="${item.cart_num}" style="vertical-align: middle;">
                            </td>
                            <td>
                                <img src="images/items/${item.bImage}.jpg">
                            </td>
                            <td>
                                ${item.book_name}
                            </td>
                            <td>
                                ${item.book_price}
                            </td>
                            <td>
                                <input type="number" name="quantity_${item.cart_num}" value="${item.quantity}" min="1">
                            </td>
                            <td>
                                <button type="button" onclick="updateQuantity(${item.cart_num})">변경</button>
                            </td>
                            <td>
                                <button type="button" onclick="deleteItem(${item.cart_num})">삭제</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div style="text-align: center; margin-top: 20px;">
                <button type="button" id="checkoutButton">주문하기</button>
                <div id="totalPrice" style="margin-top: 10px;"></div>
            </div>
        </c:when>
        <c:otherwise>
            <p style="text-align: center;">장바구니가 비어 있습니다.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
