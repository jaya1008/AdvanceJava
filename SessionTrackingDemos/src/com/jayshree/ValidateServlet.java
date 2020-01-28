package com.jayshree;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String u=request.getParameter("user");
		String p=request.getParameter("pass");
		
		if(u.equals("jayshree")&& p.equals("jay@123"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("user", u);
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
			rd.forward(request, response);
		}
		else
		{
			pw.println("Invalid User !!!");
		}
	}

}
