<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- This is Jsp comments for declaration --%>
<%!
  
   public int add(int i,int j)
   {
	   int res=i+j;
	   return res;
   }

%>
<%-- This is script code --%>
<%
	//int s=add(4,5);
	int n=Integer.parseInt(request.getParameter("n1"));
	int m=Integer.parseInt(request.getParameter("n2"));
	int s=add(n,m);
	out.println("<h2>Addition is "+s+"</h2>");
	
%>
<a href="addition.html">Back</a>
</body>
</html>