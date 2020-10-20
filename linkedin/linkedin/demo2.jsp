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
<%--${param.username}<br>
${param.password}<br>
 <%  
out.write(request.getParameter("username")+"<br>");
out.write(request.getParameter("password")+"<br>"); 
%>
 --%>
<form action="" method="get">
<input type="text" name="username">
<input type="password" name="password">
<input type="submit" name="login" value="login">
<c:if test="${empty param.login}">
<c:out value="other button clicked"></c:out>
</c:if>

<c:if test="${not empty param.login}">
<c:out value="${param.username}"></c:out>
<c:out value="${param.password}"></c:out>
</c:if>

<%-- <%
if(request.getParameter("login")!=null){
	out.write("<br>"+request.getParameter("username")+"<br>");
	out.write(request.getParameter("password")+"<br>");
}
else{
	out.write("<br>"+"other button clicked");
}	
	%> --%>

</form>

</body>
</html>