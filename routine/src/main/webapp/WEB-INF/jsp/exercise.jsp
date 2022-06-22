<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/MainHeader.css">
<link rel="stylesheet" href="css/MainFooter.css">
<link rel="stylesheet" href="css/exercise.css">
<title>routine | ${target }</title>
</head>
<body>

	<%@include file="MainHeader.jsp" %>
	
	<c:forEach items="${targetAll }" var="ex">
		<div>
			${ex.ex_name }
		</div>
	</c:forEach>
	
	<%@include file="MainFooter.jsp" %>
	
	<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/MainHeader.js"></script>
</body>
</html>