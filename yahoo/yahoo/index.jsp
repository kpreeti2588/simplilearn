<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index page</title>
</head>
<body>
Hello I am from JSP

<% 
String name = "My name is khan";
System.out.println("hello from console"); %>
<%=name %>
<%print(); %>
<%! String globalVariable= "Global Values";
public void print(){
	System.out.println(globalVariable);
}
%>
</body>
</html>