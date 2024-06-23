<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인홈페이지</title>
<link rel="stylesheet"  href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
	<style type="text/css">
	    .Top {
		width: 100%;
    	font-size: 16px;
    	text-align: center;
		}
		.Menu {
		width: 100%;
    	height: 70px;
    	font-size: 16px;
    	text-align: center;
		}
		.BookArea {
		width: 100%;
    	height: 1000px;
    	font-size: 16px;
    	text-align: center;
		}
	</style>
</head>
	<body>
	 <div class="Top">
		<jsp:include page="common/top.jsp" flush="true" />
	 </div>
		<br>
	 <div class="Menu">
		<jsp:include page="common/menu.jsp" flush="true" />
	 </div>
		<hr>
	 <div class="BookArea">
		<jsp:include page="goods/goodsList.jsp" flush="true" />
	 </div>
	</body>
</html>