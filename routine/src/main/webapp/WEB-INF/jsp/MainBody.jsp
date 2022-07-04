<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="total_body_div">
	<main class="main">
		<div class="main_wrap">
			<div class="main_slider">
			
			</div>
			
			<div class="main_best10">
				<div class="commu_recent10">
					<div class="h_wrap">
						<h2 class="navi_h2">난 이렇게 먹어</h2>
						<a href="foodBoard">&#x2795;</a>
					</div>
					<ul class="navi_ul">
						<c:forEach items="${recentf }" var="f">
							<li class="recent_list">
								<a class="recent_a" href="detail?no=${f.exb_no }">${f.exb_title }</a>
							</li>
						</c:forEach>
					</ul>
				</div>
				<div class="commu_qna">
					<div class="h_wrap">
						<h2 class="navi_h2">난 이렇게 운동해</h2>
						<a href="exBoard">&#x2795;</a>
					</div>
					<ul class="navi_ul">
						<c:forEach items="${recentex }" var="ex">
							<li class="recent_list">
								<a class="recent_a" href="detail?no=${ex.exb_no }">${ex.exb_title }</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
		</div>
	</main>
</div>