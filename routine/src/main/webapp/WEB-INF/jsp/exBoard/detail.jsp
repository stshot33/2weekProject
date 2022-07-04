<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/MainHeader.css">
<link rel="stylesheet" href="css/MainFooter.css">
<link rel="stylesheet" href="css/detail.css">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../MainHeader.jsp" %>
	
	<div class="main_wrap">
		<div class="board_main">
			<div class="board_wrap">
				<div class="board_title">
					<span>${detail.exb_title }</span>
				</div>
				<div class="board_text">
					<span>${detail.exb_text }</span>
				</div>
				<div class="form_wrap">
					<div class="nick_wrap">
						닉네임 :&nbsp<span><%=nick %></span>
					</div>
					<form id="answer" method="post">
						<input name="no" id="no" value="${detail.exb_no }" readonly hidden>
						<textarea name="a_text" id="a_text" placeholder="댓글을 작성해주세요."></textarea>
						
						<button class="answerbtn" type="button">등록</button>
					</form>
				</div>
				<c:forEach items="${answers }" var="ans">
					<div class="allanswer">
						<div class="answer_info">
							<div class="answer_top">
								<span>닉네임 :&nbsp${ans.am_name }</span>
								<span>작성일 :&nbsp${ans.a_time }</span>
							</div>
							<div class="answer_bottom">
								${ans.a_text }
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<%@include file="../MainFooter.jsp" %>
	
	<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/MainHeader.js"></script>
	<script type="text/javascript" src="js/answer.js"></script>
</body>
</html>