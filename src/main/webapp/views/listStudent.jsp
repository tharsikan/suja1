<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="registerStudent">Register Student</a>
<h3>heloooooooooo</h3>
<%   
String name=request.getParameter("msg");  
out.print(name);  
%>  
</body>
</html>