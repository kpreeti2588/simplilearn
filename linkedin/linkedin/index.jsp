<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page 
errorPage="exceptionpage.jsp" 
language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<c:if test="${empty requestScope.msg }">
<c:out value="Message is empty"></c:out>
</c:if>

<c:if test="${not empty requestScope.msg }">
<p style="color: red;">
<c:out value="Message is not empty, ${requestScope.msg } "></c:out>
</p>
</c:if>


${requestScope.msg } 
<%Object val=request.getAttribute("msg");
if(val==null){
	
}
else{
	%>
	<p style="color: red;">
	<%=val%>
	</p>
<% }%>

<form action="/linkedin/LoginServlet" method="post">
<input type="text" name="username">
<input type="password" name="password">
<input type="submit" name="login" value="login">
</form>
	
<a href="/linkedin/registration.html">Sign Up</a>
Hello Server
</body>
</html>