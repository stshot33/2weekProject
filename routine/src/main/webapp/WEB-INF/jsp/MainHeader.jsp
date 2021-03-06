<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String nick = (String)session.getAttribute("nick");
	String sign = "";

	if(nick!=null) {
		sign = "<li class=\"navi_list\"><a id=\"custom-login-btn\" href=\"javascript:kakaoLogout()\">" + nick + "</a></li>";
	}else {
		sign = "<li class=\"navi_list\"><a id=\"custom-login-btn\" href=\"javascript:loginWithKakao()\">Sign In</a></li>";
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
					<a>식단</a>
					<div class="diet_list">
						<ul class="diet_list_wrap">
							<li class="diet_li">
								<a class="diet_a">식단 프로그램</a>
							</li>
							<li class="diet_li">
								<a class="diet_a">추천 식단</a>
							</li>
							<li class="diet_li">
								<a class="diet_a">비만도 계산기</a>
							</li>
							<li class="diet_li">
								<a class="diet_a">영양 계산기</a>
							</li>
						</ul>
					</div>
				</li>
				<li class="navi_list community_navi">
					<a>커뮤니티</a>
					<div class="community_list">
						<ul class="community_list_wrap">
							<li class="community_li">
								<a class="community_a">난 이렇게 먹어</a>
							</li>
						</ul>
						<ul class="community_list_wrap">
							<li class="community_li">
								<a class="community_a">난 이렇게 운동해</a>
							</li>
						</ul>
					</div>
				</li>
				<li class="navi_list">
					<a>Q&A</a>
				</li>
				<%=sign %>
			</ul>
		</div>
		<div class="header_wrap">
			<div class="logo_wrap">
				<a class="logo" href="main">
					<img class="logo_img" src="images/header/logo.svg">
				</a>
			</div>
			<div class="search_wrap">
				<input class="search_space" placeholder="search">
			</div>
		</div>
	</header>
</div>