package com.jayshree;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateServlet
 */
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		pw.println("<h1>Welcome to Validate Servlet</h1>");
		String u=request.getParameter("uname");
		pw.println("<h2>"+u+"</h2>");
		//Setting data in Request Object 
		request.setAttribute("pwd", "Jayshree");
		RequestDispatcher rd=request.getRequestDispatcher("ForRequestDispatcher");
		rd.include(request, response);
		pw.println("<h3>End of ValidateServlet Response .....</h3>");
	}

}
