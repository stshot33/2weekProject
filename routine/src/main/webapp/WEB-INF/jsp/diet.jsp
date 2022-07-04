<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/MainHeader.css">
<link rel="stylesheet" href="css/MainFooter.css">
<link rel="stylesheet" href="css/diet.css">
<title>Insert title here</title>
</head>
<body>
	<%@include file="MainHeader.jsp" %>
	
	<div class="main">
		<div class="diet_wrap">
			<div class="diet">
				<c:forEach items="${diet }" var="d">
					<div class="d_wrap">
						<span>${d.f_name }</span>
						<span class="d_right">${d.f_once }g</span>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	
	<%@include file="MainFooter.jsp" %>
	
	<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/MainHeader.js"></script>
</body>
</html>