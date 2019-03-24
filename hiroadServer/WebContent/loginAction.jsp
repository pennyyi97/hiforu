<%--     <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- B) -->
<c:choose >
	<c:when test="${!empty login}">
		환영합니다 ${login} 님!
		<a href="hiroad?cmd=logout">[로그아웃]</a>
	</c:when>
	<c:otherwise>
		<script>
			alert('회원 전용');
			location.href="index.html";
		</script>
	</c:otherwise>
</c:choose> --%>
