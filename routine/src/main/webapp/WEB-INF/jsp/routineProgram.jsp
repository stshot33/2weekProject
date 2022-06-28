<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/MainHeader.css">
<link rel="stylesheet" href="css/routineProgram.css">
<link rel="stylesheet" href="css/MainFooter.css">
<title>Insert title here</title>
</head>
<body>
	<%@include file="MainHeader.jsp" %>
	
	<div>
	 <form action="routineProgram" method="post">
	 	<div class="routine_division">
			<input type="radio" name="division" id="division1" value="1">
			<label for="division1">무분할</label>
			<input type="radio" name="division" id="division2" value="2">
			<label for="division2">2분할</label>
			<input type="radio" name="division" id="division3" value="3">
			<label for="division3">3분할</label>
		</div>
		
		<button type="submit">루틴 시작</button>
	 </form>
	</div>
	
	<%@include file="MainFooter.jsp" %>
	
	<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/MainHeader.js"></script>
</body>
</html>