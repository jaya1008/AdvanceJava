package com.jayshree;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForRequestDispatcher
 */
public class ForRequestDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForRequestDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=	response.getWriter();
		pw.println("<h1>Another Servlet get called from ValidateServlet</h1>");
		String nm=request.getParameter("uname");
		
		
		pw.println("<h3>User name from validateServlet is "+nm+"</h3>");
		//fetching the resuest attribute
		String p=(String) request.getAttribute("pwd");
		pw.println("<h3>Password from validateServlet explict data is "+p+"</h3>");
		pw.println("<h3>End of ForRequestDispatcher Response .....</h3>");
	}

}
