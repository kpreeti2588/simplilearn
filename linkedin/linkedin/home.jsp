<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page 
errorPage="exceptionpage.jsp"
 language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<%-- <c:if test="${empty session}">
<c:redirect url="index.jsp"></c:redirect>
</c:if> --%>

<c:if test="${not empty sessionScope.user }">
Welcome  <c:out value="${sessionScope.user}"></c:out>
</c:if>

<%-- <% 
String name =null;
if(session==null){
	response.sendRedirect("/linkedin/index.jsp");
}
else{
	Object val = session.getAttribute("user");
	if(val==null){
		response.sendRedirect("/linkedin/index.jsp");
	}
	else{
	name = val.toString();
	}
%>
<br><br>
<p>Welcome <%=name%> </p>
<%} %> --%>

<a href="">Home</a>
<a href="">About</a>
<a href="">Contact Us</a>
<a href="">Share</a>
<!--  <a href="/linkedin/AllDetailsServlet">List</a>-->
<a href="GetDataContoller">List</a>
<a href="/linkedin/LogoutServlet">Logout</a>
	
</body>
</html>