<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%pageContext.setAttribute("replaceChar", "/"); %>
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
	
	<div class="main_wrap">
		<div class="total_wrap">
			<div class="nav_wrap">
				<div class="nav_bar">
					<c:forEach items="${targetAll }" var="ex">
						<div class="nav_list">
							<a href="#${ex.ex_no }" class="scroll_move">${ex.ex_name }</a>
						</div>
					</c:forEach>
				</div>
			</div>			
			<div class="info_wrap">
				<div class="target_wrap">
					<h1>${target }</h1>
				</div>
				<div class="info_explanation">
					<c:forEach items="${targetAll }" var="info">
						<div class="explan_wrap" id="${info.ex_no }">
							<a class="ex_name">${info.ex_name }</a>
							<img class="ex_img" src="${info.ex_img }">
							<a class="ex_explan">${fn:replace(info.ex_explanation, replaceChar, "<br/>")}</a>
							${info.ex_video1 }
							${info.ex_video2 }
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="sub_wrap">
			
			</div>
		</div>
	</div>
	
	<%@include file="MainFooter.jsp" %>
	
	<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/MainHeader.js"></script>
	<script type="text/javascript" src="js/exercise.js"></script>
</body>
</html>