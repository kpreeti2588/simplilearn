package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String phone = request.getParameter("phone");
		String company = request.getParameter("company");
		
		//store cookies 
				Cookie cookie1 = new Cookie("phone", phone);
				Cookie cookie2 = new Cookie("company", company);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				
		//store session
				HttpSession httpsession = request.getSession(false);
				httpsession.setAttribute("phone", phone);
				httpsession.setAttribute("company", company);
		
				// Store in Application scope
				ServletContext application = this.getServletContext();
				application.setAttribute("phone", phone);
				application.setAttribute("company", company);
				
				
		out.print("<form action='/instagram/ThirdServlet' method='POST'>"
				+"<input type='hidden' name='name' value="+name+">"
				+"<input type='hidden' name='salary' value="+salary+">"
				+"<input type='hidden' name='phone' value="+phone+">"
				+"<input type='hidden' name='company' value="+company+">"
				+"<input type='radio' name='gender' value='M'>Male"
				+"<input type='radio' name='gender' value='F'>Female"
				+"<input type='radio' name='gender' value='O'>Others"
				
				+"<input type='submit' name='save' value='save'>"
				+"</form>");
				
	}

}
