<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/routine/myRoutine2.css">

<div class="main">
	<div class="main_wrap">
		<div class="ex">
			<h1>상체 운동</h1>
			<ul>
				<c:forEach var="i" begin="0" end="11" step="1">
					<div class="li_wrap">
						<li>${division[i].ex_name }</li>
						<li><img src="${division[i].ex_img }"></li>
					</div>
				</c:forEach>
			</ul>
			<h1>하체 운동</h1>
			<ul>
				<c:forEach var="j" begin="12" end="14" step="1">
					<div class="li_wrap">
						<li>${division[j].ex_name }</li>
						<li><img src="${division[j].ex_img }"></li>
					</div>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>