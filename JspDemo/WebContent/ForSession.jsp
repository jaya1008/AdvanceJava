<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

	String user=request.getParameter("u1");
	session.setAttribute("user", user);
	//response.sendRedirect("SessionContinue.jsp");
%>
<h2><a href="SessionContinue.jsp">Click here to see session object data</a></h2>
<%@include file="Hello.jsp" %>
</body>
</html>