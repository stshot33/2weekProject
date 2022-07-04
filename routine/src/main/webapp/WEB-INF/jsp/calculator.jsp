<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/MainHeader.css">
<link rel="stylesheet" href="css/MainFooter.css">
<link rel="stylesheet" href="css/calculator.css">
<title>Insert title here</title>
</head>
<body>
	<%@include file="MainHeader.jsp" %>
	
	<div class="main">
		<div class="main_wrap">
		
			<form id="calculator" method="post">
				<div class="goal">
					<div class="input_wrap">
						<input type="radio" name="m_goal" id="m_goal1" value="1">
						<label for="m_goal1">벌크업</label>
					</div>
					<div class="input_wrap">
						<input type="radio" name="m_goal" id="m_goal2" value="2">
						<label for="m_goal2">유지</label>
					</div>
					<div class="input_wrap">
						<input type="radio" name="m_goal" id="m_goal3" value="3">
						<label for="m_goal3">다이어트</label>
					</div>
				</div>
				
				<div class="sex">
					<div class="input_wrap">
						<input type="radio" name="m_sex" id="male" value="1">
						<label for="male">남자</label>
					</div>
					<div class="input_wrap">
						<input type="radio" name="m_sex" id="female" value="2">
						<label for="female">여자</label>
					</div>
				</div>
			
				<div class="activity">
					<div class="input_wrap">
						<input type="radio" name="m_activity" id="m_activity1" value="1">
						<label for="m_activity1">활동량 적음</label>
					</div>
					<div class="input_wrap">
						<input type="radio" name="m_activity" id="m_activity2" value="2">
						<label for="m_activity2">활동량 보통</label>
					</div>
					<div class="input_wrap">
						<input type="radio" name="m_activity" id="m_activity3" value="3">
						<label for="m_activity3">활동량 많음</label>
					</div>
					<div class="input_wrap">
						<input type="radio" name="m_activity" id="m_activity4" value="4">
						<label for="m_activity4">활동량 매우 많음</label>
					</div>
				</div>
				<div class="info">
					<input name="m_weight" id="m_weight" placeholder="${info.m_weight }"><span>kg</span>
					<input name="m_height" id="m_height" placeholder="${info.m_height }"><span>cm</span>
				</div>
				<button class="subbtn" type="button">결과</button>
			</form>
			
			<div class="result">
				<h1>나에게 필요한 열량</h1>
				<div>
					<span class="total_kcal">0kcal</span>
				</div>
				<div class="kal_wrap">
					<div class="kal">
						<div class="kal_first">
							<span>탄수화물 :&nbsp</span>
						</div>
						<div>
							<span class="tan_kcal">0kcal</span>
						</div>
						&nbsp
						<div class="kal_last">
							<span class="tan_g">0g</span>
						</div>
					</div>
					<div class="kal">
						<div class="kal_first">
							<span>단백질 :&nbsp</span>
						</div>
						<div>
							<span class="dan_kcal">0kcal</span>
						</div>
						&nbsp
						<div class="kal_last">
							<span class="dan_g">0g</span>
						</div>
					</div>
					<div class="kal">
						<div class="kal_first">
							<span>지방 :&nbsp</span>
						</div>
						<div>
							<span class="zi_kcal">0kcal</span>
						</div>
						&nbsp
						<div class="kal_last">
							<span class="zi_g">0g</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="MainFooter.jsp" %>
	
	<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/MainHeader.js"></script>
	<script type="text/javascript" src="js/calculator.js"></script>
</body>
</html>