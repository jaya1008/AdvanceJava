package com.Custom;
import java.io.IOException;
import java.util.Date;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport
{
	 public int doStartTag() throws JspTagException
     {
    	 try
    	 {
    		String name= pageContext.getRequest().getParameter("user");
    		 pageContext.getOut().write("<p> Hello , I am "+ name +"from custom tag <br/>");
    		 
    	 }
    	 catch(IOException e)
    	 {
    		 e.printStackTrace();
    	 }
    	 
    	 return EVAL_BODY_INCLUDE;
    	// return SKIP_BODY;
     }
	 
	 
	 public int doEndTag()throws JspException
     {
    	 
    	 try
    	 {
    		 pageContext.getOut().write("Hello once again");
    	
    		 
    		 
    	 }
    	 catch(IOException ex)
    	 {
    		 ex.printStackTrace();
    	 }
    	 
    	// return EVAL_PAGE;
    	 return SKIP_PAGE;
     }
     
}