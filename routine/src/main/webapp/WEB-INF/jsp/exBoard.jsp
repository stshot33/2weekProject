<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/MainHeader.css">
<link rel="stylesheet" href="css/MainFooter.css">
<link rel="stylesheet" href="css/exBoard.css">
<title>Insert title here</title>
</head>
<body>
	<%@include file="MainHeader.jsp" %>
	
	<div class="main">
		<div class="board_wrap">
			<div class="board">
				<div class="board_top">
					<ul class="board_list">
						<li class="board_header"><a class="board_first">번호</a></li>
						<li class="board_header"><a class="board_first">이름</a></li>
						<li class="board_header"><a class="board_first">제목</a></li>
						<li class="board_header"><a class="board_first">작성 시간</a></li>
						<li class="board_header list"><a class="board_first">조회 수</a></li>
					</ul>
					<ul class="board_list">
					<c:forEach items="${boardInfo }" var="info">
						<li class="board_main">${info.exb_no }</li>
						<li class="board_main">${info.exm_name }</li>
						<li class="board_main"><a href="detail?no=${info.exb_no }">${info.exb_title }</a></li>
						<li class="board_main">${info.exb_time }</li>
						<li class="board_main">${info.exb_look }</li>
					</c:forEach>
					</ul>
				</div>
				<div class="board_bottom">
					<button onclick="location.href='add'">등록</button>
				</div>
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