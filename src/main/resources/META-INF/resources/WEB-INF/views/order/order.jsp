<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>주문 확인</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .content_area {
            width: 80%;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .content_subject {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .input_field {
            margin-bottom: 10px;
        }
        .input_field label {
            display: block;
            margin-bottom: 5px;
        }
        .input_field input, .input_field select {
            width: calc(100% - 10px);
            padding: 5px;
            border: 1px solid #ccc;
        }
        .input_field .form-control {
            width: 100%;
        }
        .button_group {
            margin-top: 20px;
            text-align: center;
        }
        .btn {
            padding: 10px 20px;
            border: none;
            background-color: #28a745;
            color: white;
            cursor: pointer;
            font-size: 16px;
        }
        .order_summary {
            margin-top: 20px;
            border-top: 1px solid #ccc;
            padding-top: 10px;
        }
        .order_summary .order_item {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
        }
        .order_summary .order_item img {
            max-width: 100px;
            margin-right: 10px;
        }
        .order_summary .order_item .info {
            flex: 1;
        }
        .order_summary .order_item .info div {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
    <div class="content_area">
        <div class="content_subject">주문 확인</div>

        <form action="processOrder.jsp" method="post">
            <!-- 주문자 정보 입력 -->
            <div class="input_field">
                <label for="orderName">주문자</label>
                <input type="text" id="orderName" name="orderName" required>
            </div>

            <!-- 우편번호 검색 -->
            <div class="input_field">
                <label for="post">우편번호</label>
                <div class="row mb-3">
                    <div class="col-auto">
                        <input type="text" name="post" class="form-control" id="post" placeholder="우편번호">
                    </div>
                    <div class="col-auto">
                        <button type="button" class="btn btn-primary mb-3" onclick="sample4_execDaumPostcode()">우편번호 찾기</button>
                    </div>
                </div>
            </div>

            <!-- 도로명주소 및 지번주소 -->
            <div class="input_field">
                <label for="addr1">도로명주소</label>
                <input type="text" id="addr1" name="addr1" class="form-control" placeholder="도로명주소">
            </div>
            <div class="input_field">
                <label for="addr2">지번주소</label>
                <input type="text" id="addr2" name="addr2" class="form-control" placeholder="지번주소">
                <span id="guide" style="color:#999"></span>
            </div>

            <!-- 전화번호 -->
            <div class="input_field">
                <label for="phone">전화번호</label>
                <div class="row mb-3">
                    <div class="col-auto">
                        <select name="phone1" class="form-control" id="phone1">
                            <option value="010">010</option>
                            <option value="011">011</option>
                        </select>
                    </div>
                    <div class="col-auto">
                        <input type="text" name="phone2" class="form-control" id="phone2">
                    </div>
                    <div class="col-auto">
                        <input type="text" name="phone3" class="form-control" id="phone3">
                    </div>
                </div>
            </div>

            <!-- 이메일 -->
            <div class="input_field">
                <label for="email1">이메일</label>
                <div class="row mb-3">
                    <div class="col-auto">
                        <input type="text" name="email1" class="form-control" id="email1">
                    </div>
                    <div class="col-auto">
                        <label for="xxx" class="visually-hidden">@</label>
                        <span>@</span>
                    </div>
                    <div class="col-auto">
                        <select name="email2" class="form-control" id="email2" onchange="checkEmailOption(this)">
                            <option value="daum.net">daum.net</option>
                            <option value="google.com">google.com</option>
                            <option value="naver.com">naver.com</option>
                            <option value="direct">직접입력</option>
                        </select>
                    </div>
                    <div class="col-auto" id="email2DirectDiv" style="display:none;">
                        <input type="text" name="email2Direct" class="form-control" id="email2Direct" placeholder="직접입력">
                    </div>
                </div>
            </div>

            <!-- 주문 정보 표시 -->
            <div class="order_summary">
                <!-- 주문 정보 출력 -->
                <c:forEach items="${cart.items}" var="item">
                    <div class="order_item">
                        <img src="${item.image}" alt="${item.bookName}">
                        <div class="info">
                            <div><strong>도서명:</strong> ${item.bookName}</div>
                            <div><strong>수량:</strong> ${item.quantity}</div>
                            <div><strong>가격:</strong> ${item.price}</div>
                            <div><strong>총 가격:</strong> ${item.totalPrice}</div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!-- 결제 버튼 -->
            <div class="button_group">
                <button type="submit" class="btn">결제하기</button>
            </div>
        </form>
    </div>

    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script>
        // 우편번호 검색 함수
        function sample4_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    var fullRoadAddr = data.roadAddress;
                    var extraRoadAddr = '';

                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                        extraRoadAddr += data.bname;
                    }
                    if (data.buildingName !== '' && data.apartment === 'Y') {
                        extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    if (extraRoadAddr !== '') {
                        extraRoadAddr = ' (' + extraRoadAddr + ')';
                    }
                    if (fullRoadAddr !== '') {
                        fullRoadAddr += extraRoadAddr;
                    }

                    document.getElementById('post').value = data.zonecode;
                    document.getElementById('addr1').value = fullRoadAddr;
                    document.getElementById('addr2').value = data.jibunAddress;

                    if (data.autoRoadAddress) {
                        var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                        document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    } else if (data.autoJibunAddress) {
                        var expJibunAddr = data.autoJibunAddress;
                        document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    } else {
                        document.getElementById('guide').innerHTML = '';
                    }
                }
            }).open();
        }

        // 이메일 옵션 선택에 따른 처리
        function checkEmailOption(select) {
            var value = select.value;
            if (
