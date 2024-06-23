<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>주문 확인</title>
</head>
<body>
    <h1>주문 확인</h1>
    <c:choose>
        <c:when test="${not empty orderInfo}">
            <p>주문이 성공적으로 처리되었습니다.</p>
            <p>주문 번호: ${orderInfo.order_id}</p>
            <p>주문자 이름: ${orderInfo.orderName}</p>
            <p>주소: ${orderInfo.addr1} ${orderInfo.addr2}</p>
            <p>전화번호: ${orderInfo.phone1}-${orderInfo.phone2}-${orderInfo.phone3}</p>
            <p>이메일: ${orderInfo.email1}@${orderInfo.email2}</p>
            <p>주문 날짜: ${orderInfo.orderDate}</p>
            <p>총 가격: ${orderInfo.totalPrice}</p>
            <!-- 추가적으로 주문 상품 리스트 등을 출력할 수 있습니다 -->
        </c:when>
        <c:otherwise>
            <p>주문 정보가 없습니다.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
