<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" errorPage="MyErrorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	Connection con=null;
    public Connection getConnection() throws Exception
    {
    	
		Class.forName("com.mysql.jdbc.Driver");
		
		//step-2
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jayshreedb", 
				"root", "root");
		
    	return con;
    }

%>

Connection is <%=getConnection() %>
<%
	String dname=application.getInitParameter("developername");
	out.println(dname);

%>
	<%=dname %>
</body>
</html>