<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>장바구니</title>
</head>
<body>
    <h1>장바구니</h1>
    <c:choose>
        <c:when test="${not empty cartInfo}">
            <table border="1">
                <tr>
                    <th>상품명</th>
                    <th>가격</th>
                    <th>수량</th>
                    <th>이미지</th>
                    <th>삭제</th>
                </tr>
                <c:forEach var="item" items="${cartInfo}">
                    <tr>
                        <td>${item.book_name}</td>
                        <td>${item.book_price}</td>
                        <td>${item.quantity}</td>
                        <td><img src="images/items/${item.bImage}.jpg" width="50" height="50"></td>
                        <td>
                            <form action="cart/delete" method="post">
                                <input type="hidden" name="cart_num" value="${item.cart_num}">
                                <button type="submit">삭제</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p>장바구니가 비어 있습니다.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
