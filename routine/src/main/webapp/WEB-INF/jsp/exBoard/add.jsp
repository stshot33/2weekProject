<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/MainHeader.css">
<link rel="stylesheet" href="css/MainFooter.css">
<link rel="stylesheet" href="css/add.css">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../MainHeader.jsp" %>
		
	<form action="add" method="post">
		<input name="exb_title" placeholder="title">
		<input name="exb_text" placeholder="text">
		
		<button type="submit">등록</button>
	</form>

	<%@include file="../MainFooter.jsp" %>

	<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/MainHeader.js"></script>
</body>
</html>