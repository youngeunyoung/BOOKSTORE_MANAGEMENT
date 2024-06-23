<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>주문</title>
    
    <script type="text/javascript">
    /* 주소입력란 버튼 동작(숨김, 등장) */
    function showAdress(className){
    	/* 모두 숨기기 */
		$(".addressInfo_input_div").css('display', 'none');
		/* 컨텐츠 보이기 */
		$(".addressInfo_input_div_" + className).css('display', 'block');
    }
    </script>
</head>
<div class="content_area">
	<div class="content_subject"><span>장바구니</span></div>

	<div class="content_main">
				<!-- 회원 정보 -->
				<div class="member_info_div">
					<table class="table_text_align_center memberInfo_table">
						<tbody>
							<tr>
								<th style="width: 25%;">주문자</th>
								<td style="width: *">${memberInfo.memberName} | ${memberInfo.memberMail}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- 배송지 정보 -->
				<div class="addressInfo_div">
					<div class="addressInfo_button_div">
						<button class="address_btn address_btn_1" style="background-color: #3c3838;">상용자 정보 주소록</button>
						<button class="address_btn address_btn_2">직접 입력</button>
					</div>
					<div class="addressInfo_input_div_wrap">
						<div class="addressInfo_input_div addressInfo_input_div_1" style="display: block">
							<table>
			<colgroup>
				<col width="25%">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>이름</th>
					<td>
						${memberInfo.memberName}
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						${memberInfo.memberAddr1} ${memberInfo.memberAddr2}<br>${memberInfo.memberAddr3}										
					</td>
				</tr>
			</tbody>
		</table>
						</div>
						<div class="addressInfo_input_div addressInfo_input_div_2">
						
						</div>
					</div>
				</div>
				<!-- 상품 정보 -->
				<!-- 주문 종합 정보 -->
			</div>
</div>
</html>
