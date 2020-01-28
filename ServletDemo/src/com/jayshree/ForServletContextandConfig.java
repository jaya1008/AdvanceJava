package com.jayshree;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForServletContextandConfig
 */
public class ForServletContextandConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForServletContextandConfig() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
		System.out.println("in init ()");
		//config.getInitParameter("developerName");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cnm=getServletContext().getInitParameter("companyName");
	//2 	getServletConfig().getServletContext().getInitParameter(name)
		PrintWriter pw=	response.getWriter();
		pw.println("<h3>Company Name is "+cnm+"</h3>");
		
		ServletConfig config=getServletConfig();
		String dnm=config.getInitParameter("developerName");		
	
		pw.println("<h3>Develop by "+dnm+"</h3>");
		
	}

}
