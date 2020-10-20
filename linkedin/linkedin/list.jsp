<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List" %>
<%@page 
buffer="8kb" autoFlush="true" isThreadSafe="true" 
errorPage="exceptionpage.jsp" 
import="com.simplilearn.model.EmployeeDetails"   language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table border='1'>
<tr><td>EmpId</td><td>EmpName</td><td>Phone</td><td>Gender</td><td>Salary</td><td>Company</td></tr>
<c:if test="${not empty requestScope.employees }">
<c:out value="Data is available"></c:out>
<c:forEach items="${requestScope.employees}" var="emp">
<tr><td>${emp.id}</td>
<td>${emp.name}</td>
<td>${emp.phone}</td>
<td>${emp.gender}</td>
<td>${emp.salary}</td>
<td>${emp.company}</td></tr>
</c:forEach>
</c:if>
</table>

<c:if test="${empty requestScope.employees }">
<c:redirect url="error.jsp"></c:redirect>
<c:out value="Data is not available in the database"></c:out>
</c:if>


<%-- <%out.write(10/0); %> --%>
<%-- <% Object data = request.getAttribute("employees"); 
if(data==null){
	response.sendRedirect("/linkedin/error.jsp");
}else{

 List<EmployeeDetails> details = (List)data; 

%>
<%
	out.print("<table border='1'>");
			out.print("<tr><td>EmpId</td><td>EmpName</td><td>Phone</td><td>Gender</td><td>Salary</td><td>Company</td></tr>");
			
			for (EmployeeDetails employeeDetails : details) {
				out.println("<tr>");
				out.print("<td>"+employeeDetails.getId()+"</td>");
				out.print("<td>"+employeeDetails.getName()+"</td>");
				out.print("<td>"+employeeDetails.getPhone()+"</td>");
				out.print("<td>"+employeeDetails.getGender()+"</td>");
				out.print("<td>"+employeeDetails.getSalary()+"</td>");
				out.print("<td>"+employeeDetails.getCompany()+"</td>");
				
				
				out.println("</tr>");
			//	out.print("</table>");
				
			//	out.println(employeeDetails);
			}
			out.print("</table>");
			%>
<%} %>		 --%>
</body>
</html>