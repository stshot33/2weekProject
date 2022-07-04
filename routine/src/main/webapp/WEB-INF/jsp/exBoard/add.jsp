<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String board = request.getParameter("board");
%>
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

	<div class="main_wrap">
		<div class="board_main">
			<div class="board_wrap">
				<div class="form_wrap">
					<form action="add?board=<%=board %>" method="post">
						<div class="input_wrap">
							<div class="inputs">
								<input class="input_title" name="exb_title" placeholder="제목을 입력해주세요.">
								<textarea class="input_text" rows="" cols="" name="exb_text" placeholder="내용을 입력해주세요."></textarea>
								
								<button type="submit">게시물 등록</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%@include file="../MainFooter.jsp" %>
	
	<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/MainHeader.js"></script>
</body>
</html>