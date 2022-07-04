<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String nick = (String)session.getAttribute("nick");
	String sign = "";
	String diet = "";
	String calculator = "";
	String routine = "";
	String foodcomu = "";
	String excomu = "";
	String qna = "";
	
	if(nick!=null) {
		sign = "<li class=\"navi_list\"><a id=\"custom-login-btn\" href=\"javascript:kakaoLogout()\">" + nick + "</a></li>";
		diet = "<a class=\"diet_a\" href=\"diet\">식단 프로그램</a>";
		calculator = "<a class=\"diet_a\" href=\"calorie\">칼로리 계산기</a>";
		routine = "<a class=\"diet_a\" href=\"routineProgram\">루틴 프로그램</a>";
		foodcomu = "<a class=\"community_a\" href=\"foodBoard\">난 이렇게 먹어</a>";
		excomu = "<a class=\"community_a\" href=\"exBoard\">난 이렇게 운동해</a>";
		qna = "<a class=\"nav_a\" href=\"qna\">Q&A</a>";
	}else {
		sign = "<li class=\"navi_list\"><a id=\"custom-login-btn\" href=\"javascript:loginWithKakao()\">Sign In</a></li>";
		diet = "<a class=\"diet_a\" href=\"javascript:loginWithKakao()\">식단 프로그램</a>";
		calculator = "<a class=\"diet_a\" href=\"javascript:loginWithKakao()\">칼로리 계산기</a>";
		routine = "<a class=\"diet_a\" href=\"javascript:loginWithKakao()\">루틴 프로그램</a>";
		foodcomu = "<a class=\"community_a\" href=\"javascript:loginWithKakao()\">난 이렇게 먹어</a>";
		excomu = "<a class=\"community_a\" href=\"javascript:loginWithKakao()\">난 이렇게 운동해</a>";
		qna = "<a class=\"nav_a\" href=\"javascript:loginWithKakao()\">Q&A</a>";
	}
%>

<div class="total_header_div">
	<header>
		<div class="navi">
			<ul class="navi_list_ul">
				<li class="navi_list ex_navi">
					<a>운동</a>
					<div class="ex_list">
						<ul class="ex_list_wrap">
							<li class="ex_li"><a class="ex_a" href="exercise?target=1">가슴</a></li>
							<li class="ex_li"><a class="ex_a" href="exercise?target=2">팔</a></li>
							<li class="ex_li"><a class="ex_a" href="exercise?target=3">복근</a></li>
							<li class="ex_li"><a class="ex_a" href="exercise?target=4">등</a></li>
							<li class="ex_li"><a class="ex_a" href="exercise?target=5">어깨</a></li>
							<li class="ex_li"><a class="ex_a" href="exercise?target=6">다리</a></li>
						</ul>
					</div>
				</li>
				<li class="navi_list diet_navi">
					<a>프로그램</a>
					<div class="diet_list">
						<ul class="diet_list_wrap">
							<li class="diet_li">
								<%=diet %>
							</li>
							<li class="diet_li">
								<%=calculator %>
							</li>
							<li class="diet_li">
								<%=routine %>
							</li>
						</ul>
					</div>
				</li>
				<li class="navi_list community_navi">
					<a>커뮤니티</a>
					<div class="community_list">
						<ul class="community_list_wrap">
							<li class="community_li">
								<%=foodcomu %>
							</li>
						</ul>
						<ul class="community_list_wrap">
							<li class="community_li">
								<%=excomu %>
							</li>
						</ul>
					</div>
				</li>
				<li class="navi_list">
					<%=qna %>
				</li>
				<%=sign %>
			</ul>
		</div>
		<div class="header_wrap">
			<div class="logo_wrap">
				<a class="logo" href="/routine/main">
					<img class="logo_img" src="images/header/logo.svg">
				</a>
			</div>
		</div>
	</header>
</div>