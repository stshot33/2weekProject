<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/routine/myRoutine1.css">

<div class="main">
	<div class="main_wrap">
		<div class="ex">
			<c:forEach items="${division }" var="dvs">
				<ul>
					<li>${dvs.ex_name }</li>
					<li><img src="${dvs.ex_img }"></li>
				</ul>
			</c:forEach>
		</div>
	</div>
</div>