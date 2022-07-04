<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/MainHeader.css">
<link rel="stylesheet" href="css/MainFooter.css">
<title>Insert title here</title>
</head>
<body>
	<%@include file="MainHeader.jsp" %>
	
	<c:set var="dvs" value="${dvs.division }"/>
		<c:if test="${dvs eq '1' }">
			<%@include file="routine/my1.jsp" %>
		</c:if>
		<c:if test="${dvs eq '2' }">
			<%@include file="routine/my2.jsp" %>
		</c:if>
		<c:if test="${dvs eq '3' }">
			<%@include file="routine/my3.jsp" %>
		</c:if>
	<%@include file="MainFooter.jsp" %>
	
	<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/MainHeader.js"></script>
</body>
</html>