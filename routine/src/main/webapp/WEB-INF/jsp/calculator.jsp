<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	
	<div>
		<form action="calorie" method="post">
			<div class="goal">
				<input type="radio" name="m_goal" id="m_goal1" value="1">
				<label for="m_goal1">벌크업</label>
				<input type="radio" name="m_goal" id="m_goal2" value="2">
				<label for="m_goal2">유지</label>
				<input type="radio" name="m_goal" id="m_goal3" value="3">
				<label for="m_goal3">다이어트</label>
			</div>
			
			<div class="sex">
				<input type="radio" name="m_sex" id="male" value="1">
				<label for="male">남자</label>
				<input type="radio" name="m_sex" id="female" value="2">
				<label for="female">여자</label>
			</div>
		
			<div class="activity">
				<input type="radio" name="m_activity" id="m_activity1" value="1">
				<label for="m_activity1">활동량 적음</label>
				<input type="radio" name="m_activity" id="m_activity2" value="2">
				<label for="m_activity2">활동량 보통</label>
				<input type="radio" name="m_activity" id="m_activity3" value="3">
				<label for="m_activity3">활동량 많음</label>
				<input type="radio" name="m_activity" id="m_activity4" value="4">
				<label for="m_activity4">활동량 매우 많음</label>
			</div>
		
			<input name="m_weight" id="m_weight" placeholder="${info.m_weight }">kg
			<input name="m_height" id="m_height" placeholder="${info.m_height }">cm
			
			<button type="submit">계산하기</button>
		</form>
		
		<div>
			${calorie.m_calorie }kcal
			<br>
			${calorie.tan }kcal&nbsp<fmt:formatNumber type="number" value="${calorie.tan / 4 }" pattern="#.#" />g
			<br>
			${calorie.dan }kcal&nbsp<fmt:formatNumber type="number" value="${calorie.dan / 4 }" pattern="#.#" />g
			<br>
			${calorie.zi }kcal&nbsp <fmt:formatNumber type="number" value="${calorie.zi / 9 }" pattern="#.#" />g
		</div>
	</div>
	
	<%@include file="MainFooter.jsp" %>
	
	<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/MainHeader.js"></script>
</body>
</html>