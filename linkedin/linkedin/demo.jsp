<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.simplilearn.model.EmployeeDetails"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.html"></jsp:include>
${requestScope.emp }

<c:if test="${empty requestScope.emp }">

<jsp:useBean id="emp" class="com.simplilearn.model.EmployeeDetails" scope="request"></jsp:useBean>
<jsp:setProperty property="id" name="emp" value="1234"/>
<jsp:setProperty property="name" name="emp" value="aziz"  />
<jsp:setProperty property="company" name="emp" value="zxcc"  />
<jsp:setProperty property="gender" name="emp" value="M"  />
<jsp:setProperty property="salary" name="emp" value="971234"  />
<jsp:setProperty property="phone" name="emp" value="931234"  />

<jsp:getProperty property="id" name="emp"/>	<br>
<jsp:getProperty property="name" name="emp" /><br>
<jsp:getProperty property="company" name="emp" /><br>
<jsp:getProperty property="gender" name="emp" /><br>
<jsp:getProperty property="salary" name="emp" /><br>
<jsp:getProperty property="phone" name="emp" /><br>

<c:out value="Object not available-- created"></c:out>
</c:if>

<c:if test="${not empty requestScope.emp }">
<c:out value="${requestScope.emp }"></c:out>
<c:out value="Object available--  not created"></c:out>
</c:if>

<%-- <% Object o = request.getAttribute("emp"); %>

<% if (o==null){
%>	

<jsp:useBean id="emp" class="com.simplilearn.model.EmployeeDetails" scope="request"></jsp:useBean>
<jsp:setProperty property="id" name="emp" value="1234"  />
<jsp:setProperty property="name" name="emp" value="aziz"  />
<jsp:setProperty property="company" name="emp" value="zxcc"  />
<jsp:setProperty property="gender" name="emp" value="M"  />
<jsp:setProperty property="salary" name="emp" value="971234"  />
<jsp:setProperty property="phone" name="emp" value="931234"  />

<jsp:getProperty property="id" name="emp"/>	<br>
<jsp:getProperty property="name" name="emp" /><br>
<jsp:getProperty property="company" name="emp" /><br>
<jsp:getProperty property="gender" name="emp" /><br>
<jsp:getProperty property="salary" name="emp" /><br>
<jsp:getProperty property="phone" name="emp" /><br>


<%
out.write("Object not available-- created");
}else{
	EmployeeDetails e = (EmployeeDetails)o;
	out.write(e+"");
	out.write("Object available-- not created");
}%> --%>

<%-- <%EmployeeDetails detail =new EmployeeDetails();
detail.setId(123);
detail.setName("nora");
detail.setPhone("123");
detail.setGender('F');
detail.setSalary(12345);
detail.setCompany("Vioon");
out.write(detail.getId());
out.write(detail.getName());
out.write(detail.getCompany());
out.write(detail.getGender());
out.write(detail.getPhone());
out.write(detail.getSalary()+"");

request.setAttribute("emp", detail);
application.setAttribute("emp", detail);
session.setAttribute("emp", detail);
pageContext.setAttribute("emp", detail);

%> --%>
<jsp:include page="footer.html"></jsp:include>
</body>
</html>