<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="/WEB-INF/tld/hello.tld" prefix="mytag" %>
    
    
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My JSP</title>
</head>
<body>
       <p> This is implementation of My Custom Tag. 
       </p> 
        
     
    
      <mytag:hello>
           Welcome to my JSP Page.
      </mytag:hello>
        
       
     
          
        <b>Contents after the Tag .</b>
        
    
</body>
</html>