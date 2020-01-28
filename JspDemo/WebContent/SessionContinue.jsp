<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

session=request.getSession();
String uname=(String)session.getAttribute("user");
out.println("<h2> Using Implicit session Object getting data "+uname+"</h2>");
%>
</body>
</html>