<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/MainHeader.css">
<link rel="stylesheet" href="css/MainFooter.css">
<link rel="stylesheet" href="css/routineProgram.css">
<title>Insert title here</title>
</head>
<body>
	<%@include file="MainHeader.jsp" %>
	
	<div class="main">
	 <form action="routineProgram" method="post">
	 	<div class="division_wrap">
	 		<div class="explanation">
				<h1>
					하고 싶은 루틴을 선택하고 시작 버튼을 눌러주세요!				
				</h1>
			</div>
	 		<div class="routine_division">
	 			<div class="select">
		 			<input type="radio" name="division" id="division1" value="1">
					<label for="division1">무분할</label>
	 			</div>
				<div class="select select_second">
					<input type="radio" name="division" id="division2" value="2">
					<label for="division2">2분할</label>
				</div>
				<div class="select">
					<input type="radio" name="division" id="division3" value="3">
					<label for="division3">3분할</label>
				</div>
			</div>
			<div class="btn_wrap">
				<button type="submit">루틴 시작</button>
			</div>
	 	</div>
	 </form>
	</div>
	
	<%@include file="MainFooter.jsp" %>
	
	<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/MainHeader.js"></script>
	
</body>
</html>