<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>CARE LAB</h1>
		<HR>
			<a href="${contextPath }/index">HOME</a>
			<c:if test="${loginUser != null }">
				<a href="${contextPath }/member/memberInfo">MEMBERS</a>
			</c:if>
			<c:if test="${loginUser == null }">
				<a href="${contextPath }/member/login">MEMBERS</a>
			</c:if>
			
			<c:if test="${loginUser != null }">
				<a href="${contextPath }/member/logout">LOGOUT</a>
			</c:if>
			<c:if test="${loginUser == null }">
				<a href="${contextPath }/member/login">LOGIN</a>
			</c:if>
		<HR>
	</header>
</body>
</html>