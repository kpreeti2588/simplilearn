<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="num" value="1" scope="session"></c:set>
<%-- <c:catch var="e">
<%int c=10/0; %>
</c:catch>
<c:if test="${not empty e}">
<c:out value="${e.message}"></c:out>
</c:if> --%>
<c:choose>
<c:when test="${num eq 1}">Monday</c:when>
<c:when test="${num eq 2}">Tuesday</c:when>
<c:when test="${num eq 3}">Wednesday</c:when>
<c:when test="${num eq 4}">Thursday</c:when>
<c:when test="${num eq 5}">Friday</c:when>	
<c:when test="${num eq 6}">Saturday</c:when>

</c:choose>
<%--<c:set scope="session" name="user" value="admin"></c:set>
session.setAttribute("user",admin); --%>
User name is 
${param.username}<br>
Password is
${param.password}<br>

<c:out value="${param.username}"></c:out>
<c:out value="${param.password}"></c:out>
</body>
</html>